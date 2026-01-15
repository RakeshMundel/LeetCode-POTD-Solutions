class POTD_2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);Arrays.sort(vBars);
        int noOfh=findconsecutive(hBars)+1;
        int noOfv=findconsecutive(vBars)+1;
        int min=Math.min(noOfv,noOfh);
        int area=min*min;
        return area;
    }
    public static int findconsecutive(int[]arr){
        int n=arr.length;
        int max=0;int cnt=1;
        if(n==1)return cnt;
        for(int i=1;i<n;i++){
            if((arr[i]-arr[i-1])==1){
                cnt++;
            }else{
                cnt=1;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }
}