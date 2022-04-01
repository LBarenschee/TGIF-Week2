import java.util.HashMap;
import java.util.Map;

public class OrderRepo {

    private Map<Integer, Order> orderMap = new HashMap<>();


    public boolean add(Order order) {
        if(orderMap.containsKey(order.getId())){
            return false;
        } else {
            orderMap.put(order.getId(), order);
            return true;
        }
    }
}
