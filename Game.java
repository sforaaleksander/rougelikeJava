import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    private static final Coords UP = new Coords(-1, 0);
    private static final Coords DOWN = new Coords(1, 0);
    private static final Coords LEFT = new Coords(0, -1);
    private static final Coords RIGHT = new Coords(0, 1);
    private List<WorldMap> maps;
    private Player player;

    public Game(){
        this.player = new Player();

    }    

    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();

        // player.setCurrentMap(player.getCurrentMap());
        System.out.println((int) ch);

        switch (ch) {
            case 'w':
                player.playerMove(UP);
                break;
            case 's':
                player.playerMove(DOWN);
                break;
            case 'a':
                player.playerMove(LEFT);
                break;
            case 'd':
                player.playerMove(RIGHT);
                break;
        }
        // player.getCurrentMap().placeOnMap(new Field(player));

        player.getCurrentMap().getBoard()[player.getCoords().getposY()][player.getCoords().getposX()].setCurrentObject(player);

        player.getLastField().setToDefault();

        UI.displayMap(player.getCurrentMap());
    }

}