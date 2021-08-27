import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Party {
    public void bouildInvite() {
        Frame f = new Frame();
        Label l = new Label("Party at Main");
        Button b = new Button("yeees");
        Button c = new Button("Hell No!");
        Panel p = new Panel();
        p.add(l);
    }

    public static void main(String[] args) {
        // bouildInvite();
        System.out.print("System Here!");
        try {
            Path fileName = Path.of("demo.txt");
            // String content = "hello world !!";
            // Files.writeString(fileName, content);

            String actual = Files.readString(fileName);
            System.out.println(actual);
            // readTheFile("myFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("File not found.");
        }
    }

}