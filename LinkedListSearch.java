class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSearch {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    boolean search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListSearch list = new LinkedListSearch();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        System.out.println(list.search(10));
    }
}
