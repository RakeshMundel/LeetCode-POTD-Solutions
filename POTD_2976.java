public class POTD_2976 {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][]matrix=new int[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
                
            }
        }
        for(int i=0;i<original.length;i++){
            matrix[original[i]-'a'][changed[i]-'a']=Math.min( matrix[original[i]-'a'][changed[i]-'a'],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(matrix[i][k]!=Integer.MAX_VALUE && matrix[k][j]!=Integer.MAX_VALUE){
                        matrix[i][j]=Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                    }
                }
            }
        }
        long minCost=0;
    for(int i=0;i<source.length();i++){
        char ch1=source.charAt(i);
        char ch2=target.charAt(i);
        if(matrix[ch1-'a'][ch2-'a']==Integer.MAX_VALUE)return -1;
        minCost+=matrix[ch1-'a'][ch2-'a'];
    }

    return minCost;
        
    }
}
