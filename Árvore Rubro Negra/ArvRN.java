import java.util.ArrayList;

public class ArvRN {
    Node root;

    public ArvRN() {}

    public ArvRN (int key) {
        root = new Node(key);
        root.black = true;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        Node actParent = null;
        Node act = root;    
        
        // Busca posição a ser inserido, armazenando a classe pai
        while (act != null) {
            actParent = act;

            if (key < act.key)
                act = act.left;

            else if (key > act.key)
                act = act.right;

            else
                return;
        }
        newNode.parent = actParent;

        // Verifica em qual subárvore o novo nó irá ficar e aplica no pai atual
        if (actParent == null) {
            root = newNode;
            root.black = true;
            return;
        }
        else if (newNode.key < actParent.key)
            actParent.left = newNode;
        else
            actParent.right = newNode;

        // Se não tem avô, não há necessidade de ajuste
        if (newNode.parent.parent == null)
            return;

        System.out.println("AJustes!");
        System.exit(0);
    }

    public int getHeight() {
        if (root == null)
            return 0;
        
        return root.getHeight(root);
    }

    public String toString() {
        if (root == null)
            return "Árvore vazia";

        String str = "";
        ArrayList<Node> array = new ArrayList<>();
        array.add(root);

        while (array.size() > 0) {
            ArrayList<Node> newArray = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {

                Node actNode = array.get(i);
                str += actNode;

                if (array.size() > (i + 1)) {
                    str += " | ";
                }

                if (actNode.left != null)
                    newArray.add(actNode.left);

                if (actNode.right != null)
                    newArray.add(actNode.right);
            }

            array = newArray;

            if (array.size() != 0)
                str += "\n";
        }

        return str;
    }
}
