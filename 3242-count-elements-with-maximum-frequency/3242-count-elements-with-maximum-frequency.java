class Solution {
    public int maxFrequencyElements(int[] nums) {
        int hash[] = new int[101];
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            hash[nums[i]]++;
            max = Math.max(max,hash[nums[i]]);
        }
        int ans = 0;
        for(int i = 0;i<hash.length;i++){
            if(hash[i]==max)ans+=hash[i];
        }
        return ans;
    }
}