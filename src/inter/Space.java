package inter;

import java.io.Serializable;

public interface Space extends Serializable, Comparable<Space> {
    int getRoom();
    void setRoom(int room);
    double getArea();
    void setArea( double area);
    Object clone();
    int compareTo (Space o);
}
