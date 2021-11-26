package buildings.factory;

import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.hotel.Hotel;
import buildings.hotel.HotelFloor;
import inter.Building;
import inter.BuildingFactory;
import inter.Floor;
import inter.Space;

public class HotelFactory implements BuildingFactory {
    @Override
    public Space createSpace(double area) {
        return new Flat(area);
    }

    @Override
    public Space createSpace(int roomsCount, double area) {
        return new Flat(area,roomsCount);
    }

    @Override
    public Floor createFloor(int spaceCount) {
        return new HotelFloor(spaceCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount, int [] flatsCount) {
        return new Hotel(floorsCount,flatsCount);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }
}
