package exception;

public class FloorIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public FloorIndexOutOfBoundsException(){
        super(" Выход за границы номеров");
    }
}
