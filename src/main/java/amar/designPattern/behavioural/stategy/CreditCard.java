package amar.designPattern.behavioural.stategy;

/**
 * Created by amarendra on 05/09/17.
 */
public class CreditCard {

    private String number;
    private String date;
    private String cvv;
    private ValidationStrategy strategy;

    public CreditCard(final ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isValid(){
        return strategy.isValid(this);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(final String cvv) {
        this.cvv = cvv;
    }
}
