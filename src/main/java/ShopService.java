import java.util.*;

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
        StringBuilder finalString = new StringBuilder();
        ArrayList<Product> products = productRepo.list();
        for (Product product : products) {
            finalString.append("[").append(product.getId()).append("] ").append(product.getName()).append("\n");
        }
        return finalString.toString();
    }

    public String addOrder(Order order){
        if(orderRepo.add(order)){
            return "Added " + order + " to order list.";
        } else {
            return "Could not add " + order + " to order list.";
        }

    }

    public Order getOrder(int id){
        return this.orderRepo.get(id);

    }

    public String listOrder(){
        String finalString = "";
        ArrayList<Order> orders = orderRepo.list();
        for(Order order : orders) {
            finalString += "[" + order.getId() + "] " + order +"\n";
        }
        return finalString;
    }

    public void makeNewOrderMenu(){
            System.out.println(listProduct());
            System.out.println("Which products do you want to order?");
            System.out.println("Press -1 <Enter> when done.");
            int product2order = 0;
            List<Product> productList = new ArrayList<>();
            while (product2order != -1) {
                Scanner userInput = new Scanner(System.in);
                product2order = userInput.nextInt();
                if (product2order != -1) {
                    productList.add(getProduct(product2order));
                }
            }
            this.addOrder(new Order(1, productList));
    }

    public void userMenu(){
        //handle user choice of action
        int action = 0;
        while(action != -1) {
            switch (action){
                case 0:
                    break;
                case 1:
                    makeNewOrderMenu();
                    break;
                case 2:
                    listAllOrdersMenu();
                    break;
            }
            showAvailableActions();
            Scanner userInput = new Scanner(System.in);
            action = userInput.nextInt();
        }
    }

    private void listAllOrdersMenu() {
        System.out.println(orderRepo.list());
    }

    private void showAvailableActions() {
        String availableActionsMenu = "";
        availableActionsMenu = "Which action do you want to do?\n";
        availableActionsMenu += "[1] Select products and order them.\n";
        availableActionsMenu += "[2] List all orders.\n";
        System.out.println(availableActionsMenu);
    }

    static Map fillMap(Map productMap){
        Product shampoo = new Product(1, "Apfelschampuh");
        Product soap = new Product(2, "Kernseife");
        Product milk = new Product(3, "Die gute Bioweidemilch");
        Product cheese = new Product(4, "Stinkekäse");
        Product beer = new Product(5, "Tegernseer");
        productMap.put(shampoo.getId(),shampoo);
        productMap.put(soap.getId(),soap);
        productMap.put(milk.getId(),milk);
        productMap.put(cheese.getId(),cheese);
        productMap.put(beer.getId(),beer);
        return productMap;
    }

    public static void main(String[] args) {
        Map<Integer, Product> prodmap = new HashMap<>();
        prodmap = fillMap(prodmap);
        ProductRepo prodre = new ProductRepo(prodmap);
        ShopService myShop = new ShopService(prodre);
        myShop.userMenu();
        System.out.println(myShop.listOrder());
    }
}

