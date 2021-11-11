package buildings;

import inter.Building;
import inter.Floor;
import inter.Space;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

       // Flat[] flats = new Flat[]{new Flat(), new Flat(234), new Flat(235,5)};
        Flat[] flats1 = new Flat[5];
        flats1[0] = new Flat(15,5);
        flats1[1] = new Flat(50,6);
        flats1[2] = new Flat(40,6);
        flats1[3] = new Flat(20,6);
        flats1[4] = new Flat(10,6);


        DwellingFloor testDwelling = new DwellingFloor(flats1);

        System.out.println(flats1[1]);
        System.out.println(flats1[2]);
        //int[] flats = {3,2,4};

        Floor[] floors = new Floor[]{
                new OfficeFloor(flats1),
        };
        System.out.println(testDwelling.getSpaceByNum(2)+ "ваша квартира222");


       //OfficeBuilding building = new OfficeBuilding(floors);
        //System.out.println(building.getSpaceByNum(3)+ "ваша квартира1");
        Dwelling dwelling = new Dwelling(floors);
        System.out.println(dwelling.getSpaceByNum(2)+ "ваша квартира2");

       // int[] flats = {3,2,4};
        //testDwelling.getSpaceByNum(3);
        System.out.println(testDwelling.getSpaceByNum(1)+ "ваша квартира");
       // System.out.println(flats1[3]);
       // System.out.println(flats1[2]);

        //test1();






        //Dwelling dwelling = new Dwelling(3,flats);
        //System.out.println(dwelling.getFlatBuIndex(2) + "квартира 1 " );
        //System.out.println(flats[0]);

       // OfficeFloor officeFloor = new OfficeFloor(5);

        //officeFloor.addOffice(6,new Office());
        //System.out.println(officeFloor);
        //officeFloor.remove(2);
       // int[] floors = {3,2,4};
      // OfficeFloor [] newOfficefl = new OfficeFloor[3];
      // OfficeBuilding officeBuilding = new OfficeBuilding(3,floors );

        //System.out.println(officeBuilding);
    }

    public static void test1() throws IOException {
        Space[] spaces = new Space[] {
                new Office(100),
                new Office(200),
                new Office(300),
                new Office(400)
        };
        Floor[] floors = new Floor[] {
                new OfficeFloor(spaces),
                new OfficeFloor(spaces)
        };
        OfficeBuilding officeBuilding = new OfficeBuilding(floors);
        System.out.println(officeBuilding.getCountFloor());
        FileOutputStream fos = new FileOutputStream("OfficeBuildingByte.txt");
        Buildings.outputBuilding(officeBuilding, fos);
        printHouse(officeBuilding);
    }

    public static void printHouse(Building house) {
        System.out.println();// отступ
        System.out.println("дом");
        System.out.println("Кол-во этажей, " + house.getCountFloor());
        System.out.println("Кол-во квартир, " + house.getAllSpace());
        System.out.println("Кол-во комнат, " + house.getAllRoom());
        System.out.println("Кол-во общ площадь, " + house.getAllArea());
    }
}

