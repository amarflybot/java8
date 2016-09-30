package amar.rx.intro;

import rx.Observable;

import java.util.List;

/**
 * Created by amarendra on 30/09/16.
 */
public class StockServer {

    public static Observable<StockInfo> getFeed(List<String> symbols) {
        return Observable.create(subscriber -> {
            try {
                while (true) {
                    symbols.stream()
                            .map(StockInfo::fetch)
                            .forEach(subscriber::onNext);

                    sleep(1000);
                }
            }
            catch (Exception ex){
                subscriber.onError(ex);
            }
        });
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
