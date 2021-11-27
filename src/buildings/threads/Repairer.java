package buildings.threads;

import inter.Floor;
import inter.Space;

public class Repairer extends Thread{
    private Floor floor;
    public Repairer(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void run() {
        Space[] spaces = floor.getArraySpaceFloor();
        for (int i = 0; i < spaces.length; i++) {
            System.out.println("«Repairing space number" +" "+  i +" "+  " with total area" +" "+  spaces[i].getArea() +" "+  "square meters»."+ " "+ getName());
        }
    }
}
