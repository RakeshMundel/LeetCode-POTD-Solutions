
public class POTD_3315 {
    
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            boolean flag=false;
            if((nums.get(i)&1)==0){
                ans[i]=-1;
                continue;
            }
            for(int j=0;j<32;j++){
                if((nums.get(i)&(1<<j))>0)continue;
                int prev=j-1;
                int x=nums.get(i)^(1<<prev);
                ans[i]=x;
                flag=true;
                break;
            }
            if(!flag)ans[i]=-1;
        }
        return ans;
    }
}