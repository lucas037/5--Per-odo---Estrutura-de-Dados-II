import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aleatory<Integer> random = new Aleatory<>();
        Scanner scanner = new Scanner(System.in);

        BinaryTree tree = new BinaryTree(1, "");
        
        for (int i = 3; i <= 12; i += 2) {
            tree.insert(i, null);
        }

        for (int i = 2; i <= 12; i += 2) {
            tree.insert(i, null);
        }
        

        int a = -377;

        do {
            tree.remove(a);

            System.out.println("\n"+tree);
            a = scanner.nextInt();
        }
        while (a != 377);

        scanner.close();



    }
}
