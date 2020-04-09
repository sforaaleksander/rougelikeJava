public class Player extends GameObject {
    private WorldMap currentMap;
    private Field lastField;
    private int hp;
    private int collectedDiamonds;

    public Player(){
        super("\u259B", Colours.RED , "plejer", new Coords(5, 5));
        this.currentMap = new WorldMap(20, 40);
        Coords randomCoords = randomPlacementOnMap();
        this.lastField = new Field(new WalkField(" ", Colours.GREEN_BACKGROUND, "Grass", randomCoords));
        this.hp = 3;
        this.collectedDiamonds=0;
    }

    public Coords randomPlacementOnMap(){
        int randomPosY = Engine.randomIntFromRange(1, this.currentMap.getHeight());
        int randomPosX = Engine.randomIntFromRange(1, this.currentMap.getWidth());
        this.getCoords().setPosY(randomPosY);
        this.getCoords().setPosX(randomPosX);
        return new Coords(randomPosY, randomPosX);
    }

    public int getHp(){
        return hp;
    }

    public void minusHp(int damage){
        this.hp -= damage;
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

    
    public int getCollectedDiamonds() {
        return collectedDiamonds;
    }

    public void setCollectedDiamonds(int collectedDiamonds) {
        this.collectedDiamonds = collectedDiamonds;
    }

}