/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import laivanupotus.kayttoliittyma.Kayttoliittyma;
import laivanupotus.logiikka.Ruudukko;

public class GrafiikkaTest {

    boolean Laivatasetettu;
    public Ruudukko omaRuudukko;
    public Ruudukko TietokoneenRuudukko;
    Kayttoliittyma k;

    public static void main(String[] args) {
    }

    public GrafiikkaTest(Kayttoliittyma k) {
        this.k = k;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            char ko = 'A';

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 19; x++) {
                    gbc.gridx = x;
                    gbc.gridy = y;
                    if (x != 0 && x != 18 && y != 0 && y != 9 && x != 9) {

                        if (x < 9) {
                            CellPaneOma cellPane = new CellPaneOma(x - 1, y - 1);
                            Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);

                            cellPane.setBorder(border);
                            cellPane.add(new JLabel("" + (x - 1) + ", " + (y - 1)));
                            add(cellPane, gbc);
                        } else {
                            CellPaneOma cellPane = new CellPaneOma(x - 10, y - 1);
                            cellPane.setBackground(Color.blue);
                            Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);

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

        }
    }

    public class CellPaneOma extends JPanel {

        private Color defaultBackground;

        public int x;
        public int y;

        public CellPaneOma(int x, int y) {
            this.x = x;
            this.y = y;
            setBackground(Color.cyan);
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.RED);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }

                @Override
                public void mouseClicked(MouseEvent e) {

                    setBackground(Color.YELLOW);
                    if (k.asetusKaynnissa == true) {
                        k.leveysAsetaLaiva = x;
                        k.pituusAsetaLaiva = y;
                    }

                }

                public void paivita() {

                }

                private void sendX(int x) {

                }

                private void sendY(int y) {
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }

}
