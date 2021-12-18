import java.util.*;

public class Preorder_Iterative {
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
    //Binary tree class
    class BinaryTree {

        Node root;

        void Preorder() {
            Preorder(root);
        }

        // An iterative process to print preorder traversal
        void Preorder(Node node) {

            // Base Case
            if (node == null) {
                return;
            }

            // Empty stack with root
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);

        //Loop till stack is empty
            while (!stack.empty()) {
                //Print top first then pop top
                Node top = stack.peek();
                System.out.println(top.data+" ");
                stack.pop();
                //Move right node to top if there is
                if(top.right_node != null){
                    stack.push(top.right_node);
                }
                //Move left node to top if there is
                if(top.left_node!=null){
                    stack.push(top.left_node);
                }
            }
        }
    }
}
