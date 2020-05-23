package ch.heigvd.gen2019;

public class Product {
    private String code;
    private Color color;
    private Size size;
    private Price price;

    public Product(String code, Color color, Size size, Price price) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price.getAmount();
    }

    public String getCurrency() {
        return price.getCurrency();
    }

    public void getProductContent(StringBuilder sb){
        new ProductWriter().getProductContent(sb);
    }

    private class ProductWriter{
        public void getProductContent(StringBuilder sb) {

            sb.append("{");

            getProperty(sb, "code", getCode(), true);
            getProperty(sb, "color", color.toString(), true);


            if (getSize() != Size.SIZE_NOT_APPLICABLE) {
                getProperty(sb, "size", size.toString(), true);
            }

            getProperty(sb, "price", Double.toString(getPrice()), false);
            getProperty(sb, "currency", getCurrency(), true);


            sb.delete(sb.length() - 3, sb.length());
            sb.append("\"}, ");
        }

        private void getProperty(StringBuilder sb, String propertyName, String propertyValue, boolean surroundValueWithQuotes){
            sb.append("\"");
            sb.append(propertyName);
            sb.append("\": ");
            if(surroundValueWithQuotes) sb.append("\"");
            sb.append(propertyValue);
            if(surroundValueWithQuotes) sb.append("\"");
            sb.append(", ");
        }
    }


}