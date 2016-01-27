package amar.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumarao on 27-01-2016.
 */
public class GenericsTest {

    public static void main(String[] args) {

        List<? extends Fruit> ext = new ArrayList<>();
        List<? super Fruit> sup = new ArrayList<>();

        //ext.add();

        //sup.add(f);

        sup.add(new Fruit());

        GenericsTest genericsTest = new GenericsTest();
        //genericsTest.m1(new ArrayList<Mango>());
        genericsTest.m2(new ArrayList<Eatable>());
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit());
        fruitList.add(new Mango());
        fruitList.add(new Grapes());
        genericsTest.m3(fruitList);

    }

    private void m1(List <? extends Fruit> list){

        for(Fruit f : list){

        }

    }

    private void m2(List <? super Fruit> objs){
        for(Object obj : objs){

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
