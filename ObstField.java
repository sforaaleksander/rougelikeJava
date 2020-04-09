public class ObstField extends GameObject {

    public ObstField(String symbol, String colour, String name, Coords coords) {
        super(symbol, colour, name, coords);
    }

    @Override
    public void interact(Player player) {
        int lastFieldY = player.getLastField().getDefaultObject().getCoords().getPosY();
        int lastFieldX = player.getLastField().getDefaultObject().getCoords().getPosX();
        player.getCoords().setPosY(lastFieldY);
        player.getCoords().setPosX(lastFieldX);
        player.getCurrentMap().getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()].setCurrentObject(player);
    }
}