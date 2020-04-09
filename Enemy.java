public class Enemy extends GameObject implements ActiveObject {
    private Field lastField;
    private WorldMap currentMap;

    public Enemy(String symbol, String colour, String name, WorldMap map) {
        super(symbol, colour, name, WorldMap.generateRandomCoords());
        this.currentMap = map;
        // Coords randomCoords = this.getCurrentMap().randomPlacementOnMap(this);
        this.lastField = new Field(new Grass(getCoords()));
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
        player.getLastField().setToDefault();
    }

    public void setLastField(Field lastField) {
        this.lastField = lastField;
    }

    @Override
    public void performAct() {
        setLastField(getCurrentMap().getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()]);
        Coords[] listOfCoords = new Coords[] { Coords.RIGHT, Coords.LEFT, Coords.DOWN, Coords.UP };
        Coords randomCoords = listOfCoords[Engine.randomIntFromRange(0, 3)];

        int nextY = this.getCoords().getPosY() + randomCoords.getPosY();
        int nextX = this.getCoords().getPosX() + randomCoords.getPosX();
        this.getCoords().setPosY(nextY);
        this.getCoords().setPosX(nextX);

        currentMap.getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()].setCurrentObject(this);

        this.lastField.setToDefault();

        // getCurrentMap().getBoard()[nextY][nextX].getCurrentObject().interact(this);

    }

}