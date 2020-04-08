public class WalkField extends GameObject{    

    public WalkField(String symbol, String name, Coords coords){
        super(symbol, name, coords);
    }

	@Override
	public void interact(Player player) {
        player.getLastField().setToDefault();		
	}

}