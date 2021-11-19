package buildings;

import inter.Space;

import java.io.Serializable;

public class Office implements Space, Serializable {
    private double areaOffice;
    private int countRoomOffice;
    public final static double DEFOLT_AREA = 250;
    public final static int DEFOLT_COUNT_OF_ROOM = 1;

    public Office(){
      areaOffice = DEFOLT_AREA;
      countRoomOffice = DEFOLT_COUNT_OF_ROOM;
    }
    public Office(double areaOffice){
        this.areaOffice = areaOffice;
        countRoomOffice = DEFOLT_COUNT_OF_ROOM;
    }
    public Office(double areaOffice, int countRoomOffice){
        this.areaOffice = areaOffice;
        this.countRoomOffice = countRoomOffice;
    }
    //public int getCountRoomOffice(){
        //return countRoomOffice;
    //}
    //public void setCountRoomOffice(int countRoomOffice){
        //this.countRoomOffice = countRoomOffice;
    //}
    //public double getAreaOffice(){
        //return  areaOffice;
    //}
    //public void setAreaOffice(double areaOffice){
       // this.areaOffice = areaOffice;
    //}

    @Override
    public int getRoom() {
        return countRoomOffice;
    }

    @Override
    public void setRoom(int room) {
        this.countRoomOffice = room;
    }

    @Override
    public double getArea() {
        return areaOffice;
    }

    @Override
    public void setArea(double area) {
        this.areaOffice = area;
    }
}
