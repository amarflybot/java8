package amar.designPattern.behavioural.chainOfResponsibility;

/**
 * Created by amarendra on 05/09/17.
 */
public class VP extends Handler {

    @Override
    public void handleRequest(final Request request) {
        if (request.getRequestType().equals(RequestType.PURCHASE) && (request.getAmount() < 1500)) {
            System.out.println("VP is processing the request for an amount of " + request.getAmount());
        } else {
            handler.handleRequest(request);
        }
    }

}
