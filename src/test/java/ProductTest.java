import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void constructorTest(){
        Product shampoo = new Product(15, "Apfel Shampoo");
        assertEquals(15, shampoo.getId());
        assertEquals("Apfel Shampoo", shampoo.getName());
    }

}