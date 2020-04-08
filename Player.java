public class Player extends GameObject{
    private WorldMap currentMap;

    public Player(){ // ask about passing parameters to super constructor?
        super("@", IO.gatherInput("Type in your hero's name"), new Coords(5,5));
        this.currentMap = new WorldMap(20, 40);
    }


    public void playerMove(Coords coords){
        int y = this.getCoords().getposY() + coords.getposY();
        int x = this.getCoords().getposX() + coords.getposX();
        this.getCoords().setposY(y);
        this.getCoords().setposX(x);
        GameObject nextStep = getCurrentMap().getBoard()[y][x].getGameObject();
        
    }

	public void setCurrentMap(WorldMap worldMap) {
        this.currentMap=worldMap;
	}

	public WorldMap getCurrentMap() {
		return currentMap;
	}

    @Override
    public void interact(Player player) {
        // none

    }
}