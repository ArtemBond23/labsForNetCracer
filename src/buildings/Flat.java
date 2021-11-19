package buildings;

import inter.Space;

import java.io.Serializable;

public class Flat implements Space, Serializable {
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

    //public int getCountOfRoom(){
        //return countOfRoom;
    //}

    //public void setCountOfRoom( int countOfRoom){
        //this.countOfRoom = countOfRoom;
    //}
    public void setArea( double area){
        this.area = area;
    }

    @Override
    public int getRoom() {
        return countOfRoom;
    }

    @Override
    public void setRoom(int room) {
        this.countOfRoom = room;
    }

    public double getArea(){
        return area;
    }
}
