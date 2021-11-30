package exception;

public class BuildingUnderArrestException extends  Throwable {
    public BuildingUnderArrestException(){
        super("building is under arrest");
    }
}
