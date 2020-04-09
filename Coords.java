public class Coords {
    public static final Coords UP = new Coords(-1, 0);
    public static final Coords DOWN = new Coords(1, 0);
    public static final Coords LEFT = new Coords(0, -1);
    public static final Coords RIGHT = new Coords(0, 1);
    private int posY;
    private int posX;

    public Coords(int posY, int posX){
        this.posY = posY;
        this.posX = posX;
    }

    public int getPosY(){
        return posY;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public void setPosX(int posX){
        this.posX = posX;
        }
}