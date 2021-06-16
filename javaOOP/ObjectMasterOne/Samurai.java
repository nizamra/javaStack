public class Samurai extends Human{
    private static byte currentNumber = 0;

    // The Samurai class should have a default health of 200
    public Samurai(){
        this.health=200;
        currentNumber++;
    }

    public Samurai(int foo,int bar, int x, int y){
        this.strength=foo;
        this.intelligence=bar;
        this.stealth=x;
        this.health=y;
        currentNumber++;
    }
    
    // method called deathBlow that attacks an object and decreases its health to 0, but also halves the Samurai's health
    public void deathBlow(Human dead){
        dead.setHealth(0);
        System.out.println(dead.getHealth());
        this.setHealth(this.getHealth()/2);
        System.out.println(this.getHealth());
    }

    // method called meditate which heals the Samurai back to full health
    public void meditate(){
        this.setHealth(200);
        System.out.println(this.getHealth());
    }

    // methodcalled howMany that returns the current number of Samurai.
    public static byte howMany(){
        return currentNumber;
    }
}