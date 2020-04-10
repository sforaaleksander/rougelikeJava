
public class Heart extends GameObject implements VanishingObject{
    public Heart(Coords coords) {
        super("\u2605", Colours.WHITE, "Life", coords);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void interact(Player player) {
        player.plusHp(1);
        player.getLastField().setToDefault();

    }
}
// U+271a

// \u2764

// U+2726

// U+2605