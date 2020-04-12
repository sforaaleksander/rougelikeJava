
public class Heart extends GameObject implements VanishingObject {
    public Heart(Coords coords) {
        super(Object.HEART.symbol, Object.HEART.colour, "Life", coords);
    }

    @Override
    public void interact(Player player) {
        player.plusHp(1);
        player.getLastField().setToDefault();
    }
}
