import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListMenu {
    private Node head;

    public void create(int n, Scanner sc) {
        head = null; // reset list
        for (int i = 0; i < n; i++) {
            insertEnd(sc.nextInt());
        }
    }

    public void insertBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void insertPosition(int index, int data) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            insertBegin(data);
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of range");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
       if (head.next == null) {
           head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    public void deletePosition(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index / List empty");
            return;
        }
        if (index == 0) {
            deleteBegin();
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Index out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    public int search(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void updateByIndex(int index, int newValue) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index out of range");
            return;
        }
        temp.data = newValue;
    }

    public void updateByValue(int oldValue, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

  
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }
        temp.next = temp.next.next;
    }

    public void deleteByIndex(int index) {
        deletePosition(index);
    }

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListMenu list = new LinkedListMenu();

        while (true) {
            System.out.println("\n--- Singly Linked List Menu ---");
            System.out.println("1  Create (enter n and n elements)");
            System.out.println("2  Insert Begin");
            System.out.println("3  Insert End");
            System.out.println("4  Insert Position (index, value)");
            System.out.println("5  Delete Begin");
            System.out.println("6  Delete End");
            System.out.println("7  Delete Position (index)");
            System.out.println("8  Search (value)");
            System.out.println("9  Update by Index (index, newValue)");
            System.out.println("10 Update by Value (oldValue, newValue)");
            System.out.println("11 Display");
            System.out.println("12 Delete by Value (value)");
            System.out.println("13 Delete by Index (index)");
            System.out.println("0  Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of nodes: ");
                    int n = sc.nextInt();
                    System.out.println("Enter " + n + " elements:");
                    list.create(n, sc);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertBegin(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    list.insertEnd(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter index and value: ");
                    list.insertPosition(sc.nextInt(), sc.nextInt());
                    break;

                case 5:
                    list.deleteBegin();
                    break;

                case 6:
                    list.deleteEnd();
                    break;

                case 7:
                    System.out.print("Enter index: ");
                    list.deletePosition(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    int pos = list.search(key);
                    if (pos == -1) System.out.println("Not found");
                    else System.out.println("Found at index: " + pos);
                    break;

                case 9:
                    System.out.print("Enter index and newValue: ");
                    list.updateByIndex(sc.nextInt(), sc.nextInt());
                    break;

                case 10:
                    System.out.print("Enter oldValue and newValue: ");
                    list.updateByValue(sc.nextInt(), sc.nextInt());
                    break;

                case 11:
                    list.display();
                    break;

                case 12:
                    System.out.print("Enter value: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 13:
                    System.out.print("Enter index: ");
                    list.deleteByIndex(sc.nextInt());
                    break;

                case 0:
                    System.out.println("Exited.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


