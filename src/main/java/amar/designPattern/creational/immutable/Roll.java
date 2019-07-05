package amar.designPattern.creational.immutable;

class Roll {
    private Integer integer;

    public Roll(final Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(final Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "integer=" + integer +
                '}';
    }
}
