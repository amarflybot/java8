package amar.designPattern.structural.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

    @Override
    public String format(final String header, final List<Detail> details) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(header)
                .append(details.toString());
        return stringBuilder.toString();
    }


}
