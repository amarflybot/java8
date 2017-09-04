package amar.designPattern.strategy;

/**
 * Created by amarendra on 03/09/17.
 */
public class EnumStrategyTest {
    public static void main(String[] args) {

        Player ctx = new Player(Strategy.T20);
        ctx.play();

        ctx.setStrategy(Strategy.ONE_DAY);
        ctx.play();

        ctx.setStrategy(Strategy.TEST);
        ctx.play();

        ctx.setStrategy(Strategy.DEFAULT);
        ctx.play();
    }
}

class Player {

    private Strategy strategy;

    public Player(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void play(){
        strategy.play();
    }
}

enum Strategy {

    ONE_DAY {
        @Override
        public void play() {
            System.out.println("Playing ONE DAY!!");
        }
    }, TEST {
        @Override
        public void play() {
            System.out.println("Playing TEST!!");
        }
    }, T20 {
        @Override
        public void play() {
            System.out.println("Playing T20!!");
        }
    }, DEFAULT;

    public void play(){
        System.out.println("Default Play");
        throw new RuntimeException("Doing Nothing Idiot!!");
    }
}
