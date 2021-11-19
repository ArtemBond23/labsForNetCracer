package inter;

import java.io.Serializable;

public interface Space extends Serializable {
    int getRoom();
    void setRoom(int room);
    double getArea();
    void setArea( double area);
}
