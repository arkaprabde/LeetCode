class ProductOfNumbers
{
    List<Integer> arr;
    int p;
    public ProductOfNumbers()
    {
        arr = new ArrayList<>();
        p = 1;
    }
    
    public void add(int num)
    {
        if(num == 0)
        {
            arr = new ArrayList<>();
            p = 1;
            return;
        }
        p *= num;
        arr.add(p);
    }
    
    public int getProduct(int k)
    {
        int n = arr.size();
        if(n < k)
            return 0;
        if(n == k)
            return arr.get(n - 1);
        return arr.get(n - 1) / arr.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */