public class POTD_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int minDiff=Integer.MAX_VALUE;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
           if((arr[i]-arr[i-1])==minDiff){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(arr[i-1]);
            x.add(arr[i]);
            ans.add(x);
           }
        }
        return ans;
    }
}