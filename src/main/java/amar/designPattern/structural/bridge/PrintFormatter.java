package amar.designPattern.structural.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(header)
			.append(details.toString());
		return stringBuilder.toString();
	}


}
