import java.util.*;
class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node,int level){
        this.node=node;
        this.level=level;
    }
 }
class Solution {
    public int maxLevelSum(TreeNode root) {
        int min=Integer.MIN_VALUE;int ans=-1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,1));
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;int curr=0;
            for(int i=0;i<n;i++){
                 Pair p=q.poll();
                 TreeNode node=p.node;
                 int level=p.level;
                 sum+=node.val;
                 curr=level;
                 if(node.left!=null){
                    q.add(new Pair(node.left,level+1));
                 }
                 if(node.right!=null){
                    q.add(new Pair(node.right,level+1));
                 }
                 
            }
            if(sum>min){
                min=sum;
                ans=curr;
            }
        }
        return ans;
    }
}


  
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
       this.left = left;
         this.right = right;
    }
 }
 