
public abstract class GameObject {
    private String symbol;
    private String name;
    private Coords coords;
    private String colour;

    public GameObject(String symbol, String colour, String name, Coords coords) {
        this.colour = colour;
        this.symbol = colour + symbol + Colours.RESET;
        this.name = name;
        this.coords = coords;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void interact(Player player);
}