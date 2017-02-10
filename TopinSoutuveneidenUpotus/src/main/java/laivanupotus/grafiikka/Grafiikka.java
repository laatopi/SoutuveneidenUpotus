/**
 * @author laatopi
 * sisältää kaikki grafiikan luomiseen swingilla tarvittavat luokat, ja muuttaa.
 * grafiikkaa ruudukkojen tilanteiden mukaan.
 * sisältää myös muuttujat josta grafiikka tietää missä kohtaa peliä mennään.
 */
package laivanupotus.grafiikka;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import laivanupotus.logiikka.Ruudukko;
import laivanupotus.logiikka.Ruutu;

public class Grafiikka {

    boolean laivatAsetettu;
    public Ruudukko omaRuudukko;
    public Ruudukko tietokoneenRuudukko;
    public JLabel teksti;
    public Boolean laivanAsetusKaynnissa;
    public boolean taisteluVaiheKaynnissa;
    public int laivanKoko;

    public static void main(String[] args) {
    }

    public Grafiikka(Ruudukko oma, Ruudukko tietokone) {
        this.omaRuudukko = oma;
        this.tietokoneenRuudukko = tietokone;
        this.teksti = new JLabel("Moikka!");
        this.laivanAsetusKaynnissa = false;
        this.taisteluVaiheKaynnissa = false;
        this.laivanKoko = 0;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Laivanupotus");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane(teksti));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public Grafiikka grafiikka;

        public TestPane(JLabel teksti) {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            char ko = 'A';

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 19; x++) {
                    gbc.gridx = x;
                    gbc.gridy = y;
                    if (x != 0 && x != 18 && y != 0 && y != 9 && x != 9) {

                        if (x < 9) {
                            CellPaneOma cellPane = new CellPaneOma(x - 1, y - 1, omaRuudukko.ruudukko[x - 1][y - 1], omaRuudukko);
                            Border border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
                            cellPane.setBorder(border);
                            cellPane.add(new JLabel("" + (x - 1) + ", " + (y - 1)));
                            add(cellPane, gbc);
                        } else {
                            CellPaneOma cellPane = new CellPaneOma(x - 10, y - 1, tietokoneenRuudukko.ruudukko[x - 10][y - 1], tietokoneenRuudukko);
                            Border border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
                            cellPane.setBorder(border);
                            cellPane.add(new JLabel("" + (x - 10) + ", " + (y - 1)));
                            add(cellPane, gbc);
                        }
                    } else if (x > 0 && y == 0 && x < 18 && x != 9) {
                        JLabel jlabel = new JLabel("" + ko);
                        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
                        jlabel.setVerticalAlignment(SwingConstants.CENTER);
                        JPanel jpanel = new JPanel();
                        jpanel.add(jlabel);
                        jpanel.setPreferredSize(new Dimension(50, 50));
                        add(jpanel, gbc);
                        ko++;
                        if (ko == 'I') {
                            ko = 'A';
                        }
                    } else if ((x == 0 || x == 9) && (y > 0 && y < 9)) {
                        JLabel jlabel = new JLabel("" + y);
                        JPanel jpanel = new JPanel();
                        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
                        jlabel.setVerticalAlignment(SwingConstants.CENTER);

                        jpanel.add(jlabel);
                        jpanel.setPreferredSize(new Dimension(50, 50));
                        add(jpanel, gbc);
                    } else {
                        JLabel jlabel = new JLabel("");
                        JPanel jpanel = new JPanel();
                        jpanel.add(jlabel);
                        jpanel.setPreferredSize(new Dimension(50, 50));
                        add(jpanel, gbc);
                    }
                }

            }
            add(teksti);
        }
    }
    public class CellPaneOma extends JPanel {

        private Color defaultBackground;
        public int x;
        public int y;
        private Ruutu ruutu;
        private Ruudukko ruudukko;

        public void paivita() {
            if (this.ruudukko.ruudukko[y][x].onkoRuudussaLaiva()
                    && this.ruudukko.ruudukko[y][x].onkoAmmuttu()
                    && this.ruudukko.ruudukko[y][x].palautaLaskuri().arvo() <= 0) { //jos laskuri arvo 0 niin koko laiva on uponnut
                setBackground(Color.BLACK);
            } else if (this.ruudukko.ruudukko[y][x].onkoRuudussaLaiva() && this.ruudukko.ruudukko[y][x].onkoAmmuttu()) {
                setBackground(Color.ORANGE);
            } else if (this.ruudukko.ruudukko[y][x].onkoRuudussaLaiva() && this.ruudukko.oma == true) {
                setBackground(Color.GRAY);
            } else if (this.ruudukko.ruudukko[y][x].onkoAmmuttu()) {
                setBackground(Color.YELLOW);
            } else {
                setBackground(Color.BLUE);
            }
        }
        public CellPaneOma(int x, int y, Ruutu ruutu, Ruudukko ruudukko) {
            this.x = x;
            this.y = y;
            this.ruutu = ruutu;
            this.ruutu.asetaPaneeli(this);
            this.ruudukko = ruudukko;
            paivita();
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                    paivita();
                    omaRuudukko.paivitaGrafiikka();
                    tietokoneenRuudukko.paivitaGrafiikka();
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (laivanAsetusKaynnissa == true) {
                        omaRuudukko.luoLaiva(x, y, false, laivanKoko);
                        paivita();
                    }
                    if (taisteluVaiheKaynnissa == true && ruudukko.oma == false) {
                        tietokoneenRuudukko.ammuLaivaa(x, y);
                        omaRuudukko.tietokoneAmmuLaivaa();
                    }

                    setBackground(Color.RED);
                }
            });
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}
