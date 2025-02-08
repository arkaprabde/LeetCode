import java.util.*;
class NumberContainers
{
    Map<Integer, PriorityQueue<Integer>> mp1;
    Map<Integer, Integer> mp2;
    public NumberContainers()
    {
        mp1 = new HashMap<>();
        mp2 = new HashMap<>();
    }
    public void change(int index, int number)
    {
        if (mp2.containsKey(index))
        {
            int x = mp2.get(index);
            if (x == number)
                return;
            mp1.get(x).remove(index);
        }
        mp1.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        mp2.put(index, number);
    }
    
    public int find(int number)
    {
        PriorityQueue<Integer> pq = mp1.getOrDefault(number, new PriorityQueue<>());
        return pq.isEmpty() ? -1 : pq.peek();
    }
}