public class Enemy extends GameObject {

    public Enemy(String symbol, String colour, String name, Coords coords) {
        super(symbol, colour, name, coords);
    }

    @Override
    public void interact(Player player) {
        player.minusHp(1);
        player.getLastField().setToDefault(); // co w przyadku gdy nadepniemy na enemy? czy ma zniknac czy ma isc gdzies
                                              // dalej?jakie obiekt ma sie wyswietlic?

    }

}