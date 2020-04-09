public class Enemy extends GameObject {
    private Field lastField;
    private WorldMap currentMap;
    

    public Enemy(String symbol, String colour, String name, Coords coords, WorldMap map) {
        super(symbol, colour, name, coords);
        this.currentMap = map;
        Coords randomCoords = this.getCurrentMap().randomPlacementOnMap(this);
        this.lastField = new Field(new Grass(randomCoords));
    }

    private WorldMap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(WorldMap currentMap) {
        this.currentMap = currentMap;
    }

    @Override
    public void interact(Player player) {
        player.minusHp(1);
        player.getLastField().setToDefault(); // co w przyadku gdy nadepniemy na enemy? czy ma zniknac czy ma isc gdzies
                                              // dalej?jakie obiekt ma sie wyswietlic?
    }

    public void enemyMove(Coords coords) {
        setLastField(getCurrentMap().getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()]);
        Coords[] listOfCoords = new Coords[] {Coords.RIGHT, Coords.LEFT, Coords.DOWN, Coords.UP}; 
        Coords randomCoords = listOfCoords[Engine.randomIntFromRange(0, 3)]; 
        
        int nextY = this.getCoords().getPosY() + randomCoords.getPosY();
        int nextX = this.getCoords().getPosX() + randomCoords.getPosX();
        this.getCoords().setPosY(nextY);
        this.getCoords().setPosX(nextX);  
        //getCurrentMap().getBoard()[nextY][nextX].getCurrentObject().interact(this);        
    }

    public void setLastField(Field lastField){
        this.lastField = lastField;
    }

}