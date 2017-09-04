package amar.designPattern.strategy.bridge;

public class BridgeClient {

	public static void main(String[] args) {

		Movie movie = new Movie();
		movie.setClassification("Comedy");
		movie.setRuntime("2.2hrs");
		movie.setTitle("Hera Pheri");
		movie.setYear("1999");

		Formatter formatter = new PrintFormatter();

		Printer printer = new MoviePrinter(movie);

		String print = printer.print(formatter);
		System.out.println("Print -> "+ print);

	}

}
