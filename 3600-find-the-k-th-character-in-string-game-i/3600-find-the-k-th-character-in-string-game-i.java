class Solution {
    public char kthCharacter(int k) {
        int p = 1;
        for(; p < k; p *= 2);
        int c = 0;
        while(k > 1) {
            p /= 2;
            if(k <= p) continue;
            k -= p;
            c++;
        }
        return (char)('a' + c % 26);
    }
}