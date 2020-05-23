package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = getContentsPrelude();

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            orders.getOrder(i).getOrderContent(sb);
        }

        return getContentsPostlude(sb);
    }

    private StringBuffer getContentsPrelude() {
        return new StringBuffer("{\"orders\": [");
    }

    private String getContentsPostlude(StringBuffer sb) {
        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

}