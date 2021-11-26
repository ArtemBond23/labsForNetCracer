package buildings.dwelling;

import exception.FloorIndexOutOfBoundsException;
import inter.Building;
import inter.Floor;
import inter.Space;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public class Dwelling implements Building, Serializable {
    public Floor [] dwellingFloors;

    public Dwelling(int countFloors, int [] flatsCount){
        this.dwellingFloors = new DwellingFloor[countFloors];
        for (int i = 0; i < countFloors;i++ ){
            this.dwellingFloors[i] = new DwellingFloor(flatsCount[i]);
        }
    }
    public Dwelling(Floor [] dwellingFloors){
        this.dwellingFloors = dwellingFloors;
    }
    /*
    public int getFloorsCountInDwelling(){
        return this.dwellingFloors.length;
    }
    public int getFlatCountInDwelling(){
        int countFlat = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            countFlat += dwellingFloors[i].getCountSpaceOnFloor();
        }
        return countFlat;
    }
    public double getAreaDwelling(){
        double sumArea = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            sumArea += dwellingFloors[i].getSumFloorArea();
        }
        return sumArea;
    }
    public int getRoomOfDwelling(){
        int countRoom = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            countRoom += dwellingFloors[i].getCountRoomInDwelling();
        }
        return countRoom;
    }

    public DwellingFloor[] getFloors(){
        return dwellingFloors;
    }
    public DwellingFloor getFloors(int index){
        return dwellingFloors[index];
    }

    public void setFloors(int index, DwellingFloor floor){
        this.dwellingFloors[index] = floor;
    }

    public Flat getFlatBuIndex(int index){             ///метод получения квартиры по ее номеру в доме
        Flat flat = new Flat();
        for(int i = 0; i < dwellingFloors.length; i++){
            DwellingFloor floor = dwellingFloors[i];
            flat = floor.getFlat(index);
        }
        return flat;
    }

    public void setFlatByIndex(int index, Flat oneFlat){
        for(int i = 0; i < dwellingFloors.length; i++){
            DwellingFloor floor = dwellingFloors[i];
            floor.setFlatIndex(index,oneFlat);
        }
    }

    public void addFlatInDwelling(int index, Flat flat){ // добавить квартиру в дом по номеру
        for(int i = 0; i < dwellingFloors.length; i++){
            DwellingFloor floor = dwellingFloors[i];
            floor.addFlat(index,flat);
        }
    }
    public void deleteFlat(int index){
        for(int i = 0; i < dwellingFloors.length; i++){
            DwellingFloor floor = dwellingFloors[i];
            floor.deleteFlat(index);
        }
    }

     */

    @Override
    public int getCountFloor() {
        return this.dwellingFloors.length;
    }

    @Override
    public int getAllSpace() {
        int countFlat = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            countFlat += dwellingFloors[i].getCountSpaceOnFloor();
        }
        return countFlat;
    }

    @Override
    public double getAllArea() {
        double sumArea = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            sumArea += dwellingFloors[i].getSumFloorArea();
        }
        return sumArea;
    }

    @Override
    public int getAllRoom() {
        int countRoom = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            countRoom += dwellingFloors[i].getSumFloorRoom();
        }
        return countRoom;
    }

    @Override
    public Floor[] getArrayFloor() {
        return dwellingFloors;
    }

    @Override
    public Floor getFloorByNum( int numFloor) {
        return dwellingFloors[numFloor-1];
    }

    @Override
    public void setFloorByNum(Floor newFloor, int numFloor) {
        this.dwellingFloors[numFloor] = newFloor;
    }

    @Override
    public Space getSpaceByNum( int numSpace) {
        if (numSpace <= 0 & numSpace > getCountFloor()) {
            throw new FloorIndexOutOfBoundsException();
        }

        int counter = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            for (int k = 0; k < dwellingFloors[i].getCountSpaceOnFloor(); k++) {
                if (counter++ == numSpace - 1) {
                    return  dwellingFloors[i].getArraySpaceFloor()[k];
                }
            }
        }
        return null;


            /*
            Floor floor = dwellingFloors[i];
            flat = floor.getSpaceByNum(numSpace);

             */

    }

    @Override
    public void setSpaceByNum(Space newSpace, int numSpace) {
        for(int i = 0; i < dwellingFloors.length; i++){
            Floor floor = dwellingFloors[i];
            floor.setSpaceFloor(newSpace,numSpace);
        }
    }

    @Override
    public void addSpaceByNum(Space newSpace, int numSpace) {
        for(int i = 0; i < dwellingFloors.length; i++){
            Floor floor = dwellingFloors[i];
            floor.addSpaceNumber(newSpace,numSpace);
        }
    }

    @Override
    public void removeSpaceByNum(int spaceNum) {
        for(int i = 0; i < dwellingFloors.length; i++){
            Floor floor = dwellingFloors[i];
            floor.removeSpaceFloor(spaceNum);
        }
    }

    public Space getBestSpace(){
        Space bestFlat = new Flat();
        for(int i = 0; i < dwellingFloors.length; i++){
            Floor floor = dwellingFloors[i];
            Space tempFlat = floor.getBestSpace();
            if(tempFlat.getArea() > bestFlat.getArea() ){
              bestFlat = tempFlat;
            }
        }
        return bestFlat;
    }

    @Override
    public Space[] getSortSpaceArray() {
        Flat[] flats = new Flat[getAllSpace()];
        Flat tempFlat;
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for( int i = 0; i < flats.length - 1; i++){
                if(flats[i].getArea() < flats[i+1].getArea()){
                    tempFlat = flats[i];
                    flats[i] = flats[i+1];
                    flats[i+1] = tempFlat;
                    sorted = false;
                }
            }
        }
        return flats;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Dwelling cloneBuilding = (Dwelling) super.clone();
        Floor[] clonedFloors = new Floor[getCountFloor()];
        for (int i = 0; i < dwellingFloors.length; i++) {
            clonedFloors[i] = (Floor) getFloorByNum(i + 1).clone();
        }
        cloneBuilding.dwellingFloors = clonedFloors;

        return cloneBuilding;
    }

    @Override
    public Iterator<Floor> iterator() {
        return new IteratorDwelling();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dwelling dwelling = (Dwelling) o;
        return Arrays.equals(dwellingFloors, dwelling.dwellingFloors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dwellingFloors.length);
        result = 31 * result + Arrays.hashCode(dwellingFloors);
        return result;
    }
    public class IteratorDwelling implements Iterator<Floor>{
        Floor[] floors = getArrayFloor();
        int position = 0;
        @Override
        public boolean hasNext() {
            if (position >= floors.length || floors[position] == null) return false;
            return true;
        }

        @Override
        public Floor next() {
            Floor temp = floors[position];
            position++;
            return temp;
        }
    }
}
