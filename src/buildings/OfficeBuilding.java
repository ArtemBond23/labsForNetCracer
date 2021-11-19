package buildings;

import exception.FloorIndexOutOfBoundsException;
import exception.SpaceIndexOutOfBoundsException;
import inter.Building;
import inter.Floor;
import inter.Space;

import java.io.Serializable;

public class OfficeBuilding implements Building, Serializable {

    private Node head;
    private  int countFloor;


    private static class Node{
        Floor floor;
        Node next;
        Node prev;

        //public Node(OfficeFloor floor, Node next, Node prev) {
            //this.floor = floor;
            //this.next = next;
            //this.prev = prev;
       // }

    }
    private OfficeBuilding(){
        head = new Node();
        head.floor = new OfficeFloor();
        head.next = head;
        head.prev = head;
    }

    private void addNode(Node newNode, int index){
    Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node aft = temp.next;
        newNode.next = aft;
        newNode.prev = temp;
        temp.next = newNode;
        //newNode.next = temp.next;//почему так
        countFloor++;
    }


    private Node getNode(int index){
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    private void deleteNode(int index){
        Node current = head;
        for (int k = 1; k < index - 1; k++){
            current = current.next;
        }
        Node del = current.next;
        Node aft = del.next;
        current.next = aft;
        aft.prev = current.next;
        countFloor--;
    }


    public OfficeBuilding(int floorsCount, int[] floors) {
        this();
        Node current = head;
        this.countFloor = floorsCount;
        for (int i = 1; i < countFloor; i++) {
            Node newNode = new Node();
            newNode.floor = new OfficeFloor(floors[i]);
            newNode.next = head;
            newNode.prev = head;
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            countFloor++;
        }
    }
    public OfficeBuilding(Floor[] officeFloors){
        this();
        Node current = head;
        this.countFloor = officeFloors.length;
        for (int i = 1; i < officeFloors.length; i++) {
            Node newNode = new Node();
            newNode.floor = officeFloors[i];
            newNode.next = head;
            newNode.prev = head;
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            countFloor++;
        }
    }
    public int getCountFloor(){
        return countFloor;
    }

    @Override
    public int getAllSpace() {
        int allOffice = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allOffice += current.floor.getCountSpaceOnFloor(); //ВЫЯСНИТЬ, ДО ИЛИ ПОСЛЕ ДЕЛАТЬ CURRENT.NEXT
            current  = current.next;
        }
        return allOffice;
    }

    @Override
    public double getAllArea() {
        double allArea = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allArea += current.floor.getSumFloorArea(); //ВЫЯСНИТЬ, ДО ИЛИ ПОСЛЕ ДЕЛАТЬ CURRENT.NEXT
            current = current.next;
        }
        return allArea;
    }

    /*public int getAllOffice(){
        int allOffice = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allOffice += current.floor.getCountSpaceOnFloor(); //ВЫЯСНИТЬ, ДО ИЛИ ПОСЛЕ ДЕЛАТЬ CURRENT.NEXT
            current  = current.next;
        }
        return allOffice;
    }
    public double getAllArea(){
        double allArea = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allArea += current.floor.getSumFloorArea(); //ВЫЯСНИТЬ, ДО ИЛИ ПОСЛЕ ДЕЛАТЬ CURRENT.NEXT
            current = current.next;
        }
        return allArea;
    }
    */
    @Override
    public int getAllRoom() {
        int allRooms = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allRooms += current.floor.getSumFloorRoom();
            current = current.next;
        }
        return allRooms;
    }

    @Override
    public Floor[] getArrayFloor() {
        Floor[]officeFloor = new OfficeFloor[countFloor];
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            officeFloor[i] = current.floor;
            current = current.next;
        }
        return officeFloor;
    }

    @Override
    public Floor getFloorByNum( int numFloor) {
        Node current = head;
        for (int i = 1; i < numFloor; i++) {
            current = current.next;
        }
        return current.floor;
    }

    @Override
    public void setFloorByNum(Floor newFloor, int numFloor) {
        Node current = head;
        for (int i = 1; i < numFloor; i++) {
            current = current.next;
        }
        current.floor = newFloor;
    }

    @Override
    public Space getSpaceByNum( int numSpace) {
        Node current = head;
        Space currOffice = null;
        for (int i = 0; i < countFloor; i++) {
            Floor currentFloor = current.floor;
            for (int j = 0; j < currentFloor.getCountSpaceOnFloor(); j++){
                currOffice = currentFloor.getSpaceByNum(numSpace);
            }
            current = current.next;
        }
        return currOffice;
    }

    @Override
    public void setSpaceByNum(Space newSpace, int numSpace) {
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            Floor officeFloor = current.floor;
            for (int j = 0; j < officeFloor.getCountSpaceOnFloor(); j++){
                //current.floor.setOffice(numOffice,office);
                current.floor.setSpaceFloor(newSpace, numSpace);
            }
            current = current.next;
        }
    }

    @Override
    public void addSpaceByNum(Space newSpace, int numSpace) {
        Node current = head;
        for (int i = 0; i < countFloor; i++){
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++){
               // current.floor.addOffice(numFloor,newOffice);
                current.floor.addSpaceNumber(newSpace, numSpace);
            }
        }
    }

    @Override
    public void removeSpaceByNum(int spaceNum) {
        if(spaceNum <= 0 & spaceNum > getAllSpace()){
            throw new SpaceIndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < countFloor; i++){
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++){
                current.floor.removeSpaceFloor(spaceNum);
            }
        }
    }

    @Override
    public Space getBestSpace() {
        Node current = head;
        Space bestOffice = null;
        double bestArea = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            if (current.floor.getBestSpace().getArea() >= bestArea)
                bestOffice = current.floor.getBestSpace();
                bestArea = current.floor.getBestSpace().getArea();
        }

        return bestOffice;
    }

    @Override
    public Space[] getSortSpaceArray() {
        Space[] sort = new Office[getAllSpace()];
        Node current = head;
        for(int i = 0; i < countFloor; i++){
            //sort[i] = current.floor.getCountSpaceOnFloor()[i];
            Space[] tempOffice = current.floor.getArraySpaceFloor();
            for(int j = 0; j < tempOffice.length; j++){
                sort[j] = tempOffice[j];
            }
            current = current.next;
        }
        Space currentOffice = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length - 1; j++) {

                if (sort[j].getArea() < sort[j + 1].getArea()) {

                    Sort = false;

                    currentOffice = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = currentOffice;
                }
            }

        }
        return sort;
    }

    /*
    public int getRooms(){
        int allRooms = 0;
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            allRooms += current.floor.getSumCountRoom();
            current = current.next;
        }
        return allRooms;
    }
    public Floor[] getOfficeFloors(){ //получение массива этажей
        Floor[]officeFloor = new OfficeFloor[countFloor];
        Node current = head;
        for(int i = 1; i < countFloor; i++){
            officeFloor[i] = current.floor;
            current = current.next;
        }
        return officeFloor;
    }
    public OfficeFloor getOfficeFloor(int index){ //получение этажа по его номеру
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.floor;
    }
    public void setFloor(int index, OfficeFloor floor){ // изменение этажа
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.floor = floor;
    }
     public Office getOffice( int numOffice){ //получение офиса по номеру
        Node current = head;
        Office currOffice = null;
        for (int i = 0; i < countFloor; i++) {
            OfficeFloor currentFloor = current.floor;
            for (int j = 0; j < currentFloor.getCountSpaceOnFloor(); j++){
               currOffice = currentFloor.getOffice(numOffice);
            }
            current = current.next;
        }
       return currOffice;
    }

    */
    /* public void setOffice(int numOffice, Office office){ //изменение офиса
        Node current = head;
        for (int i = 0; i < countFloor; i++) {
            OfficeFloor officeFloor = current.floor;
            for (int j = 0; j < officeFloor.getCountSpaceOnFloor(); j++){
                current.floor.setOffice(numOffice,office);
            }
            current = current.next;
        }
    }
    public void addOffice(int numFloor, Office newOffice){ // добавление офиса
        Node current = head;
        for (int i = 0; i < countFloor; i++){
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++){
                current.floor.addOffice(numFloor,newOffice);
            }
        }
    }
    public void deleteOffice(int numDelOffice){// удаление офиса
        if(numDelOffice <= 0 & numDelOffice > getAllOffice()){
            throw new SpaceIndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < countFloor; i++){
            current = current.next;
            for (int j = 0; j < current.floor.getCountSpaceOnFloor(); j++){
                current.floor.remove(numDelOffice);
            }
        }
    }
    public Office bestSpace(){
        Node current = head;
        Office bestOffice = null;
        double bestArea = 0;
        for (int i = 0; i < countFloor; i++) {
            current = current.next;
            if (current.floor.getBestSpace().getAreaOffice() >= bestArea)
                bestOffice = current.floor.getBestSpace();
                bestArea = current.floor.getBestSpace().getAreaOffice();
        }

        return bestOffice;

    }
    //TODO: правильно ли
    public Office[] getSortedOffice(){ //
        Office[] sort = new Office[getAllOffice()];
        Node current = head;
        for(int i = 0; i < countFloor; i++){
            //sort[i] = current.floor.getCountSpaceOnFloor()[i];
            Office[] tempOffice = current.floor.getSpaceArray();
            for(int j = 0; j < tempOffice.length; j++){
                sort[j] = tempOffice[j];
            }
            current = current.next;
        }
        Office currentOffice = null;
        boolean Sort = false;
        while (!Sort) {
            Sort = true;
            for (int j = 0; j < sort.length - 1; j++) {

                if (sort[j].getAreaOffice() < sort[j + 1].getAreaOffice()) {

                    Sort = false;

                    currentOffice = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = currentOffice;
                }
            }

        }
        return sort;
    }

     */
}
