import java.awt.*;
import java.awt.event.*;

class Party{
    public void bouildInvite(){
        Frame f = new Frame();
        Label l = new Label("Party at Main");
        Button b = new Button("yeees");
        Button c = new Button("Hell No!");
        Panel p = new Panel();
        p.add(l);
    }

    public static void main(String[] args){
        // bouildInvite();
        try {
            readTheFile("myFile.txt");
            }
        catch(FileNotFoundException ex) {
            System.out.print("File not found.");
            }
    }

}