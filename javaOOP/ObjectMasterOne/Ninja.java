public class Ninja extends Human{

    // The Ninja class should have a default stealth of 10
    public Ninja(){
        this.stealth=10;
    }

    public Ninja(int foo,int bar, int x, int y){
        this.strength=foo;
        this.intelligence=bar;
        this.stealth=x;
        this.health=y;
    }
    // method steal that takes health from another human by their stealth level
    public void steal(Human stealedFrom){
        stealedFrom.setHealth(stealedFrom.getHealth()-this.stealth);
        this.setHealth(this.getHealth()+this.stealth);
        System.out.println(stealedFrom.getHealth());
        System.out.println(this.getHealth());
    }
    // and a way to run away that decreases their health by 10.
    public void runAway(){
        this.setHealth(this.getHealth()-10);
        System.out.println(this.getHealth());
    }
}