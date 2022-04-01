import java.util.ArrayList;
import java.util.Map;

public class ShopService {


    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.orderRepo = new OrderRepo();
    }

    public Product getProduct(int key){
        Map<Integer, Product> prod = this.productRepo.get();
        return prod.get(key);
    }

    public String listProduct(){
        String finalString = "";
        ArrayList<Product> products = productRepo.list();
        for (Product product : products) {
            finalString += "[" + product.getId() + "] " + product.getName() +"\n";
        }
        return finalString;
    }

    public void addOrder(){

    }

    public Order getOrder(int id){
        return null;
    }

    public String listOrder(){
        return null;
    }

    public void userMenu(){
        //handle user choice of action
    }
}

