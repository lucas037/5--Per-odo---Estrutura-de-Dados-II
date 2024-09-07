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

        if (node.black && node.parent != null)
            return 1 + getHeight(node.left);
        
        return getHeight(node.left);
    }

    public int getTotalHeight(Node node) {
        if (node == null)
            return 0;

        if (node.parent != null)
            return 1 + max(getTotalHeight(node.left), getTotalHeight(node.right));

        return max(getTotalHeight(node.left), getTotalHeight(node.right));
    }

    private int max(int a, int b) {
        if (a > b)
            return a;

        return b;
    }

    public String toString() {
        String reset = "\u001B[0m"; // Reseta a cor
        String red = "\u001B[31m";  // Texto vermelho
    
        String str = "";
    
        if (!black)
            str += red;

        str += key;

        str += reset;
    
        str += " (";
    
        // Exibe chave da esquerda ou "x"
        if (left != null) {
            str += left.key;
        } else {
            str += "x";
        }
    
        str += ", ";
    
        // Exibe chave da direita ou "x"
        if (right != null) {
            str += right.key;
        } else {
            str += "x";
        }
    
        str += ")";
    
        return str;
    }
}
