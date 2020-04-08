public class HarmField extends GameObject{
    private int minusHP;


    public HarmField(String symbol, String name, Coords coords, int minusHP){
        super(symbol, name, coords);
        this.minusHP = minusHP;
    }

    public int getMinusHP(){
        return minusHP;
    }

    @Override
    public void interact(Player player) {
        // take players HP
    }
}