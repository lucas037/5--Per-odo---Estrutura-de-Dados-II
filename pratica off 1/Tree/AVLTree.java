package Tree;

import java.util.ArrayList;

import Resources.ServiceOrder;

public class AVLTree {
    private Node root;

    public AVLTree(int key, ServiceOrder value) {
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

    public String inOrderValues() {
        return root.inOrderValues();
    }

    public void insert(int newKey, ServiceOrder value) {
        root = root.insert(newKey, value);
    }

    public void update(int key, ServiceOrder newValue) {
        root = root.update(key, newValue);
    }

    public Node search(int key) {
        return root.search(key);
    }

    public ServiceOrder searchValue(int key) {
        Node node = search(key);
        
        if (node == null)
            return null;
            
        return search(key).getValue();
    }

    public int getTotalNodes() {
        return root.getTotalNodes(root);
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
