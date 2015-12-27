import com.sun.org.apache.xml.internal.dtm.DTM;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;


import static javax.swing.GroupLayout.*;


public class GUI extends JFrame {

    private JLabel SearchLabel;

    private JTextField SearchField;

    private JButton SearchButton;

    private JMenuItem EditItem;
    private JMenuItem FileItem;
    private JMenuItem AddItem;
    private JMenuItem DatabaseItem;
    private JMenuItem ExitItem;
    private JMenuItem DeleteItem;

    private JComboBox SearchComboBox;

    private JMenu EditMenu;
    private JMenu FileMenu;

    private JMenuBar jMenuBar;

    private JScrollPane jScrollPane;

    private JPanel panel;
    private JTable table;

    public GUI() {
        initComponents();
    }

    ArrayList<Fleats> databasefleats;



    private void initComponents() {

        jScrollPane = new JScrollPane();
        table = new JTable();
        panel = new JPanel();
        SearchComboBox = new JComboBox();
        SearchField = new JTextField();
        SearchButton = new JButton();
        SearchLabel = new JLabel();

        jMenuBar = new JMenuBar();

        FileMenu = new JMenu();
        DatabaseItem= new JMenuItem();
        ExitItem = new JMenuItem();

        EditMenu = new JMenu();
        AddItem = new JMenuItem();
        EditItem = new JMenuItem();
        DeleteItem = new JMenuItem();

        ArrayList<Fleats> databasefleats = new ArrayList<Fleats>();

        setTitle("Расселение квартир");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            databasefleats=DatabaseFleats.read("doc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        DefaultTableModel model = new DefaultTableModel();

        table = new JTable(model);
//        System.out.println(databasefleats.size());

        model.addColumn("Район");
        model.addColumn("Адресс");
        model.addColumn("ФИО проживающего");
        model.addColumn("ФИО проживающего");
        model.addColumn("ФИО проживающего");
        model.addColumn("ФИО проживающего");
        model.addColumn("ФИО проживающего");


        for (int c=0; c<databasefleats.size(); c++){
            model.addRow(new Object[]{databasefleats.get(c).getDistrict(),databasefleats.get(c).getAdres(),databasefleats.get(c).getName1(),databasefleats.get(c).getName2(),databasefleats.get(c).getName3(),databasefleats.get(c).getName4(),databasefleats.get(c).getName5()});
        }


        add(new JScrollPane(table));
        table.getSelectionModel().addListSelectionListener(table);
        table.getColumnModel().addColumnModelListener(table);

        SearchPanel();
        jScrollPane.setViewportView(table);


        FileMenu.setText("Файл");

        DatabaseItem.setText("База данных");

        final ArrayList<Fleats> finalDatabasefleats4 = databasefleats;
        DatabaseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DefaultTableModel model = new DefaultTableModel();
                for (int c=0; c< finalDatabasefleats4.size(); c++){
                    model.addRow(new Object[]{finalDatabasefleats4.get(c).getDistrict(), finalDatabasefleats4.get(c).getAdres(), finalDatabasefleats4.get(c).getName1(), finalDatabasefleats4.get(c).getName2(), finalDatabasefleats4.get(c).getName3(), finalDatabasefleats4.get(c).getName4(), finalDatabasefleats4.get(c).getName5()});
                }
            }
        });

        FileMenu.add(DatabaseItem);

        ExitItem.setText("Выход");
        final ArrayList<Fleats> finalDatabasefleats3 = databasefleats;
        ExitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DatabaseFleats.write("doc.txt",finalDatabasefleats3);
                ExitItemActionPerformed(evt);
            }
        });

        FileMenu.add(ExitItem);

        jMenuBar.add(FileMenu);
        EditMenu.add(AddItem);

        EditMenu.setText("Редактировать");

        AddItem.setText("Добавить");

        final ArrayList<Fleats> finalDatabasefleats = databasefleats;
        final ArrayList<Fleats> finalDatabasefleats1 = databasefleats;
        AddItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame AddFrame =  new JFrame();
                AddFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AddFrame.setSize(300,250);
                AddFrame.setLayout(new BorderLayout());
                JPanel FillPanel = new JPanel(new GridLayout(7,2));
                JLabel DistrictTextLabel = new JLabel("Район");
                JLabel AdressTextLabel = new JLabel("Адресс");
                JLabel Name1TextLabel = new JLabel("ФИО проживающего");
                JLabel Name2TextLabel = new JLabel("ФИО проживающего");
                JLabel Name3TextLabel = new JLabel("ФИО проживающего");
                JLabel Name4TextLabel = new JLabel("ФИО проживающего");
                JLabel Name5TextLabel = new JLabel("ФИО проживающего");

                final JTextField AdressField = new JTextField(20);
                final JTextField Name1Field = new JTextField(20);
                final JTextField Name2Field = new JTextField(20);
                final JTextField Name3Field = new JTextField(20);
                final JTextField Name4Field = new JTextField(20);
                final JTextField Name5Field = new JTextField(20);
                final JComboBox DistrictBox = new JComboBox();
                DistrictBox.setEditable(true);

                DistrictBox.addItem("Ленинский");
                DistrictBox.addItem("Дзержинский");
                DistrictBox.addItem("Фрунзенский");
                DistrictBox.addItem("Московский");
                DistrictBox.addItem("Пролетарский");
                DistrictBox.addItem("Киевский");

                FillPanel.add(DistrictTextLabel);
                FillPanel.add(DistrictBox);

                FillPanel.add(AdressTextLabel);
                FillPanel.add(AdressField);

                FillPanel.add(Name1TextLabel);
                FillPanel.add(Name1Field);

                FillPanel.add(Name2TextLabel);
                FillPanel.add(Name2Field);

                FillPanel.add(Name3TextLabel);
                FillPanel.add(Name3Field);

                FillPanel.add(Name4TextLabel);
                FillPanel.add(Name4Field);

                FillPanel.add(Name5TextLabel);
                FillPanel.add(Name5Field);

                JPanel AddPanel = new JPanel();

                JButton AddButton = new JButton("Добавить");

                AddButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {

                        //ArrayList<Fleats> databasefleats1 = new ArrayList<Fleats>();

                        /**try {
                            databasefleats = Test.read("doc.txt");
                        } catch (FileNotFoundException e3) {
                            e3.printStackTrace();
                        }*/

                        Fleats fleats;
                        fleats = new Fleats((String) DistrictBox.getSelectedItem(),
                                AdressField.getText(), Name1Field.getText(),
                                Name2Field.getText(), Name3Field.getText(),
                                Name4Field.getText(), Name5Field.getText());
                        finalDatabasefleats.add(fleats);

                        DefaultTableModel DTM =new DefaultTableModel();
                        DTM=(DefaultTableModel)table.getModel();
                        DTM.setRowCount( DTM.getRowCount());
                        DTM.insertRow(DTM.getRowCount(), new Object[]{(String) DistrictBox.getSelectedItem(),
                                AdressField.getText(), Name1Field.getText(),
                                Name2Field.getText(), Name3Field.getText(), Name4Field.getText(),
                                Name5Field.getText()});
                        DatabaseFleats.write("doc.txt", finalDatabasefleats1);

                    }
                });



                AddPanel.add(AddButton);
                AddPanel.add(AddButton);
                AddFrame.add(FillPanel, BorderLayout.CENTER);
                AddFrame.add(AddPanel, BorderLayout.SOUTH);
                AddFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                AddFrame.setVisible(true);

            }
        });


        EditItem.setText("Редактировать");
        final ArrayList<Fleats> finalDatabasefleats5 = databasefleats;
        EditItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame EditFrame =  new JFrame();
                EditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EditFrame.setSize(300,300);
                EditFrame.setLayout(new BorderLayout());
                JPanel FillPanel = new JPanel(new GridLayout(7,2));
                JLabel DistrictTextLabel = new JLabel("Район");
                JLabel AdressTextLabel = new JLabel("Адресс");
                JLabel Name1TextLabel = new JLabel("ФИО проживающего");
                JLabel Name2TextLabel = new JLabel("ФИО проживающего");
                JLabel Name3TextLabel = new JLabel("ФИО проживающего");
                JLabel Name4TextLabel = new JLabel("ФИО проживающего");
                JLabel Name5TextLabel = new JLabel("ФИО проживающего");

                final JTextField AdressField = new JTextField(20);
                final JTextField Name1Field = new JTextField(20);
                final JTextField Name2Field = new JTextField(20);
                final JTextField Name3Field = new JTextField(20);
                final JTextField Name4Field = new JTextField(20);
                final JTextField Name5Field = new JTextField(20);
                final JComboBox DistrictBox = new JComboBox();
                DistrictBox.setEditable(true);

                DistrictBox.addItem("Ленинский");
                DistrictBox.addItem("Дзержинский");
                DistrictBox.addItem("Фрунзенский");
                DistrictBox.addItem("Московский");
                DistrictBox.addItem("Пролетарский");
                DistrictBox.addItem("Киевский");

                FillPanel.add(DistrictTextLabel);
                FillPanel.add(DistrictBox);

                FillPanel.add(AdressTextLabel);
                FillPanel.add(AdressField);

                FillPanel.add(Name1TextLabel);
                FillPanel.add(Name1Field);

                FillPanel.add(Name2TextLabel);
                FillPanel.add(Name2Field);

                FillPanel.add(Name3TextLabel);
                FillPanel.add(Name3Field);

                FillPanel.add(Name4TextLabel);
                FillPanel.add(Name4Field);

                FillPanel.add(Name5TextLabel);
                FillPanel.add(Name5Field);

                JPanel EditPanel = new JPanel();
                JButton AddButton = new JButton("Сохранить");
                AddButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int selRow = table.getSelectedRow();
                        if(selRow != -1) {
                            DefaultTableModel model = (DefaultTableModel)table.getModel();
                            model.removeRow(selRow);

                            Fleats fleats;
                            fleats = new Fleats((String) DistrictBox.getSelectedItem(),
                                    AdressField.getText(), Name1Field.getText(),
                                    Name2Field.getText(), Name3Field.getText(),
                                    Name4Field.getText(), Name5Field.getText());
                            finalDatabasefleats.add(fleats);

                            DefaultTableModel DTM =new DefaultTableModel();
                            DTM=(DefaultTableModel)table.getModel();
                            DTM.setRowCount( DTM.getRowCount());
                            DTM.insertRow(DTM.getRowCount(), new Object[]{(String) DistrictBox.getSelectedItem(),
                                    AdressField.getText(), Name1Field.getText(),
                                    Name2Field.getText(), Name3Field.getText(),
                                    Name4Field.getText(), Name5Field.getText()});
                            //Test.write("doc.txt", finalDatabasefleats1);

                            finalDatabasefleats5.set(selRow,fleats);
                            DatabaseFleats.write("doc.txt", finalDatabasefleats5);
                        }
                    }

                });



                EditPanel.add(AddButton);
                EditPanel.add(AddButton);
                EditFrame.add(FillPanel, BorderLayout.CENTER);
                EditFrame.add(EditPanel, BorderLayout.SOUTH);
                EditFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                EditFrame.setVisible(true);

            }
        });

        EditMenu.add(EditItem);



        DeleteItem.setText("Удалить");
        final ArrayList<Fleats> finalDatabasefleats2 = databasefleats;
        DeleteItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

               // ArrayList<Fleats> databasefleats3 = new ArrayList<Fleats>();

               /** try {
                    databasefleats3 = Test.read("doc.txt");
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }*/

                    int selRow = table.getSelectedRow();
                    if(selRow != -1) {
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(selRow);
                        finalDatabasefleats2.remove(selRow);
                        DatabaseFleats.write("doc.txt", finalDatabasefleats2);
                    }
                }

        });
        EditMenu.add(DeleteItem);

        jMenuBar.add(EditMenu);

        setJMenuBar(jMenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane, PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }



    public void SearchPanel(){

        SearchLabel.setText("Параметры поиска");

        SearchComboBox = new JComboBox<String>();
        SearchComboBox.addItem("По ФИО");
        SearchComboBox.addItem("По адресу");

        SearchField =  new JTextField();
        SearchButton = new JButton();
        SearchButton.setText("Найти");

        final ArrayList<Fleats> finalDatabasefleats = databasefleats;

        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch((String)SearchComboBox.getSelectedItem()){
                    case "По ФИО":{

                        //ArrayList<Fleats> databasefleats1 = new ArrayList<Fleats>();

                      /**  try {
                            databasefleats=Test.read("doc.txt");
                        } catch (FileNotFoundException e3) {
                            e3.printStackTrace();
                        }*/

                        for (int i = 0; i < table.getRowCount(); i++) {
                           // System.out.println(table.getValueAt(i, 1).toString());
                           // System.out.println(SearchTextField.getText().toString());
                            if ((table.getValueAt(i,2).toString()).equals( SearchField.getText().toString())||
                                    (table.getValueAt(i,3).toString()).equals( SearchField.getText().toString())||
                                    (table.getValueAt(i,4).toString()).equals( SearchField.getText().toString())||
                                    (table.getValueAt(i,5).toString()).equals( SearchField.getText().toString())||
                                    (table.getValueAt(i,6).toString()).equals( SearchField.getText().toString())) {
                                try {
                                    DefaultTableModel DTM = new DefaultTableModel();
                                    DTM = (DefaultTableModel) table.getModel();
                                    DTM.moveRow(0, i - 1, 1);
                                } catch
                                        (Exception e2) {
                                }
                                Fleats  fleat = databasefleats.get(0);
                                databasefleats.set(0, databasefleats.get(i));
                                databasefleats.set(0, fleat);
                                DatabaseFleats.write("doc.txt", databasefleats );

                            }
                        }
                        // nameSearch();
                        break;

                    }
                    case "По адресу":{

                       // ArrayList<Fleats> databasefleats = new ArrayList<Fleats>();

                       /** try {
                            databasefleats=Test.read("doc.txt");
                        } catch (FileNotFoundException e3) {
                            e3.printStackTrace();
                        }*/

                        for (int i = 0; i < table.getRowCount(); i++) {
                            //System.out.println(table.getValueAt(i, 1).toString());
                           // System.out.println(SearchTextField.getText().toString());
                            if ((table.getValueAt(i,1).toString()).equals( SearchField.getText().toString())) {
                                try {
                                    DefaultTableModel DTM = new DefaultTableModel();
                                    DTM = (DefaultTableModel) table.getModel();
                                    DTM.moveRow(0, i - 1, 1);
                                } catch
                                        (Exception e2) {
                                }
                                Fleats  fleat = databasefleats.get(0);
                                databasefleats.set(0, databasefleats.get(i));
                                databasefleats.set(0, fleat);
                                DatabaseFleats.write("doc.txt", databasefleats );

                            }}
                                // nameSearch();
                                break;
                        //Test.write("doc.txt", databasefleats );
                    }
                }
                SearchField.setText("");
            }
        });


        panel.removeAll();
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);

        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(Alignment.LEADING)
                        .addGap(30, 30, 30)
                        .addComponent(SearchField, Alignment.TRAILING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGap(30, 30, 30)
                                .addComponent(SearchLabel)
                                .addContainerGap()
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addComponent(SearchComboBox, Alignment.TRAILING, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchField, Alignment.TRAILING)
                        .addComponent(SearchButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup().addContainerGap()
                                        .addContainerGap()
                                        .addGap(15, 15, 15)
                                        .addComponent(SearchLabel)
                                        .addGap(15, 15, 15)
                                        .addContainerGap()
                                        .addComponent(SearchComboBox, PREFERRED_SIZE, 20, PREFERRED_SIZE)
                                        .addContainerGap()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SearchLabel)
                                        .addContainerGap()
                                        .addComponent(SearchField, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGap(30, 30, 30)
                                        .addComponent(SearchButton)
                        )
        );
    }


    public void adresSearch() {
        ArrayList<Fleats> databasefleats = new ArrayList<Fleats>();

        try {
            databasefleats=DatabaseFleats.read("doc.txt");
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            System.out.println(table.getValueAt(i, 1).toString());
            System.out.println(SearchField.getText().toString());
            if ((table.getValueAt(i,1).toString()).equals( SearchField.getText().toString())) {
                try {
                    DefaultTableModel DTM = new DefaultTableModel();
                    DTM = (DefaultTableModel) table.getModel();
                    DTM.moveRow(0, i - 1, 1);
                } catch
                        (Exception e2) {
                }
                Fleats  fleat = databasefleats.get(0);
                databasefleats.set(0, databasefleats.get(i));
                databasefleats.set(0, fleat);
                DatabaseFleats.write("doc.txt", databasefleats );

            }
        }
    }
    public void nameSearch() {

        ArrayList<Fleats> databasefleats = new ArrayList<Fleats>();

        try {
            databasefleats = DatabaseFleats.read("doc.txt");
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            System.out.println(table.getValueAt(i, 1).toString());
            System.out.println(SearchField.getText().toString());
            if ((table.getValueAt(i, 2).toString()).equals(SearchField.getText().toString()) ||
                    (table.getValueAt(i, 3).toString()).equals(SearchField.getText().toString()) ||
                    (table.getValueAt(i, 4).toString()).equals(SearchField.getText().toString()) ||
                    (table.getValueAt(i, 5).toString()).equals(SearchField.getText().toString()) ||
                    (table.getValueAt(i, 6).toString()).equals(SearchField.getText().toString())) {
                try {
                    DefaultTableModel DTM = new DefaultTableModel();
                    DTM = (DefaultTableModel) table.getModel();
                    DTM.moveRow(0, i - 1, 1);
                } catch
                        (Exception e2) {
                }
                Fleats fleat = databasefleats.get(0);
                databasefleats.set(0, databasefleats.get(i));
                databasefleats.set(0, fleat);
                DatabaseFleats.write("doc.txt", databasefleats);

            }
        }
    }


    private void ExitItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });

    }
}

