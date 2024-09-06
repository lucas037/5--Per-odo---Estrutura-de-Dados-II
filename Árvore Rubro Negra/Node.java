public class Node {
    int key;
    boolean black;
    Node parent, left, right;

    public Node() {}

    public Node(int key) {
        this.key = key;
    }

    public int getHeight(Node node) {
        if (node == null)
            return 0;

        if (node.black && parent != null)
            return 1 + getHeight(node.left);

        return getHeight(node.left);
    }

    public String toString() {
        String str = "";

        if (black)
            str += key+" Black";
        else
            str += key+" Red";
        
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

        str += ")";

        return str;

    }
}
