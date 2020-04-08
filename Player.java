public class Player extends GameObject {
    private WorldMap currentMap;
    private Coords previousCoords;
    private Field lastField;

    public Player() { // ask about passing parameters to super constructor?
        super("@", IO.gatherInput("Type in your hero's name"), new Coords(5, 5));
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
        int currentY = this.getCoords().getposY();
        int currentX = this.getCoords().getposX();
        int nextY = this.getCoords().getposY() + coords.getposY();
        int nextX = this.getCoords().getposX() + coords.getposX();
        
        
        // if (!(getCurrentMap().getBoard()[nextY][nextX].getGameObject() instanceof ObstField)){
        //     this.getCoords().setposY(nextY);
        //     this.getCoords().setposX(nextX);
        //     getCurrentMap().getBoard()[currentY][currentX].getGameObject().setSymbol(this.lastField.getGameObject().getSymbol());
        //     getCurrentMap().getBoard()[currentY][currentX].getGameObject().setName(this.lastField.getGameObject().getName());
        //     setLastField(getCurrentMap().getBoard()[nextY][nextX]);
        //     getCurrentMap().getBoard()[nextY][nextX].setGameObject(this);
        //     //getCurrentMap().getBoard()[nextY][nextX].getGameObject().setSymbol(this.getSymbol());
        //     //getCurrentMap().getBoard()[nextY][nextX].getGameObject().setName(this.getName());
        //     getCurrentMap().getBoard()[nextY][nextX].getGameObject().interact(this);
        // }

        //this.lastField = getCurrentMap().getBoard()[nextY][nextX];

        // this.getCoords().setposY(nextY);
        // this.getCoords().setposX(nextX);

        getCurrentMap().getBoard()[nextY][nextX].getGameObject().interact(this);        

    }

    public void setCurrentMap(WorldMap worldMap) {
        this.currentMap = worldMap;
    }

    public WorldMap getCurrentMap() {
        return currentMap;
    }

    @Override
    public void interact(Player player) {
        // none

    }

}