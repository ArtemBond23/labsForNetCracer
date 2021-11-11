package exception;

public class InvalidSpaceAreaException extends IllegalArgumentException{
    public InvalidSpaceAreaException(){
        super (" Неверная площадь аппартаментов");
    }
}
