package amar.designPattern.behavioural.stategy;

/**
 * Created by amarendra on 05/09/17.
 */
public class AmexStrategy extends ValidationStrategy {

    @Override
    public boolean isValid(final CreditCard creditCard) {

        boolean passesLuhn = passesLuhn(creditCard.getNumber());


        return passesLuhn;
    }
}
