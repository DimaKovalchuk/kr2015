import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Sapper {


    int a,b,a1,a2,m;
    JPanel pane = new JPanel();
    JTextField tf_mine, tf_time;
    JButton reset = new JButton("");




    Sapper() {
        super("Сапёр");

        Menu();



        reset.addActionListener(new ActionListener() {


            public void Panel(int level, int setr, int setc, int setm) {
                if (level == 1) {
                    a = 200;
                    b = 300;
                    a1 = 10;
                    a2 = 10;
                    m = 10;
                } else if (level == 2) {
                    a = 300;
                    b = 500;
                    a1 = 10;
                    a2 = 10;
                    m = 10;
                } else if (level == 3) {
                    a = 400;
                    b = 600;
                    a1 = 10;
                    a2 = 10;
                    m = 10;
                } else if (level == 4) {
                    a = (20 * setc);
                    a = (24 * setr);
                    a1 = setr;
                    a2 = setc;
                    m = setm;
                }


            }

            panel.setLayout(newBorderLayout()







            public void Menu() {
                JMenuBar bar = new JMenuBar();

                JMenu game = new JMenu("Игра");

                JMenuItem menuitem = new JMenuItem("Новая игра");
                final JCheckBoxMenuItem beginner = new JCheckBoxMenuItem("Лёгкий");
                final JCheckBoxMenuItem intermediate = new JCheckBoxMenuItem("Средний");
                final JCheckBoxMenuItem expart = new JCheckBoxMenuItem("Сложный");
                final JCheckBoxMenuItem custom = new JCheckBoxMenuItem("Выбор");
                final JMenuItem exit = new JMenuItem("Выход");


                ButtonGroup status = new ButtonGroup();

                menuitem.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                            }
                        });

                beginner.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                            }
                        });
                intermediate.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                            }
                        });
                expart.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                            }
                        });

                custom.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                            }
                        });

                exit.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                    }
                });


                status.add(beginner);
                status.add(intermediate);
                status.add(expart);
                status.add(custom);

                game.add(menuitem);
                game.addSeparator();
                game.add(beginner);
                game.add(intermediate);
                game.add(expart);
                game.add(custom);
                game.addSeparator();
                game.add(exit);

                bar.add(game);

            }

        }

}
