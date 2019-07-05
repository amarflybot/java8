package amar.designPattern.structural.bridge;

public class BridgeClient {

    public static void main(final String[] args) {

        final Movie movie = new Movie();
        movie.setClassification("Comedy");
        movie.setRuntime("2.2hrs");
        movie.setTitle("Hera Pheri");
        movie.setYear("1999");

        final Formatter formatter = new PrintFormatter();

        final Printer printer = new MoviePrinter(movie);

        final String print = printer.print(formatter);
        System.out.println("Print -> " + print);

    }

}
