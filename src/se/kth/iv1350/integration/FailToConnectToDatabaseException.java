package se.kth.iv1350.integration;

public class FailToConnectToDatabaseException extends Exception {
    public FailToConnectToDatabaseException( String errorMsg){
        super(errorMsg);
    }
    public String getMessage(){
        return "Fail to connect to database";
    }
}
