package Resources;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Tree.AVLTree;

public class Server {
    private AVLTree avl;
    private Cache cache;

    public Server() {
        cache = new Cache();

        String path = "Data/dataSO.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            do {
                String nome = reader.readLine();
                String descricao = reader.readLine();
                String data = reader.readLine();
                String hora = reader.readLine();

                ServiceOrder sv = new ServiceOrder(nome, descricao, data, hora);

                if (avl != null)
                    avl.insert(sv.getId(), sv);
                else
                    avl = new AVLTree(sv.getId(), sv);

            }
            while ((reader.readLine()) != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServiceOrder search(int index) {
        ServiceOrder so;
        
        so = cache.search(index);

        if (so == null)
            so = avl.searchValue(index);

        if (so == null)
            System.out.println("Item com id "+index+" não existe.");
        else
            cache.add(so);

        return so;
    }

    public void create(String name, String descricao) {
        ServiceOrder so = new ServiceOrder(name, descricao);

        System.out.println("");
        avl.insert(so.getId(), so);
        System.out.println("Nova ordem adicionada. Altura da árvore: "+avl.getHeight());

        cache.add(so);


    }

    public void update(ServiceOrder so, String novoNome, String novaDescricao) {
        so.setNome(novoNome);
        so.setDescricao(novaDescricao);

        avl.update(so.getId(), so);
    }

    public void remove(int key) {
        cache.remove(key);

        avl.remove(key);
    }

    public int getTotalServicesOrders() {
        return avl.getTotalNodes();
    }

    public String toString() {
        String str = "";

        System.out.println(avl.inOrderValues());

        return str;
    }

}
