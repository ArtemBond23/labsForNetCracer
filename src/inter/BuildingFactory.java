package inter;

public interface BuildingFactory {
    Space createSpace(double area);

    Space createSpace(int roomsCount, double area);

    Floor createFloor(int spaceCount);

    Floor createFloor(Space[]spaces);

    Building createBuilding(int floorsCount, int [] flatsCount);

    Building createBuilding(Floor[]floors);
}
