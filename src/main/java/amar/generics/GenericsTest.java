package amar.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumarao on 27-01-2016.
 */
public class GenericsTest {

    public static void main(String[] args) {

        List<? extends Fruit> producer = null;
        List<? super Fruit> consumer = new ArrayList<>();


        consumer.add(new Fruit());
        consumer.add(new Mango());
        consumer.add(new Grapes());

        producer = (List<? extends Fruit>) consumer;

        producer.forEach(System.out::println);

        consumer.add(new Mango());

        GenericsTest genericsTest = new GenericsTest();
        //genericsTest.m1(new ArrayList<Mango>());
        consumer.add(new Fruit());
        consumer.add(new Mango());
        consumer.add(new Grapes());
        Fruit mango = new Mango();
        mango.method1(mango);

    }


    private void m1(List <? extends Fruit> list){

        for(Fruit f : list){

        }

    }

    private void m3(List<Fruit> object){
        for(Fruit fruit : object){
            System.out.println(fruit);
        }
    }
}

class Eatable{
    @Override
    public String toString() {
        return "Eatable{}";
    }
}

class Fruit extends Eatable{
    @Override
    public String toString() {
        return "Fruit{}";
    }

    public void method1(Fruit mango){

    }
}

class Mango extends Fruit{
    @Override
    public String toString() {
        return "Mango{}";
    }
}

class Grapes extends Fruit{
    @Override
    public String toString() {
        return "Grapes{}";
    }
}
