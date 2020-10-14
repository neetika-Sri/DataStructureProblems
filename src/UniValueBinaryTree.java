import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class UniValueBinaryTree {
    static int count;
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(5);
        count = 0;
        uniVal(root);
        System.out.println(count);

    }
    public static boolean uniVal(Node n){
        if(n == null)
            return true;
        if(n.left == null && n.right == null){
            count++;
            return true;
        }
        boolean isUniVal = true;
        if(n.left != null){
            isUniVal = uniVal(n.left)  && (n.value == n.left.value);
        }
        if(n.right != null){
            isUniVal = uniVal(n.right) && isUniVal && (n.value == n.right.value);
        }
        if(!isUniVal)
            return  false;
        count++;
        return true;
    }
}
