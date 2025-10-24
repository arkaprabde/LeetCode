class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArr, (a,b) -> ((b+""+a).compareTo(a+""+b)));
        if(numsArr[0] == 0) return "0";
        StringBuilder res = new StringBuilder();
        for (Integer x: numsArr) res.append(x);
        return res.toString();
    }
}
