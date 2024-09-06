package Resources;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    private Server server;
    private Scanner sc = new Scanner(System.in);

    public Client() {
        server = new Server();
        System.out.println("\n======================");
        System.out.println("Bem-vindo(a) de volta!");
    }

    public void listServiceOrders() {
        System.out.println(server);
    }

    public void search() {
        System.out.print("\nId à buscar: ");
        try {
            int input = sc.nextInt();
            sc.nextLine();
            
            ServiceOrder so = search(input);

            if (so == null) {
                System.out.println("Opção inválida. Ordem de Serviço não existe.");
            }
            else
                System.out.println(so);
        }
        catch (InputMismatchException e) {
            System.out.println("Opção inválida! Tente novamente.");
            sc.next();
            search();
        }
    }

    public ServiceOrder search(int index) {
        ServiceOrder so = server.search(index);

        return so;
    }

    public void createServiceOrder() {
        System.out.print("\nNome: ");
        String name = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        if (name.equals(""))
            System.out.println("Nome não pode ser vazio.");
        else if (descricao.equals(""))
            System.out.println("Descrição não pode ser vazia.");
        else
            server.create(name, descricao);
    }

    public void updateServiceOrder() {
        System.out.println(server);

        System.out.print("Ordem a atualizar ('cancel' para cancelar) => ");

        try {
            int input = sc.nextInt();
            sc.nextLine();

            ServiceOrder so = search(input);

            if (so == null) {
                System.out.println("Inválido. Ordem de serviço indicada não existe.");
            }

            else {
                System.out.print("\nNome: ");
                String name = sc.nextLine();
    
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();
    
                server.update(so, name, descricao);
            }

        }
        catch (InputMismatchException e) {
            System.out.println("Opção inválida! Tente novamente.");
            sc.next();
        }

    }

    public void removeServiceOrder() {
        System.out.println(server);

        System.out.print("Ordem a remover (enter para cancelar) => ");

        try {
            int input = sc.nextInt();
            sc.nextLine();
            server.remove(input);
        }
        catch (InputMismatchException e) {
            System.out.println("Opção inválida! Tente novamente.");
            sc.next();
            removeServiceOrder();
        }

    }

    public void clientManager() {
        System.out.println("\n0. Encerrar");
        System.out.println("1. Listar Ordens de Serviço");
        System.out.println("2. Cadastrar Ordem de Serviço");
        System.out.println("3. Buscar Ordem de Serviço");
        System.out.println("4. Alterar Ordem de Serviço");
        System.out.println("5. Remover Ordens de Serviço");
        System.out.println("6. Quantidade de Registros");

        System.out.print("Opção escolhida => ");
        String input = sc.nextLine();

        if (input.equals("0"))
            System.out.println("\nPrograma encerrado.");

        else {
            if (input.equals("1"))
                listServiceOrders();

            else if (input.equals("2"))
                createServiceOrder();

                else if (input.equals("3"))
                    search();
    
            else if (input.equals("4"))
                updateServiceOrder();

            else if (input.equals("5"))
                removeServiceOrder();

            else if (input.equals("6"))
                System.out.println("Quantidade de ordens de serviço: "+server.getTotalServicesOrders());
    
            else {
                System.out.println("Opção inválida! Tente novamente.");
            }

            clientManager();
        }
    }


}