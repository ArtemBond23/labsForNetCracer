package buildings.office;

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

    public String toString(){
        return String.format("Office{ %d, %.1f}" ,countRoomOffice, areaOffice  );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Double.compare(office.areaOffice, areaOffice) == 0 &&
                countRoomOffice == office.countRoomOffice;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(areaOffice);
        String strArea = Long.toBinaryString(temp);
        int areaBit = Integer.parseInt(strArea.substring(0,8));

        String strRoom = Integer.toBinaryString(countRoomOffice);
        int roomBit= Integer.parseInt(strRoom);

        int result = areaBit^roomBit;
        return result;
    }

    @Override
    public Object clone()  {
        Space cloneSpace = null;
        try {
            cloneSpace =  (Space) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return cloneSpace;
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
