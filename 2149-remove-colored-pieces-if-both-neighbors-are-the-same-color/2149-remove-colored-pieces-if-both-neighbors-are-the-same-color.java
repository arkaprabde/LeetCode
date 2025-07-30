class Solution {
    public boolean winnerOfGame(String colors) {
        int c = 0;
        char a = ' ', b = ' ';
        for (char x: colors.toCharArray()) {
            if (x == a && x == b) {
                c += (x == 'A'?1 : -1);
            }
            a = b;
            b = x;
        }
        return c > 0;
    }
}