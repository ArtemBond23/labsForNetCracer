package buildings;

import exception.SpaceIndexOutOfBoundsException;
import inter.Floor;
import inter.Space;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OfficeFloor implements Floor {

    private Node head;
    private int countOffices;

    private static class Node {
        Node next;
        Space office;
    }

    protected OfficeFloor() {
        head = new Node();
        head.office = new Office();
        head.next = head;
    }

    public void add(Node newNode, int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        countOffices++;
    }

    public Node getNode(int index) {
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public void remove(int index) {
        Node tempNode = head;
        for (int k = 0; k < index - 1; k++) {
            tempNode = tempNode.next;
        }
        Node del = tempNode.next;
        tempNode.next = del.next;
        countOffices--;
    }

    public OfficeFloor(int countOffice) {
        this();
        if(countOffice <=0){
            throw new SpaceIndexOutOfBoundsException();
        }
        Node current = head;
        this.countOffices = countOffice;
        for (int i = 0; i < countOffices; i++) {
            Node node = new Node();
            node.office = new Office();
            node.next = head; // до равно -  куда записываем, после равно - что записываем,  берем ;
            current.next = node;
            current = node;
        }
       // while (countOffice != countOffices) {
           // Node node = new Node();
           // node.office = new Office();
           // node.next = head; // до равно -  куда записываем, после равно - что записываем,  берем ;
           // current.next = node;
           // current = node;
           // countOffices++;
       // }

    }

    public OfficeFloor(Space[] offices) {
        head = new Node();
        head.office = offices[0];
        head.next = head;
        Node current = head;
        for (int i = 1; i < offices.length; i++) {
            Node officeNode = new Node();
            officeNode.office = offices[i];
            officeNode.next = head;
            current.next = officeNode;
            current = officeNode;
        }
        countOffices = offices.length;
    }

    public int getCountSpaceOnFloor() {    //получение количествао офисов на этаже
        return countOffices;
    }

    public double getSumFloorArea() { //получение общей площади этажа
        double floorArea = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            floorArea += current.office.getArea();
        }
        return floorArea;
    }

    @Override
    public Space[] getArraySpaceFloor() { // получение массива всех помещений этажа
        Space [] offices = new Office[countOffices];
        Node current = head;
        for (int i = 0; i < offices.length; i++) {
            offices[i] = current.office;
            current = current.next;
        }
        return  offices;
    }

    @Override
    public int getSumFloorRoom() { //получение количества комнат на этаже
        int countRoom = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            countRoom += current.office.getRoom();
        }
        return countRoom;
    }

    @Override
    public Space getSpaceByNum(int spaceNum) { //получения помещения по номеру
        return getNode(spaceNum).office;
    }

    @Override
    public void setSpaceFloor(Space newSpace, int spaceNum) { //изменение помещения на этаже
        getNode(spaceNum).office = newSpace;
    }

    @Override
    public void addSpaceNumber(Space addSpace, int spaceNum) { //добавление помещения по номеру
        Node newNode = new Node();
        newNode.office = addSpace;
        add(newNode,spaceNum);
    }

    @Override
    public void removeSpaceFloor(int spaceNum) { //удаление помещения по номеру
        remove(spaceNum);
    }

    public int getSumCountRoom() {
        int countRoom = 0;
        Node current = head;
        for (int i = 0; i < countOffices; i++) {
            current = current.next;
            countRoom += current.office.getRoom();
        }
        return countRoom;
    }

    public Space []getSpaceArray() {  //получения массива офисов
        Space [] offices = new Office[countOffices];
        Node current = head;
        for (int i = 0; i < offices.length; i++) {
            offices[i] = current.office;
            current = current.next;
        }
        return  offices;
    }
    public Space getOffice(int index){
        return getNode(index).office;
    }
    public void setOffice(int index, Office newOffice){ //изменение офиса по номеру и сслыке
        getNode(index).office = newOffice;
    }
    public void addOffice( int index, Office newOffice){
        Node newNode = new Node();
        newNode.office = newOffice;
        add(newNode,index);
    }
    public void deleteOffice(int index){
        remove(index);
    }

    public Space getBestSpace(){
        double bestArea = 0;
        Space bestOffice = null;
        Node current = head;
        for(int i = 0; i < countOffices; i++ ){
            current = current.next;
            if(current.office.getArea() > bestArea){
                bestArea = current.office.getArea();
                bestOffice = current.office;
            }
        }
        //set.add;
        return bestOffice;
    }
   // Set set = new HashSet();


}


