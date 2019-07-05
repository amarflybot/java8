package amar.ds;

public class Element {

    private Integer integer;

    public Element(final int i) {
        integer = i;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(final Integer integer) {
        this.integer = integer;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Element element = (Element) o;

        return integer != null ? integer.equals(element.integer) : element.integer == null;

    }

    @Override
    public int hashCode() {
        return integer != null ? integer.hashCode() : 0;
    }
}
