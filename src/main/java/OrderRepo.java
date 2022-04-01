import java.util.*;

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

    public Order get(int i) throws NoSuchElementException {
        if(!orderMap.containsKey(i)){
            String message = "This order is not in the OrderRepo.";
            throw new NoSuchElementException(message);
        }
        return orderMap.get(i);
    }

    public ArrayList<Order> list() {
        return new ArrayList<>(orderMap.values());
    }
}
