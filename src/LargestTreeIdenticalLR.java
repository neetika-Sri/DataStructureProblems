import apple.laf.JRSUIConstants;

public class LargestTreeIdenticalLR {
    static Node maxSubTree;
    static int maxSize;
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(78);
        root.right = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(5);
        SizeAndChilds sc = fetchLargestIdenticalSubTree(root, "");
        System.out.println(maxSize);
        System.out.println(maxSubTree.value);
    }
    public static SizeAndChilds fetchLargestIdenticalSubTree(Node root, String str){
        if(root == null)
            return new SizeAndChilds(0,str);
        String left = "";
        String right = "";
        SizeAndChilds lsc = fetchLargestIdenticalSubTree(root.left,left);
        left = lsc.child;
        int lSize = lsc.size;

        SizeAndChilds rcs = fetchLargestIdenticalSubTree(root.right, right);
        right = rcs.child;
        int rSize = rcs.size;

        int size = lSize + rSize + 1;
        if(left.equals(right)){
            if(size > maxSize){
                maxSize = size;
                maxSubTree = root;
            }
        }
        str += "|"+left+"|";
        str += "|"+root.value+"|";
        str += "|"+right+"|";
       return new SizeAndChilds(size, str);

    }
}
class SizeAndChilds {
    int size;
    String child;

    public SizeAndChilds(int size, String child) {
        this.size = size;
        this.child = child;
    }
}
