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

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Field[][] getBoard(){
        return board;
    }

    public Field[][] createWorldMap(int height, int width){
        Field[][] newBoard = new Field[height][width];
        for (int y = 0; y < height; y++){
            for (int x = 0; x <width; x++){
                if ( y == 0 || y == height || x == 0 || x == width) {
                    newBoard[y][x] = new ObstField("#", "Frame", new Coords(y,x));
                }
                newBoard[y][x] = new WalkField(",", "Grass", new Coords(y,x));
            }
        }
        return newBoard;
    }
}