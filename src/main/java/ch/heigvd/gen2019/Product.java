package ch.heigvd.gen2019;

public class Product {
    public static final int SIZE_NOT_APPLICABLE = -1;
    private String code;
    private int color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    private String getSizeFor() {
        switch (getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor() {
        switch (getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }

    public void getProductContent(StringBuffer sb){
        ProductWriter writer = new ProductWriter();
        writer.getProductContent(sb);
    }

    private class ProductWriter{
        public void getProductContent(StringBuffer sb) {

            sb.append("{");

            getProperty(sb, "code", getCode(), true);
            getProperty(sb, "color", getColorFor(), true);


            if (getSize() != SIZE_NOT_APPLICABLE) {
                getProperty(sb, "size", getSizeFor(), true);
            }

            getProperty(sb, "price", Double.toString(getPrice()), false);
            getProperty(sb, "currency", getCurrency(), true);


            sb.delete(sb.length() - 3, sb.length());
            sb.append("\"}, ");
        }

        private void getProperty(StringBuffer sb, String propertyName, String propertyValue, boolean surroundValueWithQuotes){
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