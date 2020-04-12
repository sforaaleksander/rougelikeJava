
public class Diamond extends GameObject implements VanishingObject{

	public Diamond(Coords coords) {
		super(Object.DIAMOND.symbol, Object.DIAMOND.colour, "Diamond", coords);
	}

	@Override
	public void interact(Player player) {
        player.setCollectedDiamonds(player.getCollectedDiamonds()+1);
        player.getLastField().setToDefault();	
	}
    
}