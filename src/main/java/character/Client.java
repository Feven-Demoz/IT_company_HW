package character;
import interfaces.IPrintInfo;


public class Client <T> implements IPrintInfo {   // T is for the type & it can be anything which is generic
    private class Node {
        T clientInfo;   // Can be int or string
        Node next;   // Refer to the next element

        public Node(T clientInfoEnter) {
            this.clientInfo = clientInfoEnter;
            this.next = null;
        }

    }

    private Node head;  // 1st one on the list

    public Client() {
        this.head = null;
    }

    public void add(T clientInfo) { // add clint info
        Node newNode = new Node(clientInfo); // calling the node conctracter to create an new node

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {   // keep going until there is no next node is null
            current = current.next;    // assign the current node to current next
        }

        current.next = newNode;
    }

    public void printList() {
        Node current = head;

        while (current != null) { //as long as the current is not null
            System.out.println(current.clientInfo);
            current = current.next; // the current value keeps updating to the next node
        }
    }

    @Override
    public void printInformation() {

    }
}

