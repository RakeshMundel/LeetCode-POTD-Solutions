import java.util.*;
public class POTD_2975 {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        
        int[]h=new int[hFences.length+2];
        int[]v=new int[vFences.length+2];
        HashSet<Integer>set=new HashSet<>();
        h[0]=1;h[h.length-1]=m;
        v[0]=1;v[v.length-1]=n;
        for(int i=0;i<hFences.length;i++){
            h[i+1]=hFences[i];
        }
        for(int i=0;i<vFences.length;i++){
            v[i+1]=vFences[i];
        }
        Arrays.sort(h);Arrays.sort(v);
        int diff=0;
        for(int i=0;i<h.length;i++){
            for(int j=i+1;j<h.length;j++){
                diff=h[j]-h[i];
                set.add(diff);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<v.length;i++){
            for(int j=i+1;j<v.length;j++){
                if(set.contains(v[j]-v[i])){
                    max=Math.max(max,v[j]-v[i]);
                }
            }
        }
        if(max==Integer.MIN_VALUE)return -1;
        int mod = 1000000007;
        return (int)((1L*max*max)%mod);
        
    }
}
