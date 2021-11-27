package buildings.threads;

import inter.Floor;
import inter.Space;

public class SequentalCleaner extends  Thread{
    private Floor floor;

    Semaphore semaphore;

    public SequentalCleaner(Floor floor, Semaphore semafore){
        this.floor = floor;
        this.semaphore = semafore;
    }

    @Override
    public void run() {
        Space[] spaces = floor.getArraySpaceFloor();

        synchronized (semaphore) {
            for (int i = 0; i < spaces.length; i++) {
                if (semaphore.semaphore) {
                    try {
                        semaphore.notify();
                        System.out.println("«Repairing space number" + i + " with total area" + spaces[i].getArea() + "square meters».");
                        semaphore.semaphore =false;
                        semaphore.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
