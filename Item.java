public class Item extends GameObject{

    public Item(Coords coords) {
        super("\u25C6", Colours.CYAN , "Diamond", coords);

    }

    public Item(String symbol, String colour, String name, Coords coords) {
        super(symbol, colour , name, coords);

    }

    @Override
    public void interact(Player player) {
        // TODO Auto-generated method stub
        player.setCollectedDiamonds(player.getCollectedDiamonds()+1);
        player.getLastField().setToDefault();


    }

}