class Solution {
    public long gcdSum(int[] nums) {
        int max = 0;
        int n = nums.length;
        int[] prefixGrid = new int[n];
        for(int i = 0;i < n; i++){
            max = Math.max(nums[i],max);
            prefixGrid[i] = gcd(nums[i],max);
        }
        //sort
        Arrays.sort(prefixGrid);
        //aes order
        long ans = 0;
        for(int i = 0; i<n/2;i++){
            ans += gcd(prefixGrid[i],prefixGrid[n - 1 - i]);
           
        }
         return ans;
    }
    private int gcd(int a,int b){
            while(b != 0){
                int temp = b;
                b = a % b;
                a = temp;
            
        }
        return a;
        
    }
}