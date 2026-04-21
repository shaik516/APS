class Solution {
    int count=0;
    int ans=-1;
   
    public int kthSmallest(TreeNode root, int k) {
        if(root.left!=null){
            kthSmallest(root.left,k);
        }
        count++;
        if(k==count){
            ans=root.val;
            return ans;
        }
        if(root.right!=null){
            kthSmallest(root.right,k);
        }
        return ans;
        
        
    }
}