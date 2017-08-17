package amar.rx.using;

import rx.Observable;
import rx.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 05/05/17.
 */
public class ObservableList<T> {

    protected final List<T> list;
    protected final PublishSubject<T> onAdd;

    public ObservableList(){
        this.list = new ArrayList<T>();
        this.onAdd = PublishSubject.create();
    }
    public void add(T value) {
        list.add(value);
        onAdd.onNext(value);
    }
    public Observable<T> getObservable() {
        return onAdd;
    }
}
