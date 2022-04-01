import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    Product soap;
    Product shampoo;
    List<Product> products, productsOfSecondOrder;
    Order firstOrder, secondOrder;
    OrderRepo orderRepo;

    @BeforeEach
    void makeOrderRepo() {
        soap = new Product(21, "Kernseife");
        shampoo = new Product(15, "Apfelshampoo");
        products = new ArrayList<>(Arrays.asList(soap, shampoo));
        firstOrder = new Order(1, products);
        productsOfSecondOrder = new ArrayList<>(Arrays.asList(shampoo, soap));
        secondOrder = new Order(2, productsOfSecondOrder);

        orderRepo = new OrderRepo();
    }

    @Test
    void addOrderTest(){
        boolean isOrderMade = orderRepo.add(firstOrder);
        assertTrue(isOrderMade);
        // if oder id already in repo, then false.
        assertFalse(orderRepo.add(firstOrder));
    }

    @Test
    void getOrderTest() {
        orderRepo.add(firstOrder);
        orderRepo.add(secondOrder);
        assertEquals(firstOrder, orderRepo.get(1));
        assertNotEquals(secondOrder, orderRepo.get(1));
    }

    @Test
    void getOrderThrowsException(){
        assertThrows(NoSuchElementException.class, () -> orderRepo.get(1));
        // Experiment, if Parent Exception is also fine here.
        assertThrows(Exception.class, () -> orderRepo.get(1));
    }

    @Test
    void listOrderRepoTest(){
        orderRepo.add(firstOrder);
        orderRepo.add(secondOrder);
        ArrayList<Order> expectedList = new ArrayList<>(Arrays.asList(firstOrder, secondOrder));
        assertEquals(expectedList, orderRepo.list());
    }


}