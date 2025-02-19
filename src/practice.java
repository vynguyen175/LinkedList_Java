public class practice {
    class Node{
        public int data;
        public Node next;
        public Node(int item){
            data = item;
            next = null;
        }
    }
    class LinkedList{
        private Node head;
        public LinkedList(){
            head=null;
        }
        public void addFront(int item){
            Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;
        }
        public void addBack(int item){
            Node newNode = new Node(item);
            if(head==null){
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        public void addInOrderAsc(int item){
            Node newNode = new Node(item);
            if (head == null || item < head.data){
                newNode.next = head;
                head = newNode;
                return;
            }
            Node curr, prev;
            curr=prev=head;
            while (curr.next != null && curr.data<item){
                prev=curr;
                curr=curr.next;
            }
            newNode.next = curr;
            prev.next = newNode;

        }
    }
}
