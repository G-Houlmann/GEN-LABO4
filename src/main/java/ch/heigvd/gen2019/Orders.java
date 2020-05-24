package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public String getContents(){
        return new OrdersWriter().getContent();
    }

    private class OrdersWriter implements StringWriter {

        public String getContent() {
            StringBuilder sb = getContentsPrelude();

            for (int i = 0; i < getOrdersCount(); i++) {
                getOrder(i).getOrderContent(sb);
            }

            return getContentsPostlude(sb).toString();
        }

        private StringBuilder getContentsPrelude() {
            return new StringBuilder("{\"orders\": [");
        }

        private StringBuilder getContentsPostlude(StringBuilder sb) {
            if (getOrdersCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            return sb.append("]}");
        }

    }

}
