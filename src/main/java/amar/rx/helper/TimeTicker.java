package amar.rx.helper;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimeTicker {

    private final BehaviorSubject<Long> tickerSubject;
    private final long interval;

    private volatile boolean paused;
    private long lastTick;
    private Thread tickerThread;

    public TimeTicker(long interval) {
        this.lastTick = System.currentTimeMillis();
        this.tickerSubject = BehaviorSubject.create(lastTick);
        this.tickerThread = null;
        this.paused = false;
        this.interval = interval;
    }

    public Observable<Long> toObservable(){
        return tickerSubject;
    }

    public synchronized  void start(){

        if (tickerThread != null){
            return; // the ticker thread is already running;
        }

        //make sure the pause flag is false
        unPause();

        tickerThread = new Thread(()->{
            try {
                while (Thread.interrupted() == false){

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        break;
                    }
                    if(paused){
                        continue;
                    }

                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastTick > interval)
                    lastTick = currentTime;
                    tickerSubject.onNext(lastTick);
                }
            } catch (Throwable e) {
                tickerSubject.onError(e);
            }

            tickerSubject.onCompleted();
        }, "TickerThread");
        tickerThread.start();
    }

    public synchronized void stop(){
        if (tickerThread == null){
            return;
        }
        tickerThread.interrupt();

        try {
            tickerThread.join();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    private void unPause() {
        this.paused = false;
    }

    public void pause() {
        this.paused = true;
    }
}
