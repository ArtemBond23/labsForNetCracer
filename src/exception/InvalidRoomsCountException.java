package exception;

public class InvalidRoomsCountException extends IllegalArgumentException{
    public InvalidRoomsCountException(){
        super("некорретного количества комнат");
    }
}
