package amar.designPattern.creational.immutable;

class Roll {
    private Integer integer;

    public Roll(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "integer=" + integer +
                '}';
    }
}
