package buildings;

public class Flat {
    private double area;
    private int countOfRoom;
    public final static double DEFOLT_AREA = 50;
    public final static int DEFOLT_COUNT_OF_ROOM = 2;
    public Flat(){
        area = DEFOLT_AREA;
        countOfRoom = DEFOLT_COUNT_OF_ROOM;
        }
    public Flat(double area){
        this.area = area;
        countOfRoom = DEFOLT_COUNT_OF_ROOM;
    }

    public Flat(double area, int countOfRoom){
        this.area = area;
        this.countOfRoom = countOfRoom;
    }

    public int getCountOfRoom(){
        return countOfRoom;
    }

    public void setCountOfRoom( int countOfRoom){
        this.countOfRoom = countOfRoom;
    }
    public void setArea( double area){
        this.area = area;
    }
    public double getArea(){
        return area;
    }
}
