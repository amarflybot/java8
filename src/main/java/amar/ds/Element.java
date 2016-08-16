package amar.ds;

public class Element{

    private Integer integer;

    public Element(int i) {
        integer = i;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        return integer != null ? integer.equals(element.integer) : element.integer == null;

    }

    @Override
    public int hashCode() {
        return integer != null ? integer.hashCode() : 0;
    }
}
