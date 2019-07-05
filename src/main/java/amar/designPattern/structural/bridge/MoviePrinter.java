package amar.designPattern.structural.bridge;

import java.util.ArrayList;
import java.util.List;

public class MoviePrinter extends Printer {

    private Movie movie;

    public MoviePrinter(Movie movie) {
        this.movie = movie;
    }

    @Override
    protected String getHeader() {
        return "{" + movie.getClassification() + "," + movie.getYear() + "}";
    }

    @Override
    protected List<Detail> getdetails() {
        List<Detail> list = new ArrayList<>();
        list.add(new Detail("Classification", movie.getClassification()));
        list.add(new Detail("Runtime", movie.getRuntime()));
        list.add(new Detail("Title", movie.getTitle()));
        list.add(new Detail("Year", movie.getYear()));
        return list;
    }


}
