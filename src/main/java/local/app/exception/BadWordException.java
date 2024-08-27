package local.app.exception;

public class BadWordException extends Exception{
    public BadWordException(){
        super("The post contains bad words");
    }
}
