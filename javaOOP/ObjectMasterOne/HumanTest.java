public class HumanTest{
    public static void main(String[] args){
        Human Layth = new Human();
        Human Baraa = new Human();

        // Human Sami = new Samurai();
        // Human Salah = new Samurai();
        // Human Sahl = new Samurai();
        // Human Naji = new Ninja();
        // Human Wadee = new Wizard();

        Samurai Sami = new Samurai();
        Samurai Salah = new Samurai();
        Samurai Sahl = new Samurai();
        Ninja Naji = new Ninja();
        Wizard Wadee = new Wizard();

        System.out.println("Layth's Strength is: "+Layth.getStrength());
        Baraa.attack(Layth);
        System.out.println("Layth's Health is: "+Layth.getHealth());

        Sami.deathBlow(Sahl);
        Sami.deathBlow(Baraa);
        Sahl.meditate();
        System.out.println("howMany Samurais: "+Samurai.howMany());

        Naji.runAway();
        Naji.runAway();
        Naji.runAway();
        Naji.steal(Salah);

        Wadee.heal(Baraa);
        Wadee.fireball(Layth);
    }
}