public class WalkField extends GameObject{    

    public WalkField(String symbol, String colour, String name, Coords coords){
        super(symbol, colour, name, coords);
    }

	@Override
	public void interact(Player player) {
        player.getLastField().setToDefault();		
	}

}