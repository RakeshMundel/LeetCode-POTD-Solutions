public class POTM_712 {
     public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();int cnt=0;
        int [][]dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            cnt+=s1.charAt(i)-0;
        }
        for(int i=0;i<m;i++){
            cnt+=s2.charAt(i)-0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1)-0;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int nondelete=2*dp[n][m];
        return cnt-nondelete;
    }
}
