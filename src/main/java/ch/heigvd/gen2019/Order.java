package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
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
        new OrderWriter().getOrderContent(sb);
    }


    private class OrderWriter {

        public void getOrderContent(StringBuilder sb) {
            getOrderContentPrelude(sb);

            for (int j = 0; j < getProductsCount(); j++) {
                getProduct(j).getProductContent(sb);
            }

            getOrderContentPostlude(sb);
        }

        private void getOrderContentPostlude(StringBuilder sb) {
            if (getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            sb.append("}, ");
        }

        private void getOrderContentPrelude(StringBuilder sb) {
            sb.append("{");
            sb.append("\"id\": ");
            sb.append(getOrderId());
            sb.append(", ");
            sb.append("\"products\": [");
        }
    }
}
