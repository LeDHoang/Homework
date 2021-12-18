import java.util.Stack;

public class Inorder_Interative {
    //Logic:
    //Create an empty stack
    //variable temp as node that are checking
    //Push temp to stack and set temp = left child and repeat till theres no left child left
    //If theres no left child, pop/print the stack
    //temp  = popped node right child --> repeat the loop

    //Node class
    class Node {

        int data;
        Node left_node, right_node;

        Node(int item) {
            data = item;
            left_node = null;
            right_node= null;
        }
    }
    //Inorder traversal
    class BinaryTree {
        Node root;
        void Inorder(){
            if(root==null){
                return;
            }
            Stack<Node> stack = new Stack<Node>();
            Node temp = root;
            //Loop through the tree
            while(temp!=null || !stack.isEmpty()){
                //go left till theres no left child left
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left_node;
                }
                //Pop the leftest child
                temp = stack.pop();
                System.out.println(temp.data+" ");
                //IF theres no left child left, go for the right child
                temp = temp.right_node;
            }
        }
}
}
