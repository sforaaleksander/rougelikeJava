public class Player extends GameObject {
    private WorldMap currentMap;
    private Field lastField;

    public Player(){
        super("@", "plejer", new Coords(5, 5));
        this.currentMap = new WorldMap(20, 40);
        this.lastField = new Field(new WalkField(".", "Grass", new Coords(5, 5)));
    }

    public Field getLastField(){
        return lastField;
    }

    public void setLastField(Field lastField){
        this.lastField = lastField;
    }

    public void playerMove(Coords coords) {
        setLastField(getCurrentMap().getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()]);

        int nextY = this.getCoords().getPosY() + coords.getPosY();
        int nextX = this.getCoords().getPosX() + coords.getPosX();
        this.getCoords().setPosY(nextY);
        this.getCoords().setPosX(nextX);  

        getCurrentMap().getBoard()[nextY][nextX].getCurrentObject().interact(this);        
    }

    public void setCurrentMap(WorldMap worldMap) {
        this.currentMap = worldMap;
    }

    public WorldMap getCurrentMap() {
        return currentMap;
    }

    @Override
    public void interact(Player player) {}

}