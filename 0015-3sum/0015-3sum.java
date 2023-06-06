class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
         int n=nums.length;
         List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int j=i+1,k=n-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        res.addAll(s);
        return res;
    }
}

