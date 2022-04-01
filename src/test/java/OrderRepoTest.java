import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    @Test
    void addOrderTest(){
        Product soap = new Product(21, "Kernseife");
        Product shampoo = new Product(15, "Apfelshampoo");

        List<Product> products = new ArrayList<>(Arrays.asList(soap, shampoo));
        Order firstOrder = new Order(1, products);
        List<Product> productsOfSecondOrder = new ArrayList<>(Arrays.asList(shampoo, soap));
        Order secondOrder = new Order(2, productsOfSecondOrder);

        OrderRepo orderRepo = new OrderRepo();
        boolean isOrderMade = orderRepo.add(firstOrder);
        assertTrue(isOrderMade);
        // if oder id already in repo, then false.
        assertFalse(orderRepo.add(firstOrder));
    }

    @Test
    void getOrderTest() {

    }
}