public class Wizard extends Human{

    public Wizard(){
        this.intelligence=8;
        this.health=50;
    }

    public Wizard(int foo,int bar, int x, int y){
        this.strength=foo;
        this.intelligence=bar;
        this.stealth=x;
        this.health=y;
    }

    // a method called heal that heals whomever it was cast onfor an amount equal to the wizard's intelligence;
    public void heal(Human healed){
        healed.setHealth(healed.getHealth()+this.intelligence);
        System.out.println(healed.getHealth());
    }

    // method called fireball that decreases the health of whichever object itattacked by 3 * the wizard's intelligence
    public void fireball(Human healed){
        healed.setHealth(healed.getHealth()- (3*this.intelligence));
        System.out.println(healed.getHealth());
    }
}