package ch.heigvd.gen2019;

public enum Size {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    SIZE_NOT_APPLICABLE("Invalid size");

    private String size;
    Size(String size){
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}
