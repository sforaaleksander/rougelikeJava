

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
        //player.getCurrentMap().getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()].setCurrentObject(player);
    
    }

    public void setLastField(Field lastField) {
        this.lastField = lastField;
    }

    @Override
    public void performAct() {
        
        setLastField(getCurrentMap().getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()]);
        Coords[] listOfCoords = new Coords[] { Coords.RIGHT, Coords.LEFT, Coords.DOWN, Coords.UP };
        Coords randomCoords;
        int nextY, nextX;
        boolean canMoveToField;
        do {
            randomCoords = listOfCoords[Engine.randomIntFromRange(0, 4)];
            nextY = this.getCoords().getPosY() + randomCoords.getPosY();
            nextX = this.getCoords().getPosX() + randomCoords.getPosX();
            canMoveToField = !(currentMap.getBoard()[nextY][nextX].getCurrentObject() instanceof VanishingObject);

        } while (!canMoveToField || !(nextY > 0 && nextY < getCurrentMap().getHeight()-1 && nextX > 0 && nextX <getCurrentMap().getWidth() - 1 ));

        this.getCoords().setPosY(nextY);
        this.getCoords().setPosX(nextX);
        // boolean nextField = currentMap.getBoard()[nextY][nextX].getCurrentObject() instanceof Grass;
        this.lastField.setToDefault();
        
        currentMap.getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()].setCurrentObject(this);
    }


    

}