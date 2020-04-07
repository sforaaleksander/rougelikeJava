package src;

public abstract class Field {
    private String symbol;
    private String name;
    private Coords coords;

    public Field(String symbol, String name, Coords coords){
        this.symbol = symbol;
        this.name = name;
        this.coords = coords;

    }
}