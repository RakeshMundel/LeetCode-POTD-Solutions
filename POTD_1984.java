import java.util.Arrays;

public class POTD_1984 {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0 ;
        int n=nums.length;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i =0 ; i+k-1<n;i++){
            int curr = nums[i+k-1]-nums[i];
            min=Math.min(curr,min);
        }  
        return min ;
     
    }

}

