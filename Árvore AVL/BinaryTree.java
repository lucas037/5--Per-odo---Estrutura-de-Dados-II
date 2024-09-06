import java.util.ArrayList;

public class BinaryTree {
    private Node root;

    public BinaryTree(int key, String value) {
        root = new Node(key, value);
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

    public void insert(int newKey, String value) {
        root = root.insert(newKey, value);
    }

    public Node search(int key) {
        return root.search(key);
    }

    public int getHeight() {
        return root.getHeight(root);
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

        ArrayList<Node> nextNodes = new ArrayList<>();
        nextNodes.add(root);

        str += toString(nextNodes, 0);

        return str;
    }

    public String toString(ArrayList<Node> nodes, int a) {
        ArrayList<Node> nextNodes = new ArrayList<>();

        String str = "Nível "+a;

        if (nodes.size() > 0) {
            str += ": ";

            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);

                if (i > 0)
                    str += "   |   ";
                str += node;

                if (node.getLeft() != null)
                    nextNodes.add(node.getLeft());

                if (node.getRight() != null)
                    nextNodes.add(node.getRight());
            }

            if (nextNodes.size() > 0)
                str += "\n"+toString(nextNodes, a + 1);
        }
        



        return str;
    }
}
