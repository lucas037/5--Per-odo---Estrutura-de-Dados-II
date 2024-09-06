public class Node {
    private int key;
    private Node left;
    private Node right;
    
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

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public Node(int key, Node left, Node right) {
        this.key = key;
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

    public String postOrder() {
        String str = "";
        
        if (left != null)
            str += left.postOrder();

        if (right != null)
            str += right.postOrder();

        str += key+" ";

        return str;
    }

    public void insert(int newKey) {
        if (newKey < key) {
            if (left == null)
                left = new Node(newKey);

            else
                left.insert(newKey);
        }

        else if (newKey > key) {
            if (right == null)
                right = new Node(newKey);

            else
                right.insert(newKey);
        }
    }

    public Node search(int keyToSearch) {
        if (key == keyToSearch)
            return new Node(key, left, right);

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

        return atn;
    }

    public int getHeight() {
        if (left == null && right == null)
            return 0;

        else if (left == null)
            return 1 + right.getHeight();

        else if (right == null)
            return 1 + left.getHeight();

        return 1 + getMax(left.getHeight(), right.getHeight());
    }

    public int getMax(int a, int b) {
        if (a > b)
            return a;

        return b;
    }

    public String toString() {
        String str = Integer.toString(key);

        if (left != null && right != null) {
            str += " (";

            str += left.key;
            str += ", ";
            str += right.key;

            str += ")";
        }
        else if (left != null || right != null) {
            str += " (";

            if (left != null)
                str += left.key;

            if (right != null)
                str += right.key;

            str += ")";
        }

        return str;
    }
}