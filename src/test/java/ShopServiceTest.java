import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    Product shampoo = new Product(1, "Apfelschampuh");
    Product soap = new Product(2, "Kernseife");
    Product milk = new Product(3, "Die gute Bioweidemilch");
    Product cheese = new Product(4, "Stinkekäse");
    Product beer = new Product(5, "Tegernseer");

    Map<Integer, Product> productMap = new HashMap<>();




    void fillMap(){
        productMap.put(shampoo.getId(),shampoo);
        productMap.put(soap.getId(),soap);
        productMap.put(milk.getId(),milk);
        productMap.put(cheese.getId(),cheese);
        productMap.put(beer.getId(),beer);
    }

    @Test
    void testListProducts(){
        fillMap();
        ProductRepo myProducts = new ProductRepo(productMap);
        ShopService myShopService = new ShopService(myProducts);

        String actual = myShopService.listProduct();

        assertTrue(actual.contains("Kernseife"));
        assertNotNull(actual);
        assertFalse(actual.contains("Salami"));
        System.out.println(actual);

    }
    @Test
    void testOfGetProduct(){
        fillMap();
        ProductRepo myProducts = new ProductRepo(productMap);
        ShopService myShopService = new ShopService(myProducts);

        String expected = "Kernseife";
        String actual = myShopService.getProduct(2).getName();
        assertEquals(expected, actual);

    }

    @Test
    void addOrderTest(){
        fillMap();
        ProductRepo myProducts = new ProductRepo(productMap);
        ShopService myShopService = new ShopService(myProducts);

        Order order = new Order(1, myProducts.list());

        String isAdded = myShopService.addOrder(order);
        assertTrue(isAdded.contains("Added"));
    }

    @Test
    void getOrderTest(){
        fillMap();
        ProductRepo myProducts = new ProductRepo(productMap);
        ShopService myShopService = new ShopService(myProducts);

        Order order = new Order(1, myProducts.list());

        myShopService.addOrder(order);
        assertEquals(order, myShopService.getOrder(1));
    }

    @Test
    void testListOrder(){
        fillMap();
        ProductRepo myProducts = new ProductRepo(productMap);
        ShopService myShopService = new ShopService(myProducts);

        ArrayList<Product> orderList1 = new ArrayList<>(Arrays.asList(soap, shampoo));
        ArrayList<Product> orderList2 = new ArrayList<>(Arrays.asList(soap, shampoo, beer));

        Order order = new Order(1, orderList1);
        Order order2 = new Order(2, orderList2);

        myShopService.addOrder(order);
        myShopService.addOrder(order2);
        assertTrue(myShopService.listOrder().contains("Kernseife"));


    }




}