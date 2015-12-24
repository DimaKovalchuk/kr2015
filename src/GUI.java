import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Dimension;

import static javax.swing.GroupLayout.*;


public class GUI extends JFrame {

    DatabaseFleats DatabaseFleats= new DatabaseFleats();

    private byte tablestatus;

    private JLabel LoadAmountLabel;
    private JLabel SearchLabel;
    private JLabel NameLabel;

    private JTextField LoadAmountTextField;
    private JTextField StorageSearchTextField;
    private JTextField SearchTextField;

    private JButton LoadButton;
    private JButton StorageSearchButton;
    private JButton SearchButton;
    private JButton SellButton;

    private JMenuItem AddItem;
    private JMenuItem DatabaseItem;
    private JMenuItem ExitItem;

    private JTextField AmountTextField;
   // private JMenuItem CatalogueItem;
    private JMenuItem DeleteItem;
   // private JMenu OpenMenu;
    //private JMenu DatabaseMenu;
    private JMenuItem EditItem;
    private JMenuItem CompaniesItem;
    private JMenuItem FormsItem;


    private JComboBox SearchComboBox;



    private JMenu EditMenu;
    private JMenu FileMenu;
   //private JMenuItem StorageItem;
    private JMenuBar jMenuBar;

    private JScrollPane jScrollPane;

    private JPanel panel;
    private JTable table;

    public GUI() {
        initComponents();
    }
    private void initComponents() {
        //dbm = new DBManager();

        StorageSearchTextField = new JTextField();
        StorageSearchButton = new JButton();
        LoadAmountLabel = new JLabel();
        LoadAmountTextField = new JTextField();
        LoadButton = new JButton();
        NameLabel = new JLabel();
        jScrollPane = new JScrollPane();
        table = new JTable();
        panel = new JPanel();
        SearchComboBox = new JComboBox();
        SearchTextField = new JTextField();
        SearchButton = new JButton();
        SearchLabel = new JLabel();
        AmountTextField = new JTextField();
        SellButton = new JButton();

        jMenuBar = new JMenuBar();

        FileMenu = new JMenu();
        DatabaseItem= new JMenuItem();
        ExitItem = new JMenuItem();
        FormsItem = new JMenuItem();

        //StorageItem = new JMenuItem();

        EditMenu = new JMenu();
        AddItem = new JMenuItem();
        EditItem = new JMenuItem();
        DeleteItem = new JMenuItem();

        setTitle("Расселение квартир");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //String[] columnNames = {"Район","Улица","Дом","Квартира","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего"};





       // JTable table1 = new JTable(data, columnNames);

       // JScrollPane scrollPane = new JScrollPane(table);


        //String sql="Расселение квартир";


        Object[] columnNames = {"Район","Улица","Дом","Квартира","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего"};

        //Object[][] data = DatabaseFleats.getData();

        Object[][] data = {
                {"Район","Улица","Дом","Квартира","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего"},
                {"Район","Улица","Дом","Квартира","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего","ФИО проживающего"},

        };

        DefaultTableModel DatabaseFleats = new DefaultTableModel();
            for(int i = 0; i<9;i++){
                DatabaseFleats.addColumn(columnNames[i]);
            }
            /**for(int i = 0;i<DatabaseFleats.getRows();i++){
                Object[] row = new Object[DatabaseFleats.getColumns()];
                for(int j = 0;j<DatabaseFleats.getColumns();j++){
                    row[j] = data[i][j];
                }
                DatabaseFleats.addRow(row);
            }/*/

            table.setModel(DatabaseFleats);


        setCataloguePanel();
        jScrollPane.setViewportView(table);


        FileMenu.setText("Файл");

        DatabaseItem.setText("База данных");

        DatabaseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

        FileMenu.add(DatabaseItem);

        ExitItem.setText("Выход");
        ExitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });

        FileMenu.add(ExitItem);


        jMenuBar.add(FileMenu);
        EditMenu.add(AddItem);

        EditMenu.setText("Редактировать");

        AddItem.setText("Добавить");
        AddItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame AddFrame =  new JFrame();
                AddFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AddFrame.setSize(300,300);
                AddFrame.setLayout(new BorderLayout());
                JPanel FillPanel = new JPanel(new GridLayout(9,2));
                JLabel DistrictTextLabel = new JLabel("Район");
                JLabel StreetTextLabel = new JLabel("Улица");
                JLabel HomeTextLabel = new JLabel("Дом");
                JLabel FleatTextLabel = new JLabel("Квартира");
                JLabel Name1TextLabel = new JLabel("ФИО проживающего");
                JLabel Name2TextLabel = new JLabel("ФИО проживающего");
                JLabel Name3TextLabel = new JLabel("ФИО проживающего");
                JLabel Name4TextLabel = new JLabel("ФИО проживающего");
                JLabel Name5TextLabel = new JLabel("ФИО проживающего");


                //JTextField DistrictField = new JTextField(15);
                JTextField StreetField = new JTextField(15);
                JTextField HomeField = new JTextField(15);
                JTextField FleatField = new JTextField(15);
                JTextField Name1Field = new JTextField(15);
                JTextField Name2Field = new JTextField(15);
                JTextField Name3Field = new JTextField(15);
                JTextField Name4Field = new JTextField(15);
                JTextField Name5Field = new JTextField(15);
                JComboBox DistrictBox = new JComboBox();
                DistrictBox.setEditable(true);

                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");



                FillPanel.add(DistrictTextLabel);
                FillPanel.add(DistrictBox);

                FillPanel.add(StreetTextLabel);
                FillPanel.add(StreetField);

                FillPanel.add(HomeTextLabel);
                FillPanel.add(HomeField);

                FillPanel.add(FleatTextLabel);
                FillPanel.add(FleatField);

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


               // FillPanel.add(CountryBox);
                //FillPanel.add(AmountTextLabel);


                JPanel AddPanel = new JPanel();
                JButton AddButton = new JButton("Добавить");
                AddButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){


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







        EditMenu.add(EditItem);

        EditItem.setText("Редактировать");
        EditItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame EditFrame =  new JFrame();
                EditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EditFrame.setSize(300,300);
                EditFrame.setLayout(new BorderLayout());
                JPanel FillPanel = new JPanel(new GridLayout(9,2));
                JLabel DistrictTextLabel = new JLabel("Район");
                JLabel StreetTextLabel = new JLabel("Улица");
                JLabel HomeTextLabel = new JLabel("Дом");
                JLabel FleatTextLabel = new JLabel("Квартира");
                JLabel Name1TextLabel = new JLabel("ФИО проживающего");
                JLabel Name2TextLabel = new JLabel("ФИО проживающего");
                JLabel Name3TextLabel = new JLabel("ФИО проживающего");
                JLabel Name4TextLabel = new JLabel("ФИО проживающего");
                JLabel Name5TextLabel = new JLabel("ФИО проживающего");


                //JTextField DistrictField = new JTextField(15);
                JTextField StreetField = new JTextField(15);
                JTextField HomeField = new JTextField(15);
                JTextField FleatField = new JTextField(15);
                JTextField Name1Field = new JTextField(15);
                JTextField Name2Field = new JTextField(15);
                JTextField Name3Field = new JTextField(15);
                JTextField Name4Field = new JTextField(15);
                JTextField Name5Field = new JTextField(15);
                JComboBox DistrictBox = new JComboBox();
                DistrictBox.setEditable(true);

                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");



                FillPanel.add(DistrictTextLabel);
                FillPanel.add(DistrictBox);

                FillPanel.add(StreetTextLabel);
                FillPanel.add(StreetField);

                FillPanel.add(HomeTextLabel);
                FillPanel.add(HomeField);

                FillPanel.add(FleatTextLabel);
                FillPanel.add(FleatField);

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


                // FillPanel.add(CountryBox);
                //FillPanel.add(AmountTextLabel);


                JPanel EditPanel = new JPanel();
                JButton AddButton = new JButton("Сохранить");
                AddButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){


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





        DeleteItem.setText("Удалить");
        DeleteItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int[] rows = table.getSelectedRows();
                for(int x = 0; x<table.getSelectedRowCount();x++){
                    String query1 = "DELETE FROM Preparations " +
                            "WHERE id_preparation='" + model.getValueAt(rows[x],0) + "' ";
                    String query2 = "DELETE FROM Storage " +
                            "WHERE Storage.id_preparation='" + model.getValueAt(rows[x],0) + "' ON Preparations.preparation_name='" + model.getValueAt(rows[x],1) + "' ";
                    /**try{
                        dbm.execute(query1);
                        dbm.execute(query2);
                    }catch(SQLException ex){

                    }*/
                }

                int j = 0;
                for(int x = 0; x<rows.length;x++){
                    model.removeRow(rows[x]-j);
                    j++;
                }
                table.setModel(model);
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
                                .addComponent(jScrollPane, DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane, PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }

    private void ExitItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public void setStoragePanel(){
        StorageSearchTextField = new JTextField();
        StorageSearchTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                storageSearch();
                StorageSearchTextField.setText("");
            }
        });
        StorageSearchButton = new JButton();
        StorageSearchButton.setText("Search");
        StorageSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                storageSearch();
                StorageSearchTextField.setText("");
            }
        });
        LoadAmountLabel.setText("Amount to load");
        LoadAmountTextField = new JTextField();
        LoadAmountTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                load(Integer.parseInt(LoadAmountTextField.getText()), (String)table.getModel().getValueAt(table.getSelectedRow(), 0));
                LoadAmountTextField.setText("");
            }
        });
        LoadButton.setText("Load");
        LoadButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                load(Integer.parseInt(LoadAmountTextField.getText()), (String)table.getModel().getValueAt(table.getSelectedRow(), 0));
                LoadAmountTextField.setText("");
            }
        });
        //AmountLabel.setText("Amount to sell");

        AmountTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sell(Integer.parseInt(AmountTextField.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
                AmountTextField.setText("");
            }
        });

        NameLabel.setText("Name");

        panel.removeAll();
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);



        EditItem.setText("Редактировать");
        EditItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame EditFrame =  new JFrame();
                EditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EditFrame.setSize(300,300);
                EditFrame.setLayout(new BorderLayout());
                JPanel FillPanel = new JPanel(new GridLayout(9,2));
                JLabel DistrictTextLabel = new JLabel("Район");
                JLabel StreetTextLabel = new JLabel("Улица");
                JLabel HomeTextLabel = new JLabel("Дом");
                JLabel FleatTextLabel = new JLabel("Квартира");
                JLabel Name1TextLabel = new JLabel("ФИО проживающего");
                JLabel Name2TextLabel = new JLabel("ФИО проживающего");
                JLabel Name3TextLabel = new JLabel("ФИО проживающего");
                JLabel Name4TextLabel = new JLabel("ФИО проживающего");
                JLabel Name5TextLabel = new JLabel("ФИО проживающего");


                //JTextField DistrictField = new JTextField(15);
                JTextField StreetField = new JTextField(15);
                JTextField HomeField = new JTextField(15);
                JTextField FleatField = new JTextField(15);
                JTextField Name1Field = new JTextField(15);
                JTextField Name2Field = new JTextField(15);
                JTextField Name3Field = new JTextField(15);
                JTextField Name4Field = new JTextField(15);
                JTextField Name5Field = new JTextField(15);
                JComboBox DistrictBox = new JComboBox();
                DistrictBox.setEditable(true);

                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");
                DistrictBox.addItem("123");



                FillPanel.add(DistrictTextLabel);
                FillPanel.add(DistrictBox);

                FillPanel.add(StreetTextLabel);
                FillPanel.add(StreetField);

                FillPanel.add(HomeTextLabel);
                FillPanel.add(HomeField);

                FillPanel.add(FleatTextLabel);
                FillPanel.add(FleatField);

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


                // FillPanel.add(CountryBox);
                //FillPanel.add(AmountTextLabel);


                JPanel EditPanel = new JPanel();
                JButton AddButton = new JButton("Сохранить");
                AddButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){


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





        panelLayout.setHorizontalGroup(

                panelLayout.createParallelGroup(Alignment.LEADING)
                        //.addComponent(NameLabel)
                        .addComponent(StorageSearchButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StorageSearchTextField, Alignment.TRAILING)
                        .addComponent(LoadAmountTextField, Alignment.TRAILING)
                        .addComponent(LoadButton, Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(NameLabel))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(LoadAmountLabel)))
                                .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(LoadAmountLabel))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(NameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StorageSearchTextField, PREFERRED_SIZE, 27, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StorageSearchButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LoadAmountLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LoadAmountTextField, PREFERRED_SIZE, 27, PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(LoadButton))
        );
        tablestatus = 2;
    }

    public void setCataloguePanel(){
        SearchComboBox = new JComboBox<String>();
        SearchComboBox.addItem("По ФИО");
        SearchComboBox.addItem("По району");
        SearchComboBox.addItem("По адресу");

        SearchLabel.setText("Параметры поиска10");
        SearchLabel.setText("Параметры поиска");
        SearchTextField =  new JTextField();
        SearchTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String s = (String) SearchComboBox.getSelectedItem();
                if (s.equals("По имени")) {
                    nameSearch();

                } else if (s.equals("by company name")) {
                    companySearch();

                } else if (s.equals("by country name")) {
                    countrySearch();

                } else if (s.equals("by ID")) {
                    IDSearch();

                }
                SearchTextField.setText("");
            }
        });

        SearchButton = new JButton();
        SearchButton.setText("Найти");


        //AmountLabel.setText("Amount");

        AmountTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sell(Integer.parseInt(AmountTextField.getText()), (Integer)table.getModel().getValueAt(table.getSelectedRow(), 0));
                AmountTextField.setText("");
            }
        });
        SellButton.setText("Найти");
        SellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sell(Integer.parseInt(AmountTextField.getText()), (Integer) table.getModel().getValueAt(table.getSelectedRow(), 0));
                AmountTextField.setText("");
            }
        });
        panel.removeAll();
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);






        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(Alignment.LEADING)
                        .addGap(30, 30, 30)
                        .addComponent(SearchTextField, Alignment.TRAILING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGap(30, 30, 30)
                                .addComponent(SearchLabel)
                                .addContainerGap()
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addComponent(SearchComboBox, Alignment.TRAILING, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchTextField, Alignment.TRAILING)
                                //.addComponent(SearchLabel)
                                //addContainerGap(37, Short.MAX_VALUE))
                                // .addComponent(AmountTextField, GroupLayout.Alignment.TRAILING)
                                //.addComponent(AmountTextField, Alignment.TRAILING)
                        .addComponent(SearchButton, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                        // .addComponent(SearchLabel)
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
                                        .addComponent(SearchTextField, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                //.addComponent()
                                                //.addComponent(SearchLabel)
                                                // .addComponent(AmountTextField, PREFERRED_SIZE, 27, PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                                //.addComponent(SearchLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                // .addComponent(AmountTextField, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(SearchButton, PREFERRED_SIZE, 30, PREFERRED_SIZE)
                        )
        );
        tablestatus = 1;
    }

    public void load(int Amount,String name){

    }

    public void sell(int Amount,int id){

    }

    public void storageSearch(){

    }

    public void companySearch(){

    }

    public void countrySearch(){

    }

    public void nameSearch(){

    }

    public void IDSearch(){

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        /**try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PharmacyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        DatabaseFleats DatabaseFleats= new DatabaseFleats();
        Fleats[]  databasefleats;
        Fleats fleats =new Fleats("12345678901234567890", "12345678901234567890",1, 145,"12345678901234567890","12345678901234567890","12345678901234567890","12345678901234567890","12345678901234567890");
       // Fleats[0] = fleats;//={"12345678901234567890", "12345678901234567890", 1, 145, "12345678901234567890", "12345678901234567890", "12345678901234567890", "12345678901234567890", "12345678901234567890"};
        //Fleats leats =new Fleats("12345678901234567890", "12345678901234567890",1, 145,"12345678901234567890","12345678901234567890","12345678901234567890","12345678901234567890","12345678901234567890");
       // Fleats.Writeinfile(leats);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }



}
