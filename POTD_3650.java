class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
class POTD_3650 {
    public int minCost(int n, int[][] edges) {
        
        int [][]newEdges=new int[2*edges.length][3];
        int c=0;
        for(int i=0;i<edges.length;i++){
            newEdges[i][0]=edges[i][0];
            newEdges[i][1]=edges[i][1];
            newEdges[i][2]=edges[i][2];
            c++;
        }
        for(int i=0;i<edges.length;i++){
            newEdges[c][0]=edges[i][1];
            newEdges[c][1]=edges[i][0];
            newEdges[c][2]=2*edges[i][2];
            c++;
        }
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<newEdges.length;i++){
            adj.get(newEdges[i][0]).add(new Pair(newEdges[i][1],newEdges[i][2]));
        }
       
        int []dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.node;
            int dis=p.distance;
            for(Pair it:adj.get(x)){
                int node=it.node;
                int newD=it.distance;
                if((dis+newD)<dist[node]){
                    dist[node]=dis+newD;
                    pq.add(new Pair(node,newD+dis));
                }
                

            }
        }
        return dist[n-1]==Integer.MAX_VALUE?-1:dist[n-1];
    }
}