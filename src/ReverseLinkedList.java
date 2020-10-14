class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
    public void printNode(){
        printNodeUtil(this);
    }
    private void printNodeUtil(ListNode node){
        if(node == null)
            return;
        System.out.println(node.value);
        printNodeUtil(node.next);
    }
    public static ListNode arrayToNode(int[] arr){

        ListNode curr = null;
        ListNode root = null;

        for(int a: arr){
            ListNode newNode = new ListNode(a);
            if(curr == null){
                curr = newNode;
                root = newNode;
            }
            else {
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return root;
    }
}
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode root = ListNode.arrayToNode(new int[]{1,2,3,4,5});
        ListNode newRoot = reverseRec(root);
        newRoot.printNode();

    }
    public static ListNode reverse(ListNode root){
        ListNode curr = root;
        ListNode newRoot = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = newRoot;
            newRoot = curr;
            curr = next;
        }
        return newRoot;
    }
    public static ListNode reverseRec(ListNode root)  {
       if(root.next == null){
           return root;
       }
       ListNode newRoot = reverseRec(root.next);
       root.next.next = root;
       root.next = null;
       return newRoot;
    }
}
