import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.NoopProcessorErrorHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderConstructor () {
        Product soap = new Product(21, "Kernseife");
        Product shampoo = new Product(15, "Apfelshampoo");

        List<Product> products = new ArrayList<>(Arrays.asList(soap, shampoo, soap));

        Order firstOrder = new Order(1, products);

        assertTrue(firstOrder.toString().contains("Apfelshampoo"));
        System.out.println(firstOrder.toString());

    }
}