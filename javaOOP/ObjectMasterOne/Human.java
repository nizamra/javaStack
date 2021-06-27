public class Human{
    protected int strength;
    protected int intelligence;
    protected int stealth;
    protected int health;

    public void attack(Human attacked){
        attacked.setHealth(attacked.getHealth()-this.strength);
        System.out.println(this.getClass().getName() + attacked.health);
        // System.out.println(attacked.health);
    }

    public Human(){
        this.strength=3;
        this.intelligence=3;
        this.stealth=3;
        this.health=100;
    }

    public Human(int foo,int bar, int x, int y){
        this.strength=foo;
        this.intelligence=bar;
        this.stealth=x;
        this.health=y;
    }

    // public String getName(){
    //      return this.name;
    // }
    public Integer getIntelligence(){
         return this.intelligence;
    }
    public Integer getStrength(){
         return this.strength;
    }
    public void setStrength(int x){
        this.strength=x;
    }
    public Integer getHealth(){
         return this.health;
    }
    public void setHealth(int x){
        this.health=x;
    }


}