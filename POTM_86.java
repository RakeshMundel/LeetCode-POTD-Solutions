class POTD_85 {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]suffix=new int[n][m];
        if(n==0)return 0;
        
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='0')sum=0;
                else{
                sum+=1;
                }
                suffix[i][j]=sum;
            }
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,rectArea(suffix[i]));
        }
        return maxArea;
    }
    static int rectArea(int[]area){
        int n=area.length;int nse,pse,elem;
        int max=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& area[st.peek()]>area[i]){
                elem=st.peek();
                st.pop();
                nse=i;
                pse=st.isEmpty()?-1:st.peek();
                max=Math.max(area[elem]*(nse-pse-1),max);
                
            }
            st.push(i);
        }
         while(!st.isEmpty()){
            nse=n;
            elem=st.peek();
            st.pop();
            pse=st.isEmpty()?-1:st.peek();
            max=Math.max(area[elem]*(nse-pse-1),max);
                
            }
            return max;
    }
}