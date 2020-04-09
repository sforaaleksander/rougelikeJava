
public class Diamond extends GameObject implements VanishingObject{

	public Diamond(Coords coords) {
		super("\u25C6", Colours.CYAN , "Diamond", coords);
		//TODO Auto-generated constructor stub
	}

	@Override
	public void interact(Player player) {
        player.setCollectedDiamonds(player.getCollectedDiamonds()+1);
        player.getLastField().setToDefault();	
	}
    
}