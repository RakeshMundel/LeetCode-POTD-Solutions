public class POTD_3507 {
    
    public int minimumPairRemoval(int[] nums) {
        int operations=0;int n=nums.length;
        ArrayList<Integer>lst=new ArrayList<>();
        for(int it:nums){
            lst.add(it);
        }
        while(!isNonDec(lst)){
            int min=Integer.MAX_VALUE;
            int ind=0;
            for(int i=0;i<lst.size()-1;i++){
                int sum=lst.get(i)+lst.get(i+1);
                if(sum<min){
                    ind=i;
                    min=sum;
                }
            }
            lst.set(ind,min);
            lst.remove(ind+1);
            operations++;
        }
        return operations;
    }
    public static boolean isNonDec(ArrayList<Integer>lst){
        int n=lst.size();
        for(int i=0;i<n-1;i++){
            if(lst.get(i)>lst.get(i+1)){
                return false;
            }
        }
        return true;
    }
}