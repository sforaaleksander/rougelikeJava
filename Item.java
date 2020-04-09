// public class Item extends GameObject{

//     public Item(Coords coords) {
//         super( coords);

//     }

//     public Item(String symbol, String colour, String name, Coords coords) {
//         super(symbol, colour , name, coords);

//     }

//     @Override
//     public void interact(Player player) {
//         // TODO Auto-generated method stub
//         if (this.getName().equals("Life")) {
//             player.plusHp(1);
//         } else if (this.getName().equals("Diamond")) {
//             player.setCollectedDiamonds(player.getCollectedDiamonds()+1);
//         }
        
//         player.getLastField().setToDefault();


//     }

// }