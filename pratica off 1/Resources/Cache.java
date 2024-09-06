package Resources;
import java.util.ArrayList;

public class Cache {
    private ArrayList<ServiceOrder> cache = new ArrayList<>();
    int tamanhoCache;

    public Cache() {
        tamanhoCache = 5;
    }

    public void add(ServiceOrder so) {
        System.out.println("");

        for (int i = 0; i < cache.size(); i++) {
            if (so.getId() == cache.get(i).getId()) {
                cache.remove(i);
            }
        }

        conditionalRemove();
        
        cache.add(so);

        System.out.println("Item (id "+so.getId()+") adicionado na cache "+toString());

    }

    public void remove(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (key == cache.get(i).getId()) {
                int idItem = cache.get(i).getId();
                cache.remove(i);
                System.out.println("Item (id "+idItem+") removido da cache "+toString());
            }
        }
    }

    public void conditionalRemove() {
        if (cache.size() >= tamanhoCache) {
            int idItem = cache.get(0).getId();
            cache.remove(0);
            System.out.println("Item (id "+idItem+") removido da cache "+toString());
        }
    }

    public ServiceOrder search(int key) {
        for (int i = 0; i < cache.size(); i++)
            if (cache.get(i).getId() == key) {
                ServiceOrder so = cache.get(i);

                cache.remove(i);
                System.out.print("\nItem (id "+so.getId()+") encontrado na cache. \nItem adicionado ao final da fila.");
                cache.add(so);
                System.out.println(toString());

                return so;
            }

        System.out.println("Item (id "+key+") não encontrado na cache. Procurando na árvore...");
        return null;
    }

    public String toString() {
        String str = "[";

        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i) == null)
                str += "x";
            else
                str += cache.get(i).getId();

            if (i < cache.size() - 1)
                str += ", ";
        }

        for (int i = cache.size(); i < tamanhoCache; i++) {
            if (i == 0)
                str += "x";

            else    
                str += ", x";
        }

        str += "]";
        return str;
    }
    
}
