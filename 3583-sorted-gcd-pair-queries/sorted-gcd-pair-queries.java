class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int m =0;
        for(int num : nums){
        m = Math.max(m,num);
        }

        //count freuency
        long[] cnt = new long[m+1];
        for(int num : nums){
            cnt[num]++;
        }
        

        //count no.of pairs
        for(int i=1;i<=m;i++){
            for(int j = i*2;j<=m;j +=i){
                cnt[i] += cnt[j];
            }
        }
        // form pairs
        for(int i =1;i<= m;i++){
            cnt[i] = cnt[i] * (cnt[i] - 1)/2;
        }
        //inclusion- exclusion
        for(int i = m; i >= 1;i--){
            for(int j = i*2; j <= m;j += i){
                cnt[i] -= cnt[j];
            }
        }
        //prefix sum
        for(int i = 1;i<=m;i++){
            cnt[i] += cnt[i-1];
        }
        //answer
        int x = queries.length;
        int[] ans = new int[queries.length];
         for(int i = 0; i < x;i++){
            long target = queries[i]+1;
            int left = 1;
            int right = m;
            while(left < right){
                int mid = left + (right - left)/2;

                if(cnt[mid] >= target){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            ans[i] = left;
         }
         return ans;

    }
}