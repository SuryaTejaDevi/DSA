class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       int i = n-2;
       
       while(i >= 0 && nums[i] >= nums[i+1]){
        i--;
       }
       if(i == -1){
        Arrays.sort(nums);
        return;
       }
       int j = n-1;
       while(nums[j] <= nums[i]){
        j--;
       }
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
       Arrays.sort(nums,i+1,n);

        
    }
}