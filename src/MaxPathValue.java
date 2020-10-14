public class MaxPathValue {
    static int max ;
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(3);
        root.left.right = new Node(-2);
        root.right.left = new Node(-22);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.left.left = new Node(40);
        max = Integer.MIN_VALUE;
        findMax(root);
        System.out.println(max);

    }
    public static int findMax(Node root){
        if(root == null)
            return 0;
        int leftMaxValue = Math.max(findMax(root.left),0);
        int rightMaxValue = Math.max(findMax(root.right),0);

        int nodeMaxValue = root.value + leftMaxValue + rightMaxValue;
        max = Math.max(nodeMaxValue, max);
        return root.value + Math.max(leftMaxValue, rightMaxValue);
    }
}
class Node
{
    int value;
    Node left, right;

    public Node(int k){
        value = k;
        left = null;
        right = null;
    }


}

