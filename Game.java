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
    private WorldMap worldMap;

    public Game(){
        this.player= new Player();
        this.worldMap = new WorldMap(20, 40);
    }    

    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();

        player.setCurrentMap(worldMap);
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
        worldMap.placeOnMap(new Field(player));
        UI.displayMap(player.getCurrentMap());
    }

}