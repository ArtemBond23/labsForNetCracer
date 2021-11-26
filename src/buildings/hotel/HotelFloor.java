package buildings.hotel;

import buildings.dwelling.DwellingFloor;
import inter.Space;

import java.util.Arrays;
import java.util.Objects;

public class HotelFloor extends DwellingFloor {
    private int countOfStars;
    public final static int STAR = 1;


    public HotelFloor(int countOfFlats) {
        super(countOfFlats);
        this.countOfStars = STAR;
    }

    public HotelFloor(Space[] flats) {
        super(flats);
        this.countOfStars = STAR;
    }
    public int getStars() {
        return countOfStars;
    }

    public void setStars(int stars) {
        this.countOfStars = stars;
    }

    @Override
    public String toString() {
            return "Hotel("+ getStars()+", " + getCountSpaceOnFloor() + ", " + Arrays.toString(getArraySpaceFloor()) + ')';
    }

    @Override
    public boolean equals(Object o) {
        HotelFloor that = (HotelFloor) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (getStars() != ((HotelFloor) o).getStars()) return false;
        Space[] arrayFloor = getArraySpaceFloor();
        Space[] arrayFloor1 = ((HotelFloor) o).getArraySpaceFloor();

        for (int i = 0; i < arrayFloor.length; i++) {
            if (arrayFloor[i].getArea() != arrayFloor1[i].getArea()) return false;
            if (arrayFloor[i].getRoom() != arrayFloor1[i].getRoom()) return false;

        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(getArraySpaceFloor())^getStars();
        return hash;
    }

}
