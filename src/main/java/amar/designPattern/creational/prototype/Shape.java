package amar.designPattern.creational.prototype;

/**
 * Created by kumarao on 06-08-2016.
 */
public abstract class Shape implements Cloneable {

    protected String type;
    private String id;
    private Record record = new Record();

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Shape clone() {
        Shape clone = null;

        try {
            clone = (Shape) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public Record getRecord() {
        return record;
    }
}
