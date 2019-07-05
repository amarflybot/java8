package amar.designPattern.behavioural.chainOfResponsibility;

/**
 * Created by amarendra on 05/09/17.
 */
public class Director extends Handler {

    @Override
    public void handleRequest(final Request request) {
        if (request.getRequestType().equals(RequestType.CONFERENCE)) {
            System.out.println("Director is processing the request for an amount of " + request.getAmount());
        } else {
            handler.handleRequest(request);
        }
    }
}
