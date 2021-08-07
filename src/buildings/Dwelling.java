package buildings;

import java.io.OptionalDataException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Dwelling {
    public DwellingFloor [] dwellingFloors;

    public Dwelling(int countFloors, int [] flatsCount){
        this.dwellingFloors = new DwellingFloor[countFloors];
        for (int i = 0; i < countFloors;i++ ){
            this.dwellingFloors[i] = new DwellingFloor(flatsCount[i]);
        }
    }
    public Dwelling(DwellingFloor [] dwellingFloors){
        this.dwellingFloors = dwellingFloors;
    }
    public int getFloorsCountInDwelling(){
        return this.dwellingFloors.length;
    }
    public int getFlatCountInDwelling(){
        int countFlat = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            countFlat += dwellingFloors[i].getCountFlatInFloor();
        }
        return countFlat;
    }
    public double getAreaDwelling(){
        double sumArea = 0;
        for(int i = 0; i < dwellingFloors.length; i++){
            sumArea += dwellingFloors[i].getAreaOfFlatsInFloor();
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
    public Flat getBestSpace(){
        Flat bestFlat = new Flat();
        for(int i = 0; i < dwellingFloors.length; i++){
            DwellingFloor floor = dwellingFloors[i];
            Flat tempFlat = floor.getBestArea();
            if(tempFlat.getArea() > bestFlat.getArea() ){
              bestFlat = tempFlat;
            }
        }
        return bestFlat;
    }
    public  Flat[] sortFlat() {
        Flat[] flats = new Flat[getFlatCountInDwelling()];
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
}
