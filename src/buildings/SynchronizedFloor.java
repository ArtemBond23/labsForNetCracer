package buildings;

import inter.Floor;
import inter.Space;

import java.util.Iterator;

public class SynchronizedFloor implements Floor {
    private Floor floor;

    public SynchronizedFloor(Floor floor) {
        this.floor = floor;
    }
    @Override
    public int getCountSpaceOnFloor() {
        return floor.getCountSpaceOnFloor();
    }

    @Override
    public double getSumFloorArea() {
        return floor.getSumFloorArea();
    }

    @Override
    public Space[] getArraySpaceFloor() {
        return floor.getArraySpaceFloor();
    }

    @Override
    public int getSumFloorRoom() {
        return floor.getCountSpaceOnFloor();
    }

    @Override
    public Space getSpaceByNum(int spaceNum) {
        return floor.getSpaceByNum(spaceNum);
    }

    @Override
    public void setSpaceFloor(Space newSpace, int spaceNum) {
        floor.setSpaceFloor(newSpace,spaceNum);
    }

    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum) {
        floor.addSpaceNumber(addSpace,spaceNum);
    }

    @Override
    public void removeSpaceFloor(int spaceNum) {
         floor.removeSpaceFloor(spaceNum);
    }

    @Override
    public Space getBestSpace() {
        return floor.getBestSpace();
    }

    @Override
    public Object clone() {
        return floor.clone();
    }

    @Override
    public Iterator<Space> iterator() {
        return floor.iterator();
    }

    @Override
    public int compareTo(Floor o) {
        return compareTo(o);
    }
    @Override
    public String toString() {
        return "SynchronizedFloor{" +
                "floor=" + floor +
                '}';
    }
}
