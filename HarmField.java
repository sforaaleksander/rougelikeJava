public class HarmField extends GameObject{
    private int damage;


    public HarmField(String symbol, String colour, String name, int damage, Coords coords){
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