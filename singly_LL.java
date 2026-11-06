public class singly_LL {

    // Node class
    static class Node {
        int data;
        Node next;

        // Node(int x) {
        //     data = x;
        //     next = null;
        // }
    }

    static Node first, temp, ttemp, p;

    // Initialize linked list
    static void init() {
        first = temp = null;
    }

    // Create first node
    static void create(int x) {
        first = new Node();
        first.data = x;
        first.next = null;
    }

    // Add node at the end
    static void add_node(int x) {
        temp = first;

        while (temp.next != null) {
            temp = temp.next;
        }

        ttemp = new Node();
        ttemp.data = x;
        ttemp.next = null;
        temp.next = ttemp;
    }

    // Add node before first node
    static void add_before1st(int x) {
        ttemp = new Node();
        ttemp.data = x;
        ttemp.next = first;
        first = ttemp;
    }

    // Add node after last node
    static void add_AfterLast(int x) {
        temp = first;

        while (temp.next != null) {
            temp = temp.next;
        }

        ttemp = new Node();
        ttemp.data = x;
        ttemp.next = null;
        temp.next = ttemp;
    }

    // Add node before a given value
    static void add_before(int x, int y) {
        temp = first;
        ttemp = null;

        while (temp != null && temp.data != x) {
            ttemp = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        p = new Node();
        p.data = y;
        p.next = temp;

        if (ttemp == null) {
            first = p;
        } else {
            ttemp.next = p;
        }
    }

    // Add node after a given value
    static void add_after(int x, int y) {
        temp = first;

        while (temp != null && temp.data != x) {
            temp = temp.next;
        }

        if (temp == null) return;

        p = new Node();
        p.data = y;
        p.next = temp.next;
        temp.next = p;
    }

    // Delete first node
    static void del_1st() {
        if (first != null) {
            first = first.next;
        }
    }

    // Delete last node
    static void del_last() {
        if (first == null || first.next == null) {
            first = null;
            return;
        }
        temp = first;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete node before a given value
    static void del_before(int x) {
        if (first == null || first.next == null) return;

        temp = first;
        ttemp = null;

        while (temp.next != null && temp.next.data != x) {
            ttemp = temp;
            temp = temp.next;
        }

        if (temp.next == null) return;

        if (ttemp == null) {
            first = temp.next;
        } else {
            ttemp.next = temp.next;
        }
    }

    // Delete node after a given value
    static void del_after(int x) {
        temp = first;

        while (temp != null && temp.data != x) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return;

        temp.next = temp.next.next;
    }

    // Swap first and second nodes
    static void swap_1st_2nd() {
        if (first == null || first.next == null) return;

        temp = first;
        ttemp = first.next;

        temp.next = ttemp.next;
        ttemp.next = temp;
        first = ttemp;
    }

    // Swap first and last nodes
    static void swap_1st_last() {
        if (first == null || first.next == null) return;

        temp = first;
        ttemp = null;

        while (temp.next != null) {
            ttemp = temp;
            temp = temp.next;
        }

        p = first.next;
        temp.next = p;
        ttemp.next = first;
        first.next = null;
        first = temp;
    }

    // Swap second last and last nodes
    static void swap_last_2ndLast() {
        if (first == null || first.next == null) return;

        temp = first;
        ttemp = null;

        while (temp.next.next != null) {
            ttemp = temp;
            temp = temp.next;
        }

        p = temp.next;
        temp.next = null;
        p.next = temp;

        if (ttemp == null) {
            first = p;
        } else {
            ttemp.next = p;
        }
    }

    // Reverse linked list
    static void revers() {
        p = null;
        temp = first;

        while (temp != null) {
            ttemp = temp;
            temp = temp.next;

            ttemp.next = p;
            p = ttemp;
        }

        if (p != null) {
            first = p;
        }
    }

    // Display linked list
    static void display() {
        temp = first;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        init();

        create(10);
        add_node(20);
        add_node(30);
        add_node(40);
        add_node(50);
        add_node(60);
        add_node(70);

        display();

        System.out.println("\nAdd a node Before the 1st Node:");
        add_before1st(5);
        display();

        System.out.println("\nAdd a node After the Last Node:");
        add_AfterLast(75);
        display();

        System.out.println("\nAdd Before:");
        add_before(50, 45);
        display();

        System.out.println("\nAdd After:");
        add_after(30, 35);
        display();

        System.out.println("\nDelete 1st:");
        del_1st();
        display();

        System.out.println("\nDelete Last:");
        del_last();
        display();

        System.out.println("\nDelete Before:");
        del_before(40);
        display();

        System.out.println("\nDelete After:");
        del_after(40);
        display();

        System.out.println("\nReverse:");
        revers();
        display();

        System.out.println("\nSwap First and Second Node:");
        swap_1st_2nd();
        display();

        System.out.println("\nSwap First and Last Node:");
        swap_1st_last();
        display();

        System.out.println("\nSwap 2nd Last and Last Node:");
        swap_last_2ndLast();
        display();
    }
}
