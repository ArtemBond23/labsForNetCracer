package buildings;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

       // Flat[] flats = new Flat[]{new Flat(), new Flat(234), new Flat(235,5)};
        Flat[] flats1 = new Flat[5];
        flats1[0] = new Flat(15,5);
        flats1[1] = new Flat(50,6);
        flats1[2] = new Flat(40,6);
        flats1[3] = new Flat(20,6);
        flats1[4] = new Flat(10,6);
        DwellingFloor testDwelling = new DwellingFloor(flats1);
        int[] flats = {3,2,4};
        Dwelling dwelling = new Dwelling(3,flats);

        System.out.println(dwelling.getFlatBuIndex(2));
    }
}

