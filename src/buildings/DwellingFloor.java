package buildings;

public class DwellingFloor {
    public Flat [] flats ;

    public DwellingFloor(int countOfFlats){
        this.flats = new Flat[countOfFlats];
        for (int i = 0; i < countOfFlats;i++ ){
            flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat [] flats){
        this.flats = flats;
    }
    public int getCountFlatInFloor(){
       return flats.length;
    }
    public double getAreaOfFlatsInFloor(){
        double area = 0;
        for (Flat flat : flats) {
            area += flat.getArea();
        }
        return area;
    }
    public int getCountRoomInDwelling(){
        int count = 0;
        for(Flat flat : flats){
            count+=flat.getCountOfRoom();
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
        Flat[] newFlats = new Flat[flats.length + 1];
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


    public Flat getBestArea(){
        double bestArea = 0;
        Flat bestFlat = null;
        for(int i = 0; i < flats.length; i++){
            if(flats[i].getArea() > bestArea){
                bestArea = flats[i].getArea();
                bestFlat = flats[i];
            }
        }
        return bestFlat;
    }

}
