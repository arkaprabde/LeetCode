class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {}
        int c = 0;
        for(int i1 = 0, i2 = 0; i1 < players.length && i2 < trainers.length;) {
            if(players[i1] <= trainers[i2]) {
                c++;
                i1++;
                i2++;
            } else i2++;
        }
        return c;
    }
}