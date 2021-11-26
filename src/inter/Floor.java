package inter;

import java.io.Serializable;
import java.util.Iterator;


public interface  Floor extends Serializable, Iterable<Space> {

    int getCountSpaceOnFloor(); //кол-во помещ на этаже

    double getSumFloorArea(); //общая площадь на этаже

    Space[] getArraySpaceFloor(); //массив всех помещ на этаже

    int getSumFloorRoom(); //общее кол-во комнат

    Space getSpaceByNum(int spaceNum);

    void setSpaceFloor(Space newSpace, int spaceNum);

    void addSpaceNumber(Space addSpace, int spaceNum);

    void removeSpaceFloor(int spaceNum);

    Space getBestSpace();

    Object clone();

    Iterator<Space> iterator();

}
