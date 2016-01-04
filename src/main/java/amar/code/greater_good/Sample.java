package amar.code.greater_good;

import java.util.*;
import java.util.stream.Stream;

public class Sample {  
  public static void findStockImperative(List<String> symbols) {
    List<StockInfo> stockPrices = new ArrayList<>();
    
    for(String ticker : symbols) {
      stockPrices.add(StockUtil.getPrice(ticker));
    }

    List<StockInfo> stocksLessThan500 = new ArrayList<>();
    for(StockInfo stockInfo : stockPrices) {
      if(StockUtil.isPriceLessThan(500).test(stockInfo))
        stocksLessThan500.add(stockInfo);
    }
    
    StockInfo highPriced = new StockInfo("", 0.0);
    for(StockInfo stockInfo : stocksLessThan500) {
      highPriced = StockUtil.pickHigh(highPriced, stockInfo);
    }
    
    System.out.println(highPriced);
  }
  
  public static void findStockFunctional(Stream<String> symbols) {
    System.out.println(
      symbols.map(StockUtil::getPrice)
             .filter(StockUtil.isPriceLessThan(500))
             .reduce(new StockInfo("", 0.0), StockUtil::pickHigh));
  }
  
  public static void main(String[] args) {
    Timeit.code(() -> findStockImperative(Tickers.symbols));
    
    Timeit.code(() -> findStockFunctional(Tickers.symbols.stream()));
    
    Timeit.code(() -> findStockFunctional(Tickers.symbols.parallelStream()));
  }
}