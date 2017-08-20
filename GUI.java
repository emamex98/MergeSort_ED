import javax.swing.*;
import java.awt.*;

class GUI extends JFrame{

  public GUI(){
    super("Merge Sort");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(500,600);

    MainPanel guiPanel = new MainPanel();
    this.add(guiPanel);

    this.setVisible(true);
  }

  public static void main(String[] args) {
    GUI newGUI = new GUI();
  }

}
