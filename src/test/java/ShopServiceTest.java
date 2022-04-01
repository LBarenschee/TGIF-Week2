import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

}