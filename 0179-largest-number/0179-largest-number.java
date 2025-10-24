class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArr, (a,b) -> ((b+""+a).compareTo(a+""+b)));
        if(numsArr[0] == 0) return "0";
        return Arrays.stream(numsArr).map(String::valueOf).collect(Collectors.joining());
    }
}
