package amar.designPattern.behavioural.chainOfResponsibility;

/**
 * Created by amarendra on 05/09/17.
 */
public class Request {

    private RequestType requestType;
    private double amount;

    public Request(final RequestType requestType, final double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public double getAmount() {
        return amount;
    }
}
