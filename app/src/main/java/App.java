import cs1501.p1.Bst;

/**
 * A very basic driver for CS1501 Project 1 to demonstrate usage and provide a place for further
 * testing.
 * @author Dr. Farnan
 * @author Dr. Garrison
 */
public class App {
    public static void main(String[] args) {
        Bst<String> tree = new Bst<>();
        tree.put("3");
        tree.put("1");
        tree.put("4");
        // tree.put("5");
        // tree.put("9");
        System.out.println(tree.serialize());
        tree.isBalanced();
        System.out.println("Successfully built an empty tree of String!");
    }
}

