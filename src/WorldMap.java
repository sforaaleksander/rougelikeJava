package src;

public class WorldMap {
    private Field[][] board;
    private int width;
    private int height;

    public WorldMap (int height, int width){
        this.width = width;
        this.height = height;
        this.board = createWorldMap(width, height);
    }


    public Field[][] createWorldMap(int height, int width){
        WalkField grass = new WalkField(",", "Grass");
        ObstField frame = new ObstField("#", "Frame");

        for (int y = 0; y < height; y++){
            for (int x = 0; x <width; x++){
                
            }
        }
        
    }
}