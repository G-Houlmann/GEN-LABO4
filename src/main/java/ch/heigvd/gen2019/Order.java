package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    public void getOrderContent(StringBuilder sb) {
        sb.append(new OrderWriter().getContent());
    }


    private class OrderWriter implements StringWriter {

        public String getContent() {
            StringBuilder sb = new StringBuilder();
            getOrderContentPrelude(sb);

            for (int j = 0; j < getProductsCount(); j++) {
                getProduct(j).getProductContent(sb);
            }

            getOrderContentPostlude(sb);
            return sb.toString();
        }

        private void getOrderContentPostlude(StringBuilder sb) {
            if (getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]}, ");
        }

        private void getOrderContentPrelude(StringBuilder sb) {
            sb.append("{\"id\": ");
            sb.append(getOrderId());
            sb.append(", \"products\": [");
        }
    }
}
