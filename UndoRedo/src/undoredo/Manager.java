package undoredo;

class Node {
    String state;
    Node prev;
    Node next;

    Node(String state) {
        this.state = state;
    }
}

public class Manager {
    private Node current;

    public Manager(String initialState) {
        current = new Node(initialState);
    }

    public void addState(String newState) {
        Node newNode = new Node(newState);
        current.next = null; // Clear redo history
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        System.out.println("Added: " + newState);
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo to: " + current.state);
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo to: " + current.state);
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void printCurrState() {
        System.out.println("Current State: " + current.state);
    }

    public void Chain() {
        Node temp = current;
        // Go to the head
        while (temp.prev != null) {
            temp = temp.prev;
        }

        // Print the chain
        System.out.print("State Chain: ");
        while (temp != null) {
            System.out.print(temp.state);
            if (temp == current) {
                System.out.print(" (current)");
            }
            System.out.print(" <> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

