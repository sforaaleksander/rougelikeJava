public class WalkField extends GameObject{    

    public WalkField(String symbol, String name, Coords coords){
        super(symbol, name, coords);
    }

	@Override
	public void interact(Player player) {
		player.getCurrentMap().getBoard()[player.getLastField().getGameObject().getCoords().getposY()][player.getLastField().getGameObject().getCoords().getposX()]
		
	}

}