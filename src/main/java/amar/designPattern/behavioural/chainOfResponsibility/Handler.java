package amar.designPattern.behavioural.chainOfResponsibility;

/**
 * Created by amarendra on 05/09/17.
 */
public abstract class Handler {

    protected Handler handler;

    public void setSuccessor(final Handler handler) {
        this.handler = handler;
    }

    public abstract void handleRequest(Request request);
}
