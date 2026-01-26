public class POTD_1877 {
    
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int left = 0;
        int right=n-1;
        for(int i=0;i<n;i++){
            int sum=nums[left]+nums[right];
            left++;
            right--;
            max=Math.max(max,sum);

        }
        return max;
        
    }
}