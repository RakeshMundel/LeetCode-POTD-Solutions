public class POTD_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int n=mat.length;
        int m=mat[0].length;

        int[][]preSum=new int[n][m];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=mat[i][j];
                preSum[i][j]=sum;
            }
        }
        int ans=0;int max=Integer.MIN_VALUE;
        for(int side=Math.min(m,n);side>0;side--){
             for(int i=0;i+side-1<n;i++){
                for(int j=0;j+side-1<m;j++){
                    int total=0;
                    boolean flag=true;
                    for(int k=i;k<i+side;k++){
                        total+=preSum[k][j+side-1]-(j>0?preSum[k][j-1]:0);
                    }
                    if(total<=threshold){
                        ans=Math.max(side,max);
                        return ans;
                    }else{
                         continue;
                    }

                }
             }

        }
        return ans;
    }
}