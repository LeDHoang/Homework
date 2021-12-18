import java.util.*;
public class Postorder_Iterative {
    //Logic following: using 2 stacks
    //push root to 1st stack
    //while first stack not empty
    //pop node from 1st stack to push it to 2nd stack + push left and right child of that node to 1st stack
    //Reverse print 2 stacks

    //Node class
    class Node {

        int data;
        Node left_node, right_node;

        Node(int item) {
            data = item;
            left_node = null;
            right_node = null;
        }
    }

    //2 stacks
    static Stack<Node> stack1, stack2;
    static void Postorder(Node root){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        //If there is no root
        if(root == null){
            return;
        }
        //Push item into 1st stack
        stack1.push(root);
        //Loop while 1st stack is not empty
        while(!stack1.empty()){
            Node temp_node = stack1.pop();
            stack2.push(temp_node);
            //Push into 1st stack left and right child node
            if(temp_node.left_node!=null){
                stack1.push(temp_node.left_node);
            }
            if(temp_node.right_node!= null){
                stack1.push(temp_node.right_node);
            }
            //Loop through stack 2 to reverse print
            StringBuilder result = new StringBuilder(" ");
            while(!stack2.isEmpty()){
                Node temp_node_print = stack2.pop();
                result.append(temp_node_print.data);
            }
            //O(n^2)?
        }
    }

}