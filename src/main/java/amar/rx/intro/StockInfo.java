package amar.rx.intro;

import rx.Observable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by amarendra on 30/09/16.
 */
public class StockInfo {

    private String ticket;
    private double value;

    public StockInfo(String ticket, double value) {
        this.ticket = ticket;
        this.value = value;
    }

    public static StockInfo fetch(String ticket) {
        StockInfo stockInfo = new StockInfo(ticket, getPriceOrig(ticket));
        if (Math.random() > .8) {
            throw new RuntimeException();
        }
        return stockInfo;
    }

    public static double getPriceOrig(final String ticker) {
        try {
            final URL url =
                    new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().skip(1).limit(1).findFirst().get();
            final String[] dataItems = data.split(",");
            double price = Double.parseDouble(dataItems[dataItems.length - 1]);
            //System.out.println("put(\"" + ticker + "\", " + price + ");");
            return price;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Observable<? extends StockInfo> getDefaultPrice() {
        return Observable.empty();
    }

    public String getTicket() {
        return ticket;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "ticket='" + ticket + '\'' +
                ", value=" + value +
                '}';
    }
}
