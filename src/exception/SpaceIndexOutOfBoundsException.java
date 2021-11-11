package exception;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public SpaceIndexOutOfBoundsException(){
        super("Выход за границы номеров помещений");
    }
}
