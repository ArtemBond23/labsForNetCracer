package buildings.dwelling;

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

    @Override
    public String toString() {
        return String.format("Flat{ %d, %.1f}" ,countOfRoom, area  );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Double.compare(flat.area, area) == 0 &&
                countOfRoom == flat.countOfRoom;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(area);
        String strArea = Long.toBinaryString(temp);
        int areaBit = Integer.parseInt(strArea.substring(0, 8));

        String strRoom = Integer.toBinaryString(countOfRoom);
        int roomBit = Integer.parseInt(strRoom);

        int result = areaBit ^ roomBit;
        return result;
    }
    @Override
    public Object clone() {
        Space cloneFlat;
        try {
            cloneFlat = (Space) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return cloneFlat;
    }

    @Override
    public int compareTo(Space o) {
        if (getArea() < o.getArea()) {
            return 1;
        } else if (getArea() > o.getArea()) {
            return -1;
        }
        return 0;
    }
}
