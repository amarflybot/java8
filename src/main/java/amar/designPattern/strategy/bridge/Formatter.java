package amar.designPattern.strategy.bridge;

import java.util.List;

public interface Formatter {

	String format(String header, List<Detail> details);

}
