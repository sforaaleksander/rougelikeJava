public class ObstField extends GameObject{

    public ObstField(String symbol, String name, Coords coords){
        super(symbol, name, coords);
    }

    @Override
    public boolean interact(Player player) {
            return false;
    }
}