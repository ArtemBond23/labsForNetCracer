package buildings.hotel;

import buildings.dwelling.Dwelling;
import inter.Floor;
import inter.Space;

import java.util.Arrays;

public class Hotel extends Dwelling {
    public Hotel(int countFloors, int[] flatsCount) {
        super(countFloors, flatsCount);
    }

    public Hotel(Floor[] dwellingFloors) {
        super(dwellingFloors);
    }

    public int getStars() {
        int result = 0;
        for (Floor floor : getArrayFloor()) {
            if (floor instanceof HotelFloor) {
                if (result < ((HotelFloor) floor).getStars()) ;
                result = ((HotelFloor) floor).getStars();
            }

        }
        return result;
    }

    public Space getBestSpace() {
        double bestSpace = 0;
        Space bestCoeff = null;
        double[] coeff= {0.25,0.5,1,1.25,1.5,};
        for (int i = 0; i < getAllSpace(); i++) {
            Space currentArea = getSortSpaceArray()[i];
            if (currentArea.getArea() *coeff[getStars()-1] >= bestSpace) {
                bestCoeff =currentArea;
                bestSpace =currentArea.getArea();

            }

        }
        return bestCoeff;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String toString() {
        return "Hotel("+ getStars()+", " + getCountFloor() + ", " + Arrays.toString(getArrayFloor()) + ')';
    }

    @Override
    public boolean equals(Object o) {
        Hotel that = (Hotel) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getCountFloor() == ((Hotel) o).getCountFloor() && Arrays.equals(getArrayFloor(),((Hotel) o).getArrayFloor());
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(getArrayFloor())^getCountFloor();
        return hash;
    }
}
