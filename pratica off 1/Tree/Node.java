package Tree;

import Resources.ServiceOrder;

public class Node {
    private int key;
    private Node left;
    private Node right;
    private ServiceOrder value;
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public ServiceOrder getValue() {
        return value;
    }

    public void setValue(ServiceOrder value) {
        this.value = value;
    }

    public Node(int key, ServiceOrder value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

    public Node(int key, ServiceOrder value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String preOrder() {
        String str = "";

        str += key+" ";
        
        if (left != null)
            str += left.preOrder();

        if (right != null)
            str += right.preOrder();

        return str;
    }

    public String inOrder() {
        String str = "";
        
        if (left != null)
            str += left.inOrder();

        str += key+" ";

        if (right != null)
            str += right.inOrder();

        return str;
    }

    public String inOrderValues() {
        String str = "";
        
        if (left != null)
            str += left.inOrderValues();

        str += "\n"+toStringValue();

        if (right != null)
            str += right.inOrderValues();

        return str;
    }

    public String postOrder() {
        String str = "";
        
        if (left != null)
            str += left.postOrder();

        if (right != null)
            str += right.postOrder();

        str += key+" ";

        return str;
    }

    public Node insert(int newKey, ServiceOrder value) {
        if (newKey < key) {
            if (left == null)
                left = new Node(newKey, value);

            else
                left = left.insert(newKey, value);
        }

        else if (newKey > key) {
            if (right == null)
                right = new Node(newKey, value);

            else
                right = right.insert(newKey, value);
        }

        Node tree = new Node(key, this.value, left, right);
        tree = rotation(tree);

        return tree;
    }

    public Node update(int key, ServiceOrder newValue) {
        if (key == this.key) {
            this.value = newValue;
        }
        
        else if (key < this.key && left != null) {
            left = left.update(key, newValue);
        }

        else if (key > this.key && right != null) {
            right = right.update(key, newValue);
        }

        Node tree = new Node(this.key, this.value, left, right);
        return tree;
    }

    public Node search(int keyToSearch) {
        if (key == keyToSearch)
            return new Node(key, value, left, right);

        else if (keyToSearch < key && left != null)
            return left.search(keyToSearch);

        else if (keyToSearch > key && right != null)
            return right.search(keyToSearch);

        return null;
    }

    public Node remove(Node atn, int keyToRemove) {

        if (atn == null)
            return null;

        if (keyToRemove < atn.key) {
            atn.left = remove(atn.left, keyToRemove);
        }

        else if (keyToRemove > atn.key) {
            atn.right = remove(atn.right, keyToRemove);
        }

        else { // keyToRemove == key

            if (atn.left == null && atn.right == null)
                return null;

            else if (atn.left == null)
                atn = atn.right;

            else if (atn.right == null)
                atn = atn.left;

            else { // existe nó na direita e na esquerda do que vai ser removido

                Node temp = atn.left;

                while (temp.right != null)
                    temp = temp.right;

                atn.left = remove(atn.left, temp.key);
                atn.key = temp.key;

            }

        }

        return rotation(atn);
    }

    public int getHeight(Node arv) {
        if (arv == null)
            return -1;

        return 1 + getMax(getHeight(arv.left), getHeight(arv.right));
    }

    public int getTotalNodes(Node arv) {
        if (arv == null)
            return 0;

        return 1 + getTotalNodes(arv.left) + getTotalNodes(arv.right);
    }

    private Node rotation(Node tree) {
        int fb = getFB(tree);
        int fbLeft = getFB(tree.left);
        int fbRight = getFB(tree.right);

        if (fb < -1 && fbRight <= 0) {
            tree = singleLeftRotation(tree);
        }

        else if (fb < -1) {
            tree = doubleLeftRotation(tree);
        }

        else if (fb > 1 && fbLeft >= 0) {
            tree = singleRightRotation(tree);
        }

        else if (fb > 1) {
            tree = doubleRightRotation(tree);
        }

        return tree;
    }

    private Node singleLeftRotation(Node tree) {
        Node copyTree = tree;

        System.out.print("Rotação simples a esquerda [ "+tree.toString());

        tree = tree.right;
        copyTree.right = tree.left;
        tree.left = copyTree;

        System.out.println(" => "+tree+"]");

        return tree;
    }

    private Node doubleLeftRotation(Node tree) {
        System.out.println("Rotação dupla a esquerda");

        System.out.print("     ");
        tree.right = singleRightRotation(tree.right);
        System.out.print("     ");
        tree = singleLeftRotation(tree);

        return tree;
    }

    private Node singleRightRotation(Node tree) {
        Node copyTree = tree;

        System.out.print("Rotação simples a direita [ "+tree.toString());

        tree = tree.left;
        copyTree.left = tree.right;
        tree.right = copyTree;

        System.out.println(" => "+tree+"]");
        
        return tree;
    }

    private Node doubleRightRotation(Node tree) {
        System.out.println("Rotação dupla a direita");

        System.out.print("     ");
        tree.left = singleLeftRotation(tree.left);
        System.out.print("     ");
        tree = singleRightRotation(tree);

        return tree;
    }

    private int getFB(Node arv) {
        if (arv == null)
            return 0;

        return getHeight(arv.left) - getHeight(arv.right);
    }

    public int getMax(int a, int b) {
        if (a > b)
            return a;

        return b;
    }

    public String toString() {
        String str = Integer.toString(key);

        str += " (";

        if (left != null)
            str += left.key;
        else
            str += "x";

        str += ", ";

        if (right != null)
            str += right.key;
        else
            str += "x";

        str += ") ";

        return str;
    }

    public String toStringValue() {
        return key+" "+value.toString();
    }
}