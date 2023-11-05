import java.util.LinkedList;
import java.util.Queue;

class NodeForBT{
    int value;
    NodeForBT right, left;
    public NodeForBT(){
        right=left=null;
    }
}

public class PrintPathSum {
    NodeForBT root;

    public static void main(String[] args) {
        PrintPathSum pps = new PrintPathSum();
        pps.insert(10);
        pps.insert(28);
        pps.insert(13);
        pps.insert(14);
        pps.insert(15);
        pps.insert(21);
        pps.insert(22);
        pps.levelOrder();
    }
    public void insert(int valueToAdd){
        if(root==null){
            NodeForBT node = new NodeForBT();
            root = node;
            node.value = valueToAdd;
            System.out.println(valueToAdd + " added as root node...");
            return;
        }
        Queue<NodeForBT> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            NodeForBT present = queue.remove();
            if(present.left==null){
                NodeForBT node = new NodeForBT();
                node.value=valueToAdd;
                present.left = node;
                System.out.println(valueToAdd +" added to BT...");
                break;
            }
            else if (present.right==null){
                NodeForBT node = new NodeForBT();
                node.value=valueToAdd;
                present.right = node;
                System.out.println(valueToAdd +" added to BT...");
                break;
            }
            else{
                queue.add(present.left);
                queue.add(present.right);
            }
        }
    }

    public void levelOrder()
    {
        Queue<NodeForBT> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            NodeForBT current = queue.remove();
            System.out.print(current.value + " ");
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
        }
    }
}
