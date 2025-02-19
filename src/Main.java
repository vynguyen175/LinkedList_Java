//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addInOrderAsc(45);
        ll.addInOrderAsc(92);
        ll.addInOrderAsc(-56);
        ll.addInOrderAsc(7);
        ll.addInOrderAsc(673);
        System.out.println(ll.printList());
        ll.deleteItem(-56);
        System.out.println(ll.printList());
        ll.deleteItem(673);
        System.out.println(ll.printList());
        ll.deleteItem(45);
        System.out.println(ll.printList());
        ll.deleteItem(7);
        ll.deleteItem(92);
        ll.deleteItem(45);
        System.out.println(ll.printList());
        }
    }
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
            head = null;
        }

        public void addFront(int item) {
            Node newNode = new Node(item); // create new Node
            newNode.next = head;
            head = newNode;
        }
        public void addLast(int item) {
            Node newNode = new Node(item);
            if (head == null) {// case 0 when head is empty
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        public void addInOrderAsc(int item) {
            Node newNode = new Node(item);
            if (head == null|| item < head.data) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node current, prev;
            current=prev=head;
            while (current!=null && item>current.data) {
                prev=current;
                current=current.next;
            }
            newNode.next = current;
            prev.next = newNode;
        }
    public void addInOrderDesc(int item) {
        Node newNode = new Node(item);
        if (head == null || item > head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current, prev;
        current = prev = head;

        while (current != null && item < current.data) {
            prev = current;
            current = current.next;
        }
        newNode.next = current;
        prev.next = newNode;
    }

    public boolean deleteItem(int item) {
            if (head == null) return false;
            if (head.data == item) {
                head = head.next;
                return true;
            }
            Node current,prev;
            current=prev=head;
            while (current!=null && item!=current.data) {
                prev=current;
                current=current.next;
            }
            if (current==null) return false;
            prev.next = current.next;
            return true;
        }

        public boolean exist(int item) {
            Node current=head;
            while(current!=null) {
                if (current.data == item) {
                    return true;
                }
                current=current.next;
            }
            return false;
        }
        public String printList(){
            String s="List: ";
            Node curr=head;
            while (curr!=null){
                s+=" "+curr.data;
                curr=curr.next;
            }
            return s;
        }

    }
