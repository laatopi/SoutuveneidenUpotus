
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import laivanupotus.logiikka.Ruudukko;

public class Grafiikka {

    Ruudukko oma;
    Ruudukko tietokone;

    public static void main(String[] args) {
        new Grafiikka(9, 9);
    }

    JFrame frame = new JFrame();
    JButton[][] grid; //names the grid of buttons

    public Grafiikka(int width, int length) {
        frame.setLayout(new GridLayout(0, 9));

        for (int z = 0; z < 2; z++) {

            char k = 'A';
            frame.add(new JLabel(""));
            for (int i = 0; i < 8; i++) {
                frame.add(new JLabel("" + k));
                k++;
            }
            
            int ko = 1;
            for (int i = 0; i < 8; i++) {
                frame.add(new JLabel(""+ko));
                for (int j = 0; j < 8; j++) {
                    frame.add(new JButton("x"));
                }
                ko++;
                
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
