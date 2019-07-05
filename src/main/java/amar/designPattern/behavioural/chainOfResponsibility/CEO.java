package amar.designPattern.behavioural.chainOfResponsibility;

/**
 * Created by amarendra on 05/09/17.
 */
public class CEO extends Handler {

    @Override
    public void handleRequest(final Request request) {
        System.out.println("CEO is processing the request for an amount of " + request.getAmount());
    }
}
