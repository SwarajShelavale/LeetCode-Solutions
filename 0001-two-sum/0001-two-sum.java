class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(target-nums[i]))
            {
                int x=mp.get(target-nums[i]);
                int y=i;
               return new int[]{x,y};
            }
            else
            {
                mp.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}