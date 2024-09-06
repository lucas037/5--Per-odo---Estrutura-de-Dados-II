public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(4);

        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(0);

        System.out.println(tree);
        tree.remove(4);
        System.out.println(tree);
        tree.remove(3);
        System.out.println(tree);
        tree.remove(2);
        System.out.println(tree);
        tree.remove(1);
        System.out.println(tree);
        tree.remove(0);
        System.out.println(tree);
        tree.remove(6);
        System.out.println(tree);
        tree.remove(5);
        System.out.println(tree);
        tree.remove(7);
        System.out.println(tree);
        
        tree.insert(0);
        tree.remove(7);
        System.out.println(tree);



    }
}
