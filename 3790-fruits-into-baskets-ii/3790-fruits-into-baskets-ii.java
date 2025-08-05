class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int c = 0, n = fruits.length;
        boolean full[] = new boolean[n];
        fruit: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i] && !full[j]) {
                    full[j] = true;
                    continue fruit;
                }
            }
            c++;
        }
        return c;
    }
}