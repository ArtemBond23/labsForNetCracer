package buildings;

import inter.Floor;
import inter.Space;

public class DwellingFloor implements Floor {
    //public Flat [] flats ;
    public Space [] flats ;

    public DwellingFloor(int countOfFlats){
        this.flats = new Flat[countOfFlats];
        for (int i = 0; i < countOfFlats;i++ ){
            flats[i] = new Flat();

        }
    }

    public DwellingFloor(Flat [] flats){
        this.flats = flats;
    }
    //public int getCountFlatInFloor(){
       //return flats.length;
   // }
    /*public double getAreaOfFlatsInFloor(){
        double area = 0;
        for (Space flat : flats) {
            area += flat.getArea();
        }
        return area;
    }
     public int getCountRoomInDwelling(){
        int count = 0;
        for(Space flat : flats){
            count+=flat.getRoom();
        }
        return count;
    }
    public Flat[] getflatsOrDwelling(){
        return flats;
    }
    public Flat getFlat(int index){
        if(index >=flats.length || index < 0){
        return null;
        }
        return flats[index];
    }
    public void setFlatIndex(int index, Flat flat){
        this.flats[index] = flat;
    }
    public void addFlat(int index, Flat flat){
        Space [] newFlats = new Flat[flats.length + 1];
        for(int i = 0; i < flats.length; i++){
            newFlats[i] = flats[i]; // приравниваем обекты
        }
        for(int i = newFlats.length-1; i >= index; i--){
            newFlats[i] = newFlats[i-1];
        }
        newFlats[index] = flat;
        flats = newFlats;
    }
    public void deleteFlat(int index){
        flats[index] = null;
    }


    public Space getBestArea(){
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
     */
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
    public Space[] getArrayFloor() {
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
        return flats[spaceNum];
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
}
