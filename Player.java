public class Player extends Field{
    private String name;
    private String symbol;
    private Coords coords;
    private WorldMap currentMap;

    public Player(){ // ask about passing parameters to super constructor?
        super("@", IO.gatherInput("Type in your hero's name"), new Coords(5,5));
        this.name = "ASD";
        this.symbol = "@";
        this.coords = new Coords(5, 5);
        this.currentMap = new WorldMap(20, 40);
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
        Coords newCoords = new Coords(y, x);
        if (this.getCurrentMap().getBoard()[y][x] instanceof ObstField) {
            return;
        }
        this.setCoords(newCoords);
    }

	public void setCurrentMap(WorldMap worldMap) {
        this.currentMap=worldMap;
	}

	public WorldMap getCurrentMap() {
		return currentMap;
	}
}