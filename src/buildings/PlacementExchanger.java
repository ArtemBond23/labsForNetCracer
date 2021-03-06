package buildings;

import exception.FloorIndexOutOfBoundsException;
import exception.InexchangeableFloorsException;
import exception.InexchangeableSpacesException;
import inter.Building;
import inter.Floor;
import inter.Space;

public class PlacementExchanger {
    public static boolean checkExchangeSpace(Space firstSpace, Space secondSpace) {
        return firstSpace.getArea() == secondSpace.getArea() && firstSpace.getRoom() == secondSpace.getRoom();
    }
    public static boolean checkExchangeFloor(Floor firstFloor, Floor secondFloor) {
        return firstFloor.getSumFloorArea() == secondFloor.getSumFloorArea() && firstFloor.getSumFloorRoom() == secondFloor.getSumFloorRoom();
    }
    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException {
        if (!checkExchangeSpace(floor1.getSpaceByNum(index1), floor2.getSpaceByNum(index2))) {
            throw new InexchangeableSpacesException();
        }
        if (index1 <= 0 & index1 > floor1.getCountSpaceOnFloor() && index2 <= 0 & index2 > floor2.getCountSpaceOnFloor()) {
            throw  new FloorIndexOutOfBoundsException();

        } else {
            Space current = floor1.getSpaceByNum(index1);
            floor1.setSpaceFloor(floor2.getSpaceByNum(index2), index1);
            floor2.setSpaceFloor(current, index2);
        }


    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableSpacesException {
        if (!checkExchangeFloor(building1.getFloorByNum(index1), building2.getFloorByNum(index2))){
            throw new InexchangeableFloorsException("этаж не соответствует обмену");
        }
        if(index1 <=0 & index1 > building1.getCountFloor() && index2 <=0 & index2 > building2.getCountFloor()){
            throw new FloorIndexOutOfBoundsException();
        }
        else{
        Floor current = building1.getFloorByNum(index1);
        building1.setFloorByNum(building2.getFloorByNum(index2), index1);
        building2.setFloorByNum(current,index2);
        }
    }


}
