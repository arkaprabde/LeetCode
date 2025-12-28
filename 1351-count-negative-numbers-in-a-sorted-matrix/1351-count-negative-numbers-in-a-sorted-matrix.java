class Solution {
    public int countNegatives(int[][] grid) {
        int c = 0;
        for (int a[]: grid) {
            int l = 0, h = a.length, m = 0;
            while(l < h) {
                m = l + (h - l) / 2;
                if (a[m] < 0) h = m;
                else l = m + 1;
            }
            // System.out.println(a.length - l);
            c += a.length - l;
        }
        return c;
    }
}