package amar.rx.helper;

import rx.Observable;
import rx.subjects.BehaviorSubject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by amarendra on 18/10/16.
 */
public class TimedEventSequence<T> {

    private final BehaviorSubject<T> eventSubject;
    private final Iterator<T> list;
    private final long interval;
    private T currentItem;
    private Thread eventThread;
    private long lastTick;

    public TimedEventSequence(final List<T> list, final long interval) {
        eventThread = null;
        lastTick = System.currentTimeMillis();

        this.list = list.iterator();
        this.interval = interval;

        currentItem = this.list.hasNext() ? this.list.next() : null;
        eventSubject = BehaviorSubject.create(currentItem);
    }

    public Observable<T> toObservable() {
        return eventSubject;
    }

    public synchronized void start() {
        if (eventThread != null) {
            return;
        }

        eventThread = new Thread(() -> {
            try {
                while (eventThread.isInterrupted() == false) {
                    try {
                        Thread.sleep(5);
                    } catch (final InterruptedException e) {
                        break;
                    }

                    final long currentTime = System.currentTimeMillis();
                    if (currentTime - lastTick > interval) {
                        lastTick = currentTime;
                        if (list.hasNext()) {
                            eventSubject.onNext(list.next());
                        }
                    }
                }
            } catch (final Throwable e) {
                eventSubject.onError(e);
            }

            eventSubject.onCompleted();
        }, "TimedEventSequenceThread");
        eventThread.start();
    }

    public synchronized void stop() {
        if (eventThread == null) {
            return;
        }

        eventThread.interrupt();
        try {
            eventThread.join();
        } catch (final InterruptedException e) {

        }
    }
}
