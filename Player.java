public class Player extends Field{
    private String name;
    private String symbol;
    private Coords coords;

    public Player(){
        super("@", IO.gatherInput("Type in your hero's name"), new Coords(5,5));
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public Coords getCoords(){
        return coords;
    }

    public void setCoords(Coords coords){
        this.coords = coords;
    }

    public void playerMove(Coords coords){
        int y = this.coords.getposY() + coords.getposY();
        int x = this.coords.getposX() + coords.getposX();
        this.setCoords(new Coords(y, x));
    }
}