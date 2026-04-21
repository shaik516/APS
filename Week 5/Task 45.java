class Solution {
    List<String> li=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return li;
    }
    public void dfs(TreeNode root){
        int len = sb.length();
        if(root.left==null && root.right==null){
            sb.append(root.val);
            li.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append(root.val+"->");
        if(root.left!=null){
            dfs(root.left);
        }
        if(root.right!=null){
            dfs(root.right);
        }
        sb.setLength(len);
        }
}