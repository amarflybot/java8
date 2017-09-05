package amar.designPattern.creational.singleton;

/**
 * Created by amarendra on 04/09/17.
 */
public enum  SingletonEnum {

    INSTANCE;

    private Integer integer;

    private SingletonEnum() {
        System.out.println("In SingletonEnum private Constructor");
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(final Integer integer) {
        this.integer = integer;
    }

    protected Object readResolve() {
        return INSTANCE;

    }
}
