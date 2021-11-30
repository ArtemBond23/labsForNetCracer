package buildings;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.factory.DwellingFactory;
import inter.Building;
import inter.BuildingFactory;
import inter.Floor;
import inter.Space;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Buildings {
    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        int floorsNumber = building.getCountFloor();

        dos.writeInt(floorsNumber);
        for (int i = 1; i <= floorsNumber; i++) {
            Floor floor = building.getFloorByNum(i);
            int spacesNumber = floor.getCountSpaceOnFloor();

            dos.writeInt(spacesNumber);
            for (int j = 1; j <= spacesNumber; j++) {
                Space space = floor.getSpaceByNum(j);

                dos.writeInt(space.getRoom());
                dos.writeDouble(space.getArea());
            }

        }

    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);

        int floorsNumber = dis.readInt();
        Floor[] floors = new Floor[floorsNumber];

        for (int i = 0; i < floorsNumber; i++) {

            int spaceNumber = dis.readInt();
            Space[] spaces = new Space[spaceNumber];

            for (int j = 0; j < spaces.length; j++) {
                int rooms = dis.readInt();
                double area = dis.readDouble();
                spaces[j] = new Flat(area, rooms);

            }
            floors[i] = new DwellingFloor(spaces);
        }
        return new Dwelling(floors);
    }

    public static void writeBuilding(Building building, Writer out) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        bufferedWriter.write(building.getCountFloor() + " ");
        Floor[] floors = building.getArrayFloor();
        for (int i = 0; i < floors.length; i++) {
            int countOfSpaces = floors[i].getCountSpaceOnFloor();
            bufferedWriter.write(countOfSpaces + " ");
            Space[] spaces = floors[i].getArraySpaceFloor();
            for (int j = 0; j < spaces.length; j++) {
                bufferedWriter.write(spaces[j].getRoom() + " ");
                bufferedWriter.write(String.format("%.2f", spaces[j].getArea()) + " ");
            }
        }
        bufferedWriter.close();
    }

    public static Building readBuilding(Reader in) {
        Scanner scanner = new Scanner(in);
        int countFloor = scanner.nextInt();
        Floor[] floors = new Floor[countFloor];
        for (int i = 0; i < floors.length; i++) {
            int countSpace = scanner.nextInt();
            Space[] space = new Space[countSpace];
            for (int j = 0; j < space.length; j++) {
                int roomCount = scanner.nextInt();
                double area = scanner.nextDouble();
                space[j] = new Flat(area, roomCount);
            }
            floors[i] = new DwellingFloor(space);
        }
        return new Dwelling(floors);
    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream seriazeble = new ObjectOutputStream(out);
        seriazeble.writeObject(building);
    }

    public static Building deserializeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream deseriazable = new ObjectInputStream(in);
        return (Building) deseriazable.readObject();
    }

    public static void writeBuildingFormat(Building building, Writer out) {
        PrintWriter pw = new PrintWriter(out);
        int floorCount = building.getCountFloor();
        pw.printf("%d ", floorCount);
        for (int i = 1; i <= floorCount; i++) {
            int spaceCount = building.getFloorByNum(i).getCountSpaceOnFloor();
            pw.printf("%d ", spaceCount);
            for (int j = 1; j <= spaceCount; j++) {
                Space space = building.getFloorByNum(i).getSpaceByNum(j);
                pw.printf("%d ", space.getRoom());
                pw.printf("%.1f ", space.getArea());
            }
        }
        pw.close();
    }

    public static Building readBuilding(Scanner scanner) {
        Floor[] floors = new Floor[scanner.nextInt()];
        for (int i = 0; i < floors.length; i++) {
            int spacesCount = scanner.nextInt();
            Space[] spaces = new Space[spacesCount];
            for (int j = 0; j < spaces.length; j++) {
                int roomCount = scanner.nextInt();
                double area = scanner.nextDouble();
                spaces[j] = new Flat(area, roomCount);
            }
            floors[i] = new DwellingFloor(spaces);
        }
        return new Dwelling(floors);
    }

    public static <T extends Comparable<T>> void sortArrayAsc(T[] objects) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < objects.length; i++) {
                if (objects[i].compareTo(objects[i - 1]) < 0) {
                    isSorted = false;

                    T current = objects[i];
                    objects[i] = objects[i - 1];
                    objects[i - 1] = current;
                }
            }
        }
    }

    public static <T> void sortArrayDesc(T[] objects, Comparator<T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < objects.length; i++) {
                if (comparator.compare(objects[i], objects[i - 1]) > 0) {
                    isSorted = false;

                    T current = objects[i];
                    objects[i] = objects[i - 1];
                    objects[i - 1] = current;
                }
            }
        }
    }


    public static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }

    public static Space createSpace(double area) {
        return buildingFactory.createSpace(area);
    }

    public static Space createSpace(int roomsCount, double area) {
        return buildingFactory.createSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount) {
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] flatsCount) {
        return buildingFactory.createBuilding(floorsCount, flatsCount);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }

    public static Floor synchronizedFloor(Floor floor) {
        return new SynchronizedFloor(floor);
    }

    public static Space createSpace(double area, Class<Space> spaceClass) {
        try {
            Constructor<Space> constructor = spaceClass.getConstructor(double.class);
            return constructor.newInstance(area);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Space createSpace(Integer roomsCount, Double area, Class<Space> spaceClass) {
        try {
            Constructor<Space> constructor = spaceClass.getConstructor(int.class, double.class);
            return constructor.newInstance(roomsCount, area);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }

    public static Floor createFloor(int spacesCount, Class<Floor> spaceClass) {
        try {
            Constructor<Floor> constructor = spaceClass.getConstructor(int.class);
            return constructor.newInstance(spacesCount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Floor createFloor(Space[] spaces, Class<Floor> spaceClass) {
        try {
            Constructor<Floor> constructor = spaceClass.getConstructor(Space.class);
            return constructor.newInstance(spaces);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
    public static Building createBuilding(Integer floorsCount, Class<Building> createBuilding) {
        try {
            Constructor<Building> constructor = createBuilding.getConstructor(Building.class);
            return constructor.newInstance(floorsCount);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Building createBuilding(Class<Building> createBuilding, Floor... floors) {
        try {
            Constructor<Building> constructor = createBuilding.getConstructor(Building.class);
            return constructor.newInstance(floors);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
    public static Building inputBuilding(InputStream in, Class<Space> spaceClass, Class<Floor> floorClass, Class<Building> buildingClass) throws IOException {
        DataInputStream dis = new DataInputStream(in);
        int floorsNumber = dis.readInt();
        Floor[] floors = new Floor[floorsNumber];

        for (int i = 0; i < floorsNumber; i++) {

            int spaceNumber = dis.readInt();
            Space[] spaces = new Space[spaceNumber];

            for (int j = 0; j < spaces.length; j++) {
                int rooms = dis.readInt();
                double area = dis.readDouble();
                spaces[j] = createSpace(rooms, area,spaceClass);

            }
            floors[i] = createFloor(spaces);
        }
        return createBuilding(floors);
    }


    public static Building readBuilding(Reader in, Class<Space> spaceClass, Class<Floor> floorClass, Class<Building> buildingClass) throws IOException {

        Scanner scanner = new Scanner(in);
        int countFloor = scanner.nextInt();
        Floor[] floors = new Floor[countFloor];
        for (int i = 0; i < floors.length; i++) {
            int countSpace = scanner.nextInt();
            Space[] space = new Space[countSpace];
            for (int j = 0; j < space.length; j++) {
                int roomCount = scanner.nextInt();
                double area = scanner.nextDouble();
                space[j] = createSpace(roomCount,area,spaceClass);
            }
            floors[i] = createFloor(space);
        }
        return createBuilding(floors);
    }

}
