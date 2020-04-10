
public class Diamond extends GameObject implements VanishingObject{

	public Diamond(Coords coords) {
		super("\u25C6", Colours.YELLOW, "Diamond", coords);
	}

	@Override
	public void interact(Player player) {
        player.setCollectedDiamonds(player.getCollectedDiamonds()+1);
        player.getLastField().setToDefault();	
	}
    
}