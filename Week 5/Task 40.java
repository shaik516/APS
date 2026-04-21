class Solution {
    private List<Integer> res;

    private void preorder(TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        preorder(root);
        return res;
    }
}