import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    Product soap = new Product(21, "Kernseife");
    Product shampoo = new Product(15, "Apfelshampoo");
    Map<Integer, Product> testMap = new HashMap<>();


    @Test
    void testConstructor() {
        testMap.put(soap.getId(), soap);
        testMap.put(shampoo.getId(), shampoo);
        ProductRepo probRepo = new ProductRepo(testMap);
        Assertions.assertEquals(testMap, probRepo.get());
    }

    @Test
    void listTest(){
        testMap.put(soap.getId(), soap);
        testMap.put(shampoo.getId(), shampoo);
        ProductRepo probRepo = new ProductRepo(testMap);
        ArrayList<Product> expectedList = new ArrayList<>(Arrays.asList(soap, shampoo));
        assertEquals(expectedList, probRepo.list());
    }
}