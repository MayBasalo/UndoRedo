package undoredo;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Start");

        manager.addState("First");
        manager.addState("Second");
        manager.addState("Third");

        System.out.println("Start node: ");
        manager.Chain();
        manager.printCurrState();

        System.out.println("Undo node: ");
        manager.undo();
        manager.Chain();
        manager.printCurrState();

        System.out.println("Redo node: ");
        manager.redo();
        manager.Chain();
        manager.printCurrState();
    }
}
