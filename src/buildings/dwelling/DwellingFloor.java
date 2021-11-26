package buildings.dwelling;

import inter.Floor;
import inter.Space;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class DwellingFloor implements Floor, Serializable, Iterable<Space> {

    public Space [] flats ;

    public DwellingFloor(int countOfFlats){
        this.flats = new Flat[countOfFlats];
        for (int i = 0; i < countOfFlats;i++ ){
            flats[i] = new Flat();

        }
    }

    public DwellingFloor(Space [] flats){
        this.flats = flats;
    }

    @Override
    public int getCountSpaceOnFloor() {
        return flats.length;
    }

    @Override
    public double getSumFloorArea() {
        double area = 0;
        for (Space flat : flats) {
            area += flat.getArea();
        }
        return area;
    }

    @Override
    public Space[] getArraySpaceFloor() {
        return flats;
    }

    @Override
    public int getSumFloorRoom() {
        int count = 0;
        for(Space flat : flats){
            count+=flat.getRoom();
        }
        return count;
    }

    @Override
    public Space getSpaceByNum(int spaceNum) {
        return flats[spaceNum-1];
    }

    @Override
    public void setSpaceFloor(Space addSpace, int spaceNum) {
        this.flats[spaceNum] = addSpace;
    }

    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum) {
        Space [] newFlats = new Flat[flats.length + 1];
        for(int i = 0; i < flats.length; i++){
            newFlats[i] = flats[i]; // приравниваем обекты
        }
        for(int i = newFlats.length-1; i >= spaceNum; i--){
            newFlats[i] = newFlats[i-1];
        }
        newFlats[spaceNum] = addSpace;
        flats = newFlats;
    }

    @Override
    public void removeSpaceFloor(int spaceNum) {
        flats[spaceNum] = null;
    }

    @Override
    public Space getBestSpace() {
        double bestArea = 0;
        Space bestFlat = null;
        for(int i = 0; i < flats.length; i++){
            if(flats[i].getArea() > bestArea){
                bestArea = flats[i].getArea();
                bestFlat = flats[i];
            }
        }
        return bestFlat;
    }

    @Override
    public Object clone() {
        DwellingFloor clonedFloor = null;
        try {
            clonedFloor = (DwellingFloor) super.clone();
            Space[] clonedSpaces = new Space[getCountSpaceOnFloor()];
            for (int i = 0; i < flats.length; i++) {
                clonedSpaces[i] = ((Space) getSpaceByNum(i + 1).clone());
            }
            clonedFloor.flats = clonedSpaces;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedFloor;
    }

    @Override
    public Iterator<Space> iterator() {
        return new DwellingFloorIterator();
    }

    @Override
    public String toString() {
        return "DwellingFloor{" + getCountSpaceOnFloor()+
                "flats=" + Arrays.toString(flats) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DwellingFloor that = (DwellingFloor) o;
        return Arrays.equals(flats, that.flats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(flats.length);
        result = 31 * result + Arrays.hashCode(getArraySpaceFloor());
        return result;
    }
    public class DwellingFloorIterator implements Iterator<Space> {
        Space[] spaces = getArraySpaceFloor();
        int position = 0;

        @Override
        public boolean hasNext() {
            if (position >= spaces.length || spaces[position] == null) return false;
            return true;
        }

        @Override
        public Space next() {
            Space temp = spaces[position];
            position++;
            return temp;
        }
    }
}
