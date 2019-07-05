package amar.designPattern.structural.bridge;

import java.util.List;

public abstract class Printer {

    public String print(Formatter formatter) {
        return formatter.format(getHeader(), getdetails());
    }

    protected abstract String getHeader();

    protected abstract List<Detail> getdetails();

}
