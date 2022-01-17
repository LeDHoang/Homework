class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class ValidateBinary {
    Node max(Node node){

    }
    Node min (Node node){

    }
    boolean checkingBinary(Node node){
        if(node==null)
            return true;
        //Check if max of left child is >= node data
        if(node.left!=null&&max(Node.left)>=node.data)
            return false;
        //Check if the min on the right is <= node data
        if(node.right!=null&&min(Node.right)<=node.data)
            return false;
        //Recursively check left and right children
        if(!checkingBinary(node.left)||!checkingBinary(node.right))
            return false;
        // otherwise pass
        return true;

    }
}
