import java.util.*;

public class ProductRepo {


    private Map<Integer, Product> products = new HashMap<>();

    public ArrayList<Product> list() {
        return new ArrayList<>(products.values());
    }

    public ProductRepo(Map < Integer, Product > products) {
            this.products = products;
        }

        public Map<Integer, Product> get () {
            return products;
        }

        public void setProducts (Map < Integer, Product > products){
            this.products = products;
        }
    }