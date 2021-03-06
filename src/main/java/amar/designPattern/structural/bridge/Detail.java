package amar.designPattern.structural.bridge;

public class Detail {

    private String label;
    private String value;


    public Detail(final String label, final String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Detail [label=" + label + ", value=" + value + "]";
    }


}
