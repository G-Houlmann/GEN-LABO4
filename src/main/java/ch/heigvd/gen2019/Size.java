package ch.heigvd.gen2019;

public enum Size {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    NO_SIZE("Invalid size");

    private String size;
    Size(String size){
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}
