package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder sb = getContentsPrelude();

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            orders.getOrder(i).getOrderContent(sb);
        }

        return getContentsPostlude(sb).toString();
    }

    private StringBuilder getContentsPrelude() {
        return new StringBuilder("{\"orders\": [");
    }

    private StringBuilder getContentsPostlude(StringBuilder sb) {
        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}");
    }

}