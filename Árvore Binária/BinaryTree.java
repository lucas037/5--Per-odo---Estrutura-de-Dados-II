public class BinaryTree {
    private Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public String preOrder() {
        return root.preOrder();
    }

    public String inOrder() {
        return root.inOrder();
    }

    public String postOrder() {
        return root.postOrder();
    }

    public void insert(int newKey) {
        root.insert(newKey);
    }

    public Node search(int key) {
        return root.search(key);
    }

    public int getHeight() {
        return root.getHeight();
    }

    public void remove(int key) {
        if (root.getLeft() != null || root.getRight() != null)
            root = root.remove(root, key);
        else {
            System.out.println("Impossível remover nó raiz.");
        }
    }

        

    public String toString() {
        String str = "";

        str += "Root: "+root.toString();

        return str;
    }
}
