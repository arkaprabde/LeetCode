class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int x: basket1) mp.put(x, mp.getOrDefault(x, 0) + 1);
        for (int x: basket2) mp.put(x, mp.getOrDefault(x, 0) - 1);
        long d = 0;
        for (int x: mp.keySet()) {
            int y = Math.abs(mp.get(x));
            if (y % 2 != 0) return -1;
            mp.put(x, y / 2);
            d += y / 2;
        }
        d /= 2;
        long c = 0;
        int mn = mp.firstKey();
        for (int x : mp.keySet()) {
            int y = mp.get(x);
            //System.out.println(x + " " + y);
            c += Math.min(d, y) * Math.min(x, 2 * mn);
            d -= y;
            if (d <= 0) break;
        }
        return c;
    }
}