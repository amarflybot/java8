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

        ext.add();

        sup.add(f);

        sup.add(new Fruit());

        GenericsTest genericsTest = new GenericsTest();
        genericsTest.m1(new ArrayList<Mango>());
        genericsTest.m2(new ArrayList<Eatable>());

    }

    private void m1(List <? extends Fruit> list){

        for(Fruit f : list){

        }

    }

    private void m2(List <? super Fruit> obj){
        for(Fruit f : obj){

        }
    }
}

class Eatable{}

class Fruit extends Eatable{}

class Mango<T extends Fruit>{}

class Grapes extends Fruit{}
