public class HarmField extends GameObject{
    private int damage;


    public HarmField(String symbol, String colour, String name, Coords coords, int damage){
        super(symbol, colour, name, coords);
        this.damage = damage;
    }

    public int getObjectDamage(){
        return damage;
    }

    @Override
    public void interact(Player player) {
        player.minusHp(damage);
        player.getLastField().setToDefault();		

    }
}