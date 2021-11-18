package buildings;

import inter.Building;
import inter.Floor;
import inter.Space;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

       // Flat[] flats = new Flat[]{new Flat(), new Flat(234), new Flat(235,5)};
        Flat[] flats1 = new Flat[5];
        flats1[0] = new Flat(15,5);
        flats1[1] = new Flat(50,6);
        flats1[2] = new Flat(40,6);
        flats1[3] = new Flat(20,6);
        flats1[4] = new Flat(10,6);
        //testFloors();



        test1();






    }

    public static void testFloors(){
        //OfficeFloor officeFloor1 = new OfficeFloor(1);

        //printOfficeFloor(officeFloor1);
        Office[] offices = new Office[]{
                new Office(100),
                new Office(200),
                new Office(300, 8)
        };
        OfficeFloor officeFloor2 = new OfficeFloor(offices);
        printOfficeFloor(officeFloor2);
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
       // printHouse(officeBuilding);
        FileInputStream input = new FileInputStream("OfficeBuildingByte.txt");
        Building building = Buildings.inputBuilding(input);
        //printHouse(building);
        FileWriter fileWriter = new FileWriter("OfficeBuilding.txt");
        Buildings.writeBuilding(building,fileWriter);
        FileReader fileReader = new FileReader("OfficeBuilding.txt");
        Building building1 = Buildings.readBuilding(fileReader);
        printHouse(building1);
    }

    public static void printHouse(Building house) {
        System.out.println();
        System.out.println("дом");
        System.out.println("Кол-во этажей, " + house.getCountFloor());
        System.out.println("Кол-во квартир, " + house.getAllSpace());
        System.out.println("Кол-во комнат, " + house.getAllRoom());
        System.out.println("Кол-во общ площадь, " + house.getAllArea());
    }
    static void printOfficeFloor(OfficeFloor officeFloor){
        Space[] tempOffice = officeFloor.getSpaceArray();
        for(int i = 0; i < officeFloor.getCountSpaceOnFloor(); i++){
            System.out.println("офис номер" + i);
            System.out.println("==площадь" + tempOffice[i].getArea());
            System.out.println("==количество комнат" + tempOffice[i].getRoom());
            System.out.println("=========");

        }
    }

}

