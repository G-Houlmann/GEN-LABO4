package ch.heigvd.gen2019;

public enum Color {
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow"),
    NO_COLOR("no color");

    private final String color;
    
    Color(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
