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

        adjustPositions(newNode);
    }

    public void adjustPositions(Node node) {
        Node uncle;


        while (!node.parent.black) {
            System.out.println("\n"+toString());
            System.out.println("-\nNode a Corrirgir: "+node+"\n-");

            if (node.parent.parent.right == node.parent) { // pai é filho direito do avô
                uncle = node.parent.parent.left;

                if (uncle.black) { // pai é vermelho e tio é preto

                    if (node == node.parent.right) { // nó está a direita do pai
                        node = node.parent;
                        System.out.println("oiess - arvRN");
                    }
                    System.exit(0);

                }
                else { // pai e tio são vermelhos
                    node.parent.black = true;
                    uncle.black = true;
                    node.parent.parent.black = false;
                    node = node.parent.parent;
                }
            }

            else { // pai é filho esquerdo
                uncle = node.parent.parent.right;

                if (uncle.black) { // pai é vermelho e tio é preto

                }

                else { // pai e tio são vermelhos
                    node.parent.black = true;
                    uncle.black = true;
                    node.parent.parent.black = false;
                    node = node.parent.parent;
                }


            }

            System.out.println(toString());


            if (node.parent == null) {
                node.black = true;
                return;
            }
        }

    }

    public int getHeight() {
        return root.getHeight(root);
    }

    public int getTotalHeight() {
        return root.getTotalHeight(root);
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
