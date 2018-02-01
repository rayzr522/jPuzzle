package me.rayzr522.jpuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Map m;
    private Player p;
    private Timer timer;
    public Board() {

        m = new Map();
        p = new Player();

        addKeyListener(new KL());
        setFocusable(true);

        timer = new Timer(25, this);
        timer.start();

    }

    // long startTime = System.nanoTime();
    // long elapsedTime;
    // long tempTime = 0;

    public Boolean standingOn(String num) {

        return m.getMap(p.getX(), p.getY()).equals(num);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        repaint();
        // elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        //
        // if (elapsedTime > 30) {
        //
        // p.setX(0);
        // p.setY(0);
        // m.openFile("map.txt");
        // m.readFile();
        // m.closeFile();
        //
        // startTime = System.nanoTime();
        //
        // elapsedTime = (System.nanoTime() - startTime) / 1000000000;
        //
        // }
        //
        // if (tempTime != elapsedTime) {
        //
        // System.out.println(elapsedTime);
        //
        // }
        //
        // tempTime = elapsedTime;

    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int y = 0; y < 16; y++) {

            for (int x = 0; x < 16; x++) {

                if (m.getMap(x, y).equals("0")) {
                    g.drawImage(m.getGrass(), x * 32, y * 32, null);
                }

                if (m.getMap(x, y).equals("1")) {
                    g.drawImage(m.getStone(), x * 32, y * 32, null);
                }

                if (m.getMap(x, y).equals("2")) {
                    g.drawImage(m.getStairHori(), x * 32, y * 32, null);
                }

                if (m.getMap(x, y).equals("3")) {
                    g.drawImage(m.getStairVert(), x * 32, y * 32, null);
                }

                if (m.getMap(x, y).equals("4")) {
                    g.drawImage(m.getMoveable(), x * 32, y * 32, null);
                }

            }

        }

        g.drawImage(p.getImage(), p.getX() * 32, p.getY() * 32, null);

    }

    public class KL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP && p.getY() > 0) {
                if (!(m.getMap(p.getX(), p.getY() - 1).equals("4"))) {
                    if (!(m.getMap(p.getX(), p.getY() - 1).equals("1") || m
                            .getMap(p.getX(), p.getY() - 1).equals("2"))
                            || standingOn("1")
                            || standingOn("3")
                            || standingOn("4")) {
                        p.move(0, -1);
                    }
                } else if (!(p.getY() - 2 < 0)
                        && m.getMap(p.getX(), p.getY() - 2).equals("0")
                        && !(standingOn("1") || standingOn("3") || standingOn("4"))) {

                    m.setMap(p.getX(), p.getY() - 1, "0");
                    m.setMap(p.getX(), p.getY() - 2, "4");

                } else if (!(standingOn("0"))) {
                    p.move(0, -1);
                }

            }

            if (key == KeyEvent.VK_DOWN && p.getY() < 15) {
                if (!(m.getMap(p.getX(), p.getY() + 1).equals("4"))) {
                    if (!(m.getMap(p.getX(), p.getY() + 1).equals("1") || m
                            .getMap(p.getX(), p.getY() + 1).equals("2"))
                            || standingOn("1")
                            || standingOn("3")
                            || standingOn("4")) {
                        p.move(0, 1);
                    }
                } else if (!(p.getY() + 2 > 15)
                        && m.getMap(p.getX(), p.getY() + 2).equals("0")
                        && !(standingOn("1") || standingOn("3") || standingOn("4"))) {

                    m.setMap(p.getX(), p.getY() + 1, "0");
                    m.setMap(p.getX(), p.getY() + 2, "4");

                } else if (!(standingOn("0"))) {
                    p.move(0, 1);
                }

            }

            if (key == KeyEvent.VK_LEFT && p.getX() > 0) {
                if (!(m.getMap(p.getX() - 1, p.getY()).equals("4"))) {
                    if (!(m.getMap(p.getX() - 1, p.getY()).equals("1") || m
                            .getMap(p.getX() - 1, p.getY()).equals("3"))
                            || standingOn("1")
                            || standingOn("2")
                            || standingOn("4")) {
                        p.move(-1, 0);
                    }
                } else if (!(p.getX() - 2 < 0)
                        && m.getMap(p.getX() - 2, p.getY()).equals("0")
                        && !(standingOn("1") || standingOn("2") || standingOn("4"))) {

                    m.setMap(p.getX() - 1, p.getY(), "0");
                    m.setMap(p.getX() - 2, p.getY(), "4");

                } else if (!(standingOn("0"))) {
                    p.move(-1, 0);
                }

            }

            if (key == KeyEvent.VK_RIGHT && p.getX() < 15) {
                if (!(m.getMap(p.getX() + 1, p.getY()).equals("4"))) {
                    if (!(m.getMap(p.getX() + 1, p.getY()).equals("1") || m
                            .getMap(p.getX() + 1, p.getY()).equals("3"))
                            || standingOn("1")
                            || standingOn("2")
                            || standingOn("4")) {
                        p.move(1, 0);
                    }
                } else if (!(p.getX() + 2 > 15)
                        && m.getMap(p.getX() + 2, p.getY()).equals("0")
                        && !(standingOn("1") || standingOn("2") || standingOn("4"))) {

                    m.setMap(p.getX() + 1, p.getY(), "0");
                    m.setMap(p.getX() + 2, p.getY(), "4");

                } else if (!(standingOn("0"))) {
                    p.move(1, 0);
                }

            }

            if (key == KeyEvent.VK_ESCAPE) {

                System.exit(0);

            }

            if (key == KeyEvent.VK_R) {
                p.reset();
                m.reset();
            }

            // System.out.println("PX: " + p.getX() + ", PY: " + p.getY());

        }
    }

}
