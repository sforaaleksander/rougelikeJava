
public class Heart extends GameObject {
    public Heart(Coords coords) {
        super("\u2764", Colours.RED, "Life", coords);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void interact(Player player) {
        player.plusHp(1);
        player.getLastField().setToDefault();

    }
}