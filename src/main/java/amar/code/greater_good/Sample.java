package amar.code.greater_good;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sample {
    public static void findStockImperative(final List<String> symbols) {
        final List<StockInfo> stockPrices = new ArrayList<>();

        for (final String ticker : symbols) {
            stockPrices.add(StockUtil.getPrice(ticker));
        }

        final List<StockInfo> stocksLessThan500 = new ArrayList<>();
        for (final StockInfo stockInfo : stockPrices) {
            if (StockUtil.isPriceLessThan(500).test(stockInfo))
                stocksLessThan500.add(stockInfo);
        }

        StockInfo highPriced = new StockInfo("", 0.0);
        for (final StockInfo stockInfo : stocksLessThan500) {
            highPriced = StockUtil.pickHigh(highPriced, stockInfo);
        }

        System.out.println(highPriced);
    }

    public static void findStockFunctional(final Stream<String> symbols) {
        System.out.println(
                symbols.map(StockUtil::getPrice)
                        .filter(StockUtil.isPriceLessThan(500))
                        .reduce(new StockInfo("", 0.0), StockUtil::pickHigh));
    }

    public static void main(final String[] args) {
        Timeit.code(() -> findStockImperative(Tickers.symbols));

        Timeit.code(() -> findStockFunctional(Tickers.symbols.stream()));

        Timeit.code(() -> findStockFunctional(Tickers.symbols.parallelStream()));
    }
}
