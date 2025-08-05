class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int c = 0, n = fruits.length;
        fruit: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    continue fruit;
                }
            }
            c++;
        }
        return c;
    }
}