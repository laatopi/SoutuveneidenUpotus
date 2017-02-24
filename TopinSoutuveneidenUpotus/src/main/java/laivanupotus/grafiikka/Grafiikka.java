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
import laivanupotus.logiikka.PelinTilaMuuttujat;

/**
 *
 * kaikki grafiikkaan liittyvät toiminnallisuudet ovat tässä luokassa, sekä
 * pelin tilanteeseen liittyvät muuttujat jota grafiikka tarvitsee tietää jotta
 * voi toimia halutulla tavallla.
 *
 */
public class Grafiikka {

    private final Ruudukko omaRuudukko;
    private final Ruudukko tietokoneenRuudukko;
    private PelinTilaMuuttujat m;
    private JLabel teksti;

    /**
     * Asettaa pelin ikkunan vieressä olevan tekstin.
     *
     * @param teksti teksti mikä asetetaan.
     */
    public void setTeksti(String teksti) {
        this.teksti.setText(teksti);
    }

    /**
     *
     * Luo grafiikka olion ja siihen liittyvät ominaisuudet.
     *
     * @param oma pelaajan ruudukko.
     * @param tietokone tietokoneen ruudukko.
     * @param muuttujat on pelin tila muuttujat, jotta mouseclickkerit tietävät
     * milloin tehdä mitäkin tapahtumia.
     *
     */
    public Grafiikka(Ruudukko oma, Ruudukko tietokone, PelinTilaMuuttujat muuttujat) {
        this.omaRuudukko = oma;
        this.tietokoneenRuudukko = tietokone;
        this.teksti = new JLabel("");
        this.m = muuttujat;
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
                frame.add(new RuudukkoPaneeli(teksti));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Ruudukkopaneeli sisältää ruutu oliot ja luo ne oikealle kohilleen.
     *
     */
    public class RuudukkoPaneeli extends JPanel {

        /**
         * Konstruktori luo paneelin ja jokaiseen kohtaan koordinaatin
         * perusteella oikeatyyppisen laatan.
         *
         * @param teksti on jlabel olio joka päivttää pelin tilaa.
         */
        public RuudukkoPaneeli(JLabel teksti) {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            char koordinaatinKirjain = 'A';

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 19; x++) {
                    gbc.gridx = x;
                    gbc.gridy = y;

                    if (x != 0 && x != 18 && y != 0 && y != 9 && x != 9) {
                        Paneeli cellPane = null;
                        if (x < 9) {
                            cellPane = new Paneeli(x - 1, y - 1, omaRuudukko.getRuudukko()[x - 1][y - 1], omaRuudukko);
                        } else {
                            cellPane = new Paneeli(x - 10, y - 1, tietokoneenRuudukko.getRuudukko()[x - 10][y - 1], tietokoneenRuudukko);
                        }
                        Border border = new MatteBorder(1, 1, 1, 1, Color.darkGray);
                        cellPane.setBorder(border);
                        add(cellPane, gbc);

                    } else {
                        JLabel jlabel = null;

                        if (x > 0 && y == 0 && x < 18 && x != 9) {
                            jlabel = new JLabel("" + koordinaatinKirjain);
                            koordinaatinKirjain++;
                            if (koordinaatinKirjain == 'I') {
                                koordinaatinKirjain = 'A';
                            }

                        } else if ((x == 0 || x == 9) && (y > 0 && y < 9)) {
                            jlabel = new JLabel("" + y);
                        }

                        JPanel jpanel = new JPanel();
                        if (jlabel != null) {
                            jlabel.setHorizontalAlignment(SwingConstants.CENTER);
                            jlabel.setVerticalAlignment(SwingConstants.CENTER);
                            jpanel.add(jlabel);
                        }
                        jpanel.setPreferredSize(new Dimension(50, 50));
                        add(jpanel, gbc);
                    }
                }
            }
            add(teksti);
        }
    }

    /**
     * Paneeli on yksittäinen ruudukko paneelin sisällä oleva paneeli. Ne
     * sisältävät peliin liittyvää toiminnallisuutta, kuten koordinaatit, ja
     * ruutu olioon liittyvän toiminnallisuuden.
     *
     */
    public class Paneeli extends JPanel {

        private Color defaultBackground;
        private int x;
        private int y;
        private Ruutu ruutu;
        private Ruudukko ruudukko;

        /**
         * Pavittaa ruudukon värin, eli musta jos ruudussa laiva ja se uponnut.
         * punainen jos ruudussa laiva jota on ammuttu. harmaa jos oma ruudukko
         * jossa on laiva. keltainen jos ruutua ammuttu mutta siellä ei ole
         * laivaa. sininen jos ruudulle ei ole tehty mitään, tai jos siellä on
         * tietokoneen laiva jota e iole ammuttu.
         */
        public void paivita() {
            if (this.ruudukko.getRuudukko()[y][x].onkoRuudussaLaiva()
                    && this.ruudukko.getRuudukko()[y][x].onkoAmmuttu()
                    && this.ruudukko.getRuudukko()[y][x].palautaLaskuri().arvo() <= 0) { //jos laskuri arvo 0 niin koko laiva on uponnut
                setBackground(Color.BLACK);
            } else if (this.ruudukko.getRuudukko()[y][x].onkoRuudussaLaiva() && this.ruudukko.getRuudukko()[y][x].onkoAmmuttu()) {
                setBackground(Color.red);
            } else if (this.ruudukko.getRuudukko()[y][x].onkoRuudussaLaiva() && this.ruudukko.onkoOma() == true) {
                setBackground(Color.GRAY);
            } else if (this.ruudukko.getRuudukko()[y][x].onkoAmmuttu()) {
                setBackground(Color.YELLOW);
            } else {
                setBackground(Color.BLUE);
            }
        }

        /**
         * Konstruktori luo paneelin.
         *
         * @param x x koordinaatti
         * @param y y koordinaatti
         * @param ruutu siihen liittyvä ruutu
         * @param ruudukko ruudukko missä edellämainittu ruutu sijaitsee.
         */
        public Paneeli(int x, int y, Ruutu ruutu, Ruudukko ruudukko) {
            this.x = x;
            this.y = y;
            this.ruutu = ruutu;
            this.ruutu.asetaPaneeli(this);
            this.ruudukko = ruudukko;
            paivita();
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(Color.DARK_GRAY);
                    defaultBackground = getBackground();
                    if (m.isLaivanAsetusKaynnissa() == true && ruudukko.onkoOma() == true) {
                        if (m.isAsetusSuunta() == true) {
                            for (int i = 0; i < m.getLaivanKoko(); i++) {
                                if (y + i < 8) {
                                    varjaaRuudukotVaaka(i);
                                }
                            }
                        } else {
                            for (int j = 0; j < m.getLaivanKoko(); j++) {
                                if (x + j < 8) {
                                    varjaaRuudukotPysty(j);
                                }
                            }
                        }
                    }
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

                    if (e.getButton() == MouseEvent.BUTTON3) {
                        if (m.isLaivanAsetusKaynnissa() == true) {
                            if (m.isAsetusSuunta()) {
                                m.setAsetusSuunta(false);
                            } else {
                                m.setAsetusSuunta(true);
                            }
                        }
                    }
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (m.isLaivanAsetusKaynnissa() == true && ruudukko.onkoOma() == true) {
                            omaRuudukko.luoLaiva(x, y, m.isAsetusSuunta(), m.getLaivanKoko());
                            paivita();
                        }
                        if (m.isTaisteluVaiheKaynnissa() == true && ruudukko.onkoOma() == false && ruudukko.getRuudukko()[y][x].onkoAmmuttu() == false) {
                            tietokoneenRuudukko.ammuLaivaa(y, x);
                            omaRuudukko.tietokoneAmmuLaivaa();
                        }

                        setBackground(Color.orange);
                    }
                }

                private void varjaaRuudukotVaaka(int i) {
                    if (omaRuudukko.getRuudukko()[y + i][x].onkoRuudussaLaiva() == false) {
                        omaRuudukko.getRuudukko()[x][y + i].palautaPaneeli().setBackground(Color.DARK_GRAY);
                    } else {
                        omaRuudukko.getRuudukko()[x][y + i].palautaPaneeli().setBackground(Color.orange);
                    }
                }

                private void varjaaRuudukotPysty(int j) {
                    if (omaRuudukko.getRuudukko()[y][x + j].onkoRuudussaLaiva() == false) {
                        omaRuudukko.getRuudukko()[x + j][y].palautaPaneeli().setBackground(Color.DARK_GRAY);
                    } else {
                        omaRuudukko.getRuudukko()[x + j][y].palautaPaneeli().setBackground(Color.orange);
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}
