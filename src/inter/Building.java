package inter;

import buildings.OfficeFloor;

public interface Building {

    int getCountFloor(); //получение количества этажей

    int getAllSpace(); // получение количества помещений в здании

    double getAllArea(); // получение количества общей площади

    int getAllRoom(); // получения количества всех комнат

    Floor [] getArrayFloor(); // получения массива этажей

    Floor getFloorByNum(int numFloor); //получение этажа по номеру

    void setFloorByNum(Floor newFloor, int numFloor); // изменение этажа по номеру

    Space getSpaceByNum( int numSpace); //получение помещения по номеру

    void setSpaceByNum(Space newSpace, int numSpace); //изменение помещения по номеру

    void addSpaceByNum(Space newSpace, int numSpace); //вставка помещения по номеру

    void removeSpaceByNum(int spaceNum); // удаление помещения

    Space getBestSpace(); // лучшее помещ

    Space [] getSortSpaceArray(); // отсортированный массив помещ

}
