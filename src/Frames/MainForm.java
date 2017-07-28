/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import CellRendered.CellRenderFootbaler;
import CellRendered.CellRenderTeams;
import HelperClasses.HelperMethods;
import Persons.Coach;
import Persons.Kontrakt;
import Persons.Pilkarz;
import Team.Druzyna;
import Team.League;
import Trwalosc.ObjectPlus;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/************************************************************************
Opis : Glowna forma do GUI z panelami
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-06-18
************************************************************************/
/**
 *
 * @author Dominik Deja
 */
public class MainForm extends javax.swing.JFrame {

        private DefaultListModel dm=new DefaultListModel();
    
        private Pilkarz pk;
        
        private Druzyna druzyn;
        
        private String nazwaPlikuIconPilkarz = "C:\\Users\\Dominik Deja\\messiIcon.png";
        
        private String nazwaPlikuIconDruzyna = "C:\\Users\\Dominik Deja\\messiIcon.png";
        
        private String nazwaPlikuEks = "C:\\Users\\Dominik Deja\\Ekstensja.txt";
        
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        
//        try{
//       
//            
//            
//        Pilkarz pk1 = new Pilkarz("Dominik","Deja",HelperMethods.getDateFromString("09/05/1995"),
//                        new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00),Pilkarz.Noga.Lewa,Pilkarz.Pozycja.Napastnik);
//        dm.addElement(pk1);
//        Pilkarz pk2 = new Pilkarz("Dominik","Deja",HelperMethods.getDateFromString("09/05/1995"),
//                        new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00),Pilkarz.Noga.Lewa,Pilkarz.Pozycja.Napastnik);
//        dm.addElement(pk2);
//        Pilkarz pk3 = new Pilkarz("Dominik","Deja",HelperMethods.getDateFromString("09/05/1995"),
//                        new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00),Pilkarz.Noga.Lewa,Pilkarz.Pozycja.Napastnik);
//        dm.addElement(pk3);
//        Pilkarz pk4 = new Pilkarz("Dominik","Deja",HelperMethods.getDateFromString("09/05/1995"),
//                        new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00),Pilkarz.Noga.Lewa,Pilkarz.Pozycja.Napastnik);
//        dm.addElement(pk4);
//        Pilkarz pk5 = new Pilkarz("Dominik","Deja",HelperMethods.getDateFromString("09/05/1995"),
//                        new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00),Pilkarz.Noga.Lewa,Pilkarz.Pozycja.Napastnik); 
//        dm.addElement(pk5);
//        Druzyna dr1 = new Druzyna("Legia Warszawa","1921",1000.00,new Coach("Krzysztof","Lizinczyk",HelperMethods.getDateFromString("09/05/1995"),new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00)));
//        dr1.dodajPilkarz(pk1);
//        dr1.dodajPilkarz(pk2);
//        Druzyna dr2 = new Druzyna("Real Madryt","1917",1000.00,new Coach("Franciszek","Smuda",HelperMethods.getDateFromString("09/05/1995"),new Kontrakt(HelperMethods.getDateFromString("01/12/2015"),HelperMethods.getDateFromString("01/12/2017"),12000.00)));
//        dr2.dodajPilkarz(pk3);
//        dr2.dodajPilkarz(pk4);
//        dr2.dodajPilkarz(pk5);
//        League lg = new League("Ekstraklasa");
//        League lg2 = new League("Ligue 1");
//        dr1.setLige(lg);
//        
//        }catch(Exception ex){
//              
//              }  
        
        initComponents();
        
        WindowAdapter windowAdapter = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                SaveEkstancja();
                System.exit(0);
            }
        };
        
        addWindowListener(windowAdapter);
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
        
        jPanel1.add(MenuGłówne);
        jPanel1.repaint();
        jPanel1.revalidate();
        
        list_Teams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = list_Teams.getSelectedIndex();
                ListModel dlm = list_Teams.getModel();
                Image image = null;
                btn_zmienLigeDruzyna.setEnabled(true);
                try{
                    if(index >= 0){
                 druzyn = (Druzyna) dlm.getElementAt(index);
                
                dm = new DefaultListModel();
                    if(druzyn.getPilkarze() != null){
                        for(Pilkarz pk : druzyn.getPilkarze()){
                             dm.addElement(pk);
                        }
                    }
                    ListOfFootballerinTeam.setCellRenderer(new CellRenderFootbaler());
                    ListOfFootballerinTeam.setModel(dm);
                 
                team_nazwa.setText(druzyn.getNazwa());
                team_Datazalozenia.setText(druzyn.getDataZalozenia());
                team_budzet.setText(druzyn.getBudzet().toString());
                team_trener.setText((druzyn.getTrener() == null) ? "" : druzyn.getTrener().getImie());
                team_liga.setText((druzyn.getliga()==null)? "" : druzyn.getliga().getNazwaLigi());
                
                
                
                    image = ImageIO.read(new File(nazwaPlikuIconDruzyna));
                    Icon icon = new ImageIcon(image);
                    icon_team.setIcon(icon);
                    }
             
                } catch (Exception ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        ListaPilkarzyJList.addListSelectionListener(new ListSelectionListener() {

            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = ListaPilkarzyJList.getSelectedIndex();
                ListModel dlm = ListaPilkarzyJList.getModel();
                Image image = null;
                try{
                    if(index >= 0){
                pk = (Pilkarz) dlm.getElementAt(index);
                
                setNotEnabledOfPilkarzProfil();
                
                txt_PilkarzName.setText(pk.getImie());
                txt_PilkarzNazwisko.setText(pk.getNazwisko());
                txt_PilkarzDataUrodzenia.setText(HelperMethods.convertDateToString(pk.getDataUrodzenia()));
                cb_lepszanoga.setSelectedItem(pk.getNoga());
                cb_pozycja.setSelectedItem(pk.getPozycja());
                txt_Bramkistrzelone.setText(String.valueOf(pk.getStatystyki().getGole()));
                txt_asysty.setText(String.valueOf(pk.getStatystyki().getAsysty()));
                txt_asysty.setText(String.valueOf(pk.getStatystyki().getAsysty()));
                txt_rozegranemecze.setText(String.valueOf(pk.getStatystyki().getRozegraneMecze()));
                txt_rozegraneminuty.setText(String.valueOf(pk.getStatystyki().getRozegraneMinuty()));
                txt_druzyna.setText((pk.getDruzyna() == null) ? "" : pk.getDruzyna().getNazwa());
                txt_PilkarzDataPoczatkowa.setText(HelperMethods.convertDateToString(pk.getKt().getPoczatekKontraktu()));
                txt_PilkarzDataKoncowa.setText(HelperMethods.convertDateToString(pk.getKt().getKoniecKontraktu()));
                txt_PilkarzZarobki.setText(String.valueOf(pk.getKt().getZarobki()));
                
                
                    image = ImageIO.read(new File(nazwaPlikuIconPilkarz));
                    Icon icon = new ImageIcon(image);
                     Image_Pilkarz.setIcon(icon);
                     btn_Transfer.setEnabled(true);
                    }
             
                } catch (Exception ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        DruzynyPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_Teams = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        team_nazwa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        team_budzet = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        team_Datazalozenia = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        team_trener = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        team_liga = new javax.swing.JTextField();
        icon_team = new javax.swing.JLabel();
        btn_EdytujDruzyna = new javax.swing.JButton();
        btn_ZapiszDruzyne = new javax.swing.JButton();
        btn_AnulujDruzyna = new javax.swing.JButton();
        btn_zmienLigeDruzyna = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListOfFootballerinTeam = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        btn_dodajDruzyne = new javax.swing.JButton();
        MenuGłówne = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PilkarzePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPilkarzyJList = new javax.swing.JList<>();
        PilkarzPanelProfil = new javax.swing.JPanel();
        Image_Pilkarz = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_PilkarzName = new javax.swing.JTextField();
        txt_PilkarzNazwisko = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_PilkarzDataUrodzenia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_Bramkistrzelone = new javax.swing.JTextField();
        txt_rozegranemecze = new javax.swing.JTextField();
        txt_asysty = new javax.swing.JTextField();
        txt_rozegraneminuty = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_druzyna = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btn_edytujPilkarza = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_pilkrzaSave = new javax.swing.JButton();
        cb_pozycja = new javax.swing.JComboBox<>();
        cb_lepszanoga = new javax.swing.JComboBox<>();
        btn_Transfer = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lbl_pilkarzkontrakZarobki = new javax.swing.JLabel();
        lbl_pilkarzkontrakDataKoncowa = new javax.swing.JLabel();
        lbl_pilkarzkontraktDataPoczatkowa = new javax.swing.JLabel();
        txt_PilkarzDataPoczatkowa = new javax.swing.JTextField();
        txt_PilkarzZarobki = new javax.swing.JTextField();
        txt_PilkarzDataKoncowa = new javax.swing.JTextField();
        PilkarzName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        DruzynyPanel.setBackground(new java.awt.Color(204, 204, 204));
        DruzynyPanel.setPreferredSize(new java.awt.Dimension(899, 625));

        jScrollPane2.setViewportView(list_Teams);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Druzyny");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Data założenia");

        team_nazwa.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Nazwa");

        team_budzet.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Główny Trener");

        team_Datazalozenia.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Budzet");

        team_trener.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Liga");

        team_liga.setEditable(false);

        btn_EdytujDruzyna.setText("Edytuj");
        btn_EdytujDruzyna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EdytujDruzynaActionPerformed(evt);
            }
        });

        btn_ZapiszDruzyne.setText("Zapisz");
        btn_ZapiszDruzyne.setEnabled(false);
        btn_ZapiszDruzyne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ZapiszDruzyneActionPerformed(evt);
            }
        });

        btn_AnulujDruzyna.setText("Anuluj");
        btn_AnulujDruzyna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnulujDruzynaActionPerformed(evt);
            }
        });

        btn_zmienLigeDruzyna.setText("Zmien Lige");
        btn_zmienLigeDruzyna.setEnabled(false);
        btn_zmienLigeDruzyna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zmienLigeDruzynaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(team_Datazalozenia, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(team_budzet, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(team_trener, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(team_liga, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(btn_zmienLigeDruzyna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(team_nazwa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(icon_team, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_EdytujDruzyna, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ZapiszDruzyne, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_AnulujDruzyna, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_team, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_EdytujDruzyna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ZapiszDruzyne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_AnulujDruzyna)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(team_nazwa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(team_Datazalozenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(team_budzet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(team_trener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(team_liga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_zmienLigeDruzyna)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(ListOfFootballerinTeam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Druzyna");

        btn_dodajDruzyne.setText("Dodaj Druzyne");
        btn_dodajDruzyne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dodajDruzyneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DruzynyPanelLayout = new javax.swing.GroupLayout(DruzynyPanel);
        DruzynyPanel.setLayout(DruzynyPanelLayout);
        DruzynyPanelLayout.setHorizontalGroup(
            DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DruzynyPanelLayout.createSequentialGroup()
                .addGroup(DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DruzynyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DruzynyPanelLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4)))
                .addGap(26, 26, 26)
                .addGroup(DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DruzynyPanelLayout.createSequentialGroup()
                        .addComponent(btn_dodajDruzyne, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DruzynyPanelLayout.setVerticalGroup(
            DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DruzynyPanelLayout.createSequentialGroup()
                .addGroup(DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DruzynyPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(btn_dodajDruzyne)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DruzynyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DruzynyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        MenuGłówne.setBackground(new java.awt.Color(204, 204, 204));
        MenuGłówne.setPreferredSize(new java.awt.Dimension(899, 625));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Aplikacja piłkarska do zarzadzania Ligami oraz drużynami");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/uefa2.jpg"))); // NOI18N

        javax.swing.GroupLayout MenuGłówneLayout = new javax.swing.GroupLayout(MenuGłówne);
        MenuGłówne.setLayout(MenuGłówneLayout);
        MenuGłówneLayout.setHorizontalGroup(
            MenuGłówneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuGłówneLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel5)
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuGłówneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(344, 344, 344))
        );
        MenuGłówneLayout.setVerticalGroup(
            MenuGłówneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuGłówneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        PilkarzePanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setViewportView(ListaPilkarzyJList);

        jLabel6.setText("Imie");

        jLabel7.setText("Nazwisko");

        jLabel8.setText("Data Urodzenia");

        txt_PilkarzName.setEditable(false);

        txt_PilkarzNazwisko.setEditable(false);

        jLabel9.setText("Lepsza Noga");

        txt_PilkarzDataUrodzenia.setEditable(false);

        jLabel10.setText("Pozycja");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Statystyki");

        jLabel11.setText("Gole Strzelone");

        jLabel12.setText("Asysty");

        jLabel13.setText("Rozegrane mecze");

        jLabel14.setText("Rozegrane minuty");

        txt_Bramkistrzelone.setEditable(false);
        txt_Bramkistrzelone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BramkistrzeloneActionPerformed(evt);
            }
        });

        txt_rozegranemecze.setEditable(false);
        txt_rozegranemecze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rozegranemeczeActionPerformed(evt);
            }
        });

        txt_asysty.setEditable(false);
        txt_asysty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_asystyActionPerformed(evt);
            }
        });

        txt_rozegraneminuty.setEditable(false);
        txt_rozegraneminuty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rozegraneminutyActionPerformed(evt);
            }
        });

        jLabel15.setText("Druzyna");

        txt_druzyna.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Liga");

        btn_edytujPilkarza.setText("Edytuj");
        btn_edytujPilkarza.setToolTipText("");
        btn_edytujPilkarza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edytujPilkarzaActionPerformed(evt);
            }
        });

        jButton2.setText("Anuluj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_pilkrzaSave.setText("Zapisz");
        btn_pilkrzaSave.setActionCommand("");
        btn_pilkrzaSave.setEnabled(false);
        btn_pilkrzaSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilkrzaSaveActionPerformed(evt);
            }
        });

        cb_pozycja.setEnabled(false);

        cb_lepszanoga.setEnabled(false);

        btn_Transfer.setText("Transfer");
        btn_Transfer.setEnabled(false);
        btn_Transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TransferActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Kontrakt");

        lbl_pilkarzkontrakZarobki.setText("Zarobki");

        lbl_pilkarzkontrakDataKoncowa.setText("Data koncowa");

        lbl_pilkarzkontraktDataPoczatkowa.setText("Data poczatkowa");

        txt_PilkarzDataPoczatkowa.setEditable(false);
        txt_PilkarzDataPoczatkowa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PilkarzDataPoczatkowaActionPerformed(evt);
            }
        });

        txt_PilkarzZarobki.setEditable(false);
        txt_PilkarzZarobki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PilkarzZarobkiActionPerformed(evt);
            }
        });

        txt_PilkarzDataKoncowa.setEditable(false);
        txt_PilkarzDataKoncowa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PilkarzDataKoncowaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PilkarzPanelProfilLayout = new javax.swing.GroupLayout(PilkarzPanelProfil);
        PilkarzPanelProfil.setLayout(PilkarzPanelProfilLayout);
        PilkarzPanelProfilLayout.setHorizontalGroup(
            PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(140, 140, 140))
            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PilkarzPanelProfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzPanelProfilLayout.createSequentialGroup()
                                        .addComponent(Image_Pilkarz, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))
                                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(btn_edytujPilkarza, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btn_pilkrzaSave, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)))
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cb_pozycja, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_PilkarzDataUrodzenia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addGap(31, 31, 31)
                                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_PilkarzName, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                .addComponent(txt_PilkarzNazwisko, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                            .addComponent(cb_lepszanoga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txt_rozegraneminuty, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txt_rozegranemecze, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzPanelProfilLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addGap(67, 67, 67)
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_asysty, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Bramkistrzelone, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)))
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_Transfer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_druzyna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                            .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PilkarzPanelProfilLayout.createSequentialGroup()
                                    .addComponent(lbl_pilkarzkontrakDataKoncowa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_PilkarzDataKoncowa, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                    .addComponent(lbl_pilkarzkontrakZarobki)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_PilkarzZarobki, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PilkarzPanelProfilLayout.createSequentialGroup()
                                    .addComponent(lbl_pilkarzkontraktDataPoczatkowa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_PilkarzDataPoczatkowa, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzPanelProfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(110, 110, 110))
        );
        PilkarzPanelProfilLayout.setVerticalGroup(
            PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_PilkarzName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_PilkarzNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_PilkarzDataUrodzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Image_Pilkarz, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cb_lepszanoga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_edytujPilkarza)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pilkrzaSave)
                .addGap(14, 14, 14)
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_pozycja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_Bramkistrzelone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_druzyna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Transfer)
                .addGap(3, 3, 3)
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_asysty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_rozegranemecze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_rozegraneminuty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(PilkarzPanelProfilLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pilkarzkontraktDataPoczatkowa)
                            .addComponent(txt_PilkarzDataPoczatkowa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pilkarzkontrakDataKoncowa)
                            .addComponent(txt_PilkarzDataKoncowa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(PilkarzPanelProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pilkarzkontrakZarobki)
                            .addComponent(txt_PilkarzZarobki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );

        PilkarzName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Lista Piłkarzy");

        jToggleButton1.setText("Dodaj nowego Piłkarza");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PilkarzePanelLayout = new javax.swing.GroupLayout(PilkarzePanel);
        PilkarzePanel.setLayout(PilkarzePanelLayout);
        PilkarzePanelLayout.setHorizontalGroup(
            PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilkarzePanelLayout.createSequentialGroup()
                .addGroup(PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PilkarzePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PilkarzePanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PilkarzePanelLayout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PilkarzName)
                        .addGap(277, 277, 277))
                    .addGroup(PilkarzePanelLayout.createSequentialGroup()
                        .addComponent(PilkarzPanelProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PilkarzePanelLayout.setVerticalGroup(
            PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzePanelLayout.createSequentialGroup()
                .addGroup(PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PilkarzePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(PilkarzName)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PilkarzePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)))
                .addGroup(PilkarzePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PilkarzPanelProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MenuGłówne, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(PilkarzePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DruzynyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MenuGłówne, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(PilkarzePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(DruzynyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenu1.setText("Glowne Menu");

        jMenuItem5.setText("Glowne");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem1.setText("Pilkarze");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Druzyny");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opcje");

        jMenuItem6.setText("Zapisz ekstensje");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Odczytaj Ekstensje");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem4.setText("Wyjscie");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        cb_lepszanoga.removeAllItems();
        cb_lepszanoga.setModel(new DefaultComboBoxModel(Pilkarz.Noga.values()));
        cb_pozycja.removeAllItems();
        cb_pozycja.setModel(new DefaultComboBoxModel(Pilkarz.Pozycja.values()));
        
        dm = new DefaultListModel();
        if(Pilkarz.getEkstensja() != null){
            for(Pilkarz pk : Pilkarz.getEkstensja()){
            dm.addElement(pk);
            }
        }
        
        
  
        
        
        ListaPilkarzyJList.setCellRenderer(new CellRenderFootbaler());
        ListaPilkarzyJList.setModel(dm);
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
        
        jPanel1.add(PilkarzePanel);
        jPanel1.repaint();
        jPanel1.revalidate();
        
        
        
        
//        PilkarzePanel pk = new PilkarzePanel();
//        pk.setBackground(Color.BLUE);
//        jPanel1.add(pk);
//        jPanel1.repaint();
//        jPanel1.revalidate();
//        pk.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        dm = new DefaultListModel();
        if(Druzyna.getEkstensjaDruzyna() != null){
            for(Druzyna dr : Druzyna.getEkstensjaDruzyna()){
            dm.addElement(dr);
            }
        }
        
        list_Teams.setCellRenderer(new CellRenderTeams());
        list_Teams.setModel(dm);
        
        
        
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
        
        jPanel1.add(DruzynyPanel);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SaveEkstancja();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
        
        jPanel1.add(MenuGłówne);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void txt_BramkistrzeloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BramkistrzeloneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BramkistrzeloneActionPerformed

    private void txt_rozegranemeczeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rozegranemeczeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rozegranemeczeActionPerformed

    private void txt_asystyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_asystyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_asystyActionPerformed

    private void txt_rozegraneminutyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rozegraneminutyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rozegraneminutyActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        SaveEkstancja();
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FileInputStream in;
            try {
                int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Czy chcesz odczytac ekstansje?", 
                                  "Wybierz", 
                                  JOptionPane.YES_NO_OPTION); 
    if (selectedOption == JOptionPane.YES_OPTION) {
        in = new FileInputStream(nazwaPlikuEks);
                 ObjectInputStream ois = new ObjectInputStream(in);
                 ObjectPlus.odczytajEkstensje(ois);
    }
                 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    //edytujPilkarza
    private void btn_edytujPilkarzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edytujPilkarzaActionPerformed
        setEnabledofPilkarzProfile();
        btn_pilkrzaSave.setEnabled(true);
    }//GEN-LAST:event_btn_edytujPilkarzaActionPerformed

    //Zapisz Piłkarza
    private void btn_pilkrzaSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilkrzaSaveActionPerformed
       Boolean err = false;
        
        try{
           
        pk.setNoga((Pilkarz.Noga)cb_lepszanoga.getSelectedItem());
        pk.setPozycja((Pilkarz.Pozycja)cb_pozycja.getSelectedItem());
        pk.setImie(txt_PilkarzName.getText());
        pk.setNazwisko(txt_PilkarzNazwisko.getText());
        pk.setData_Urodzenia(HelperMethods.getDateFromString(txt_PilkarzDataUrodzenia.getText()));
        pk.getStatystyki().setIloscGoli(Integer.valueOf(txt_Bramkistrzelone.getText()));
        pk.getStatystyki().setIloscAsyst(Integer.valueOf(txt_asysty.getText()));
        pk.getStatystyki().setRozegranemecze(Integer.valueOf(txt_rozegranemecze.getText()));
        pk.getStatystyki().setRozegraneminuty(Integer.valueOf(txt_rozegraneminuty.getText()));
        pk.getKt().setKoniecKontraktu(HelperMethods.getDateFromString(txt_PilkarzDataKoncowa.getText()));
        pk.getKt().setPoczatekKontraktu(HelperMethods.getDateFromString(txt_PilkarzDataPoczatkowa.getText()));
        pk.getKt().setZarobki(Double.valueOf(txt_PilkarzZarobki.getText()));
        
       }catch(Exception ex){
           err = true;
           JOptionPane.showMessageDialog(this, 
             "Error", "Błąd", JOptionPane.ERROR_MESSAGE);
       }
        if(!err){
       setNotEnabledOfPilkarzProfil();
       btn_pilkrzaSave.setEnabled(false);
        JOptionPane.showMessageDialog(this, 
             "Dane Pilkarza zostaly zmienione", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_pilkrzaSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setNotEnabledOfPilkarzProfil();   
        btn_pilkrzaSave.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

   public void SaveEkstancja(){
       FileOutputStream out;
            try {
                int selectedOption = JOptionPane.showConfirmDialog(null, 
                                  "Czy chcesz zapisac ekstansje?", 
                                  "Wybierz", 
                                  JOptionPane.YES_NO_OPTION); 
    if (selectedOption == JOptionPane.YES_OPTION) {
                 out = new FileOutputStream(nazwaPlikuEks);
                 ObjectOutputStream oout = new ObjectOutputStream(out);
                 ObjectPlus.zapiszEkstensje(oout);
    }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
            DodajPilkarzaFrame pilkFrame = new DodajPilkarzaFrame();
            pilkFrame.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btn_TransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TransferActionPerformed
        TransferPilkarza tp = new TransferPilkarza(pk);
        tp.setVisible(true);
    }//GEN-LAST:event_btn_TransferActionPerformed

    private void btn_EdytujDruzynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EdytujDruzynaActionPerformed
            setEditableTeamFields();
            btn_ZapiszDruzyne.setEnabled(true);
    }//GEN-LAST:event_btn_EdytujDruzynaActionPerformed

    private void btn_AnulujDruzynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnulujDruzynaActionPerformed
        setNonEditableTeamFields();
        btn_ZapiszDruzyne.setEnabled(false);
    }//GEN-LAST:event_btn_AnulujDruzynaActionPerformed

    private void txt_PilkarzDataPoczatkowaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PilkarzDataPoczatkowaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PilkarzDataPoczatkowaActionPerformed

    private void txt_PilkarzZarobkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PilkarzZarobkiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PilkarzZarobkiActionPerformed

    private void txt_PilkarzDataKoncowaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PilkarzDataKoncowaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PilkarzDataKoncowaActionPerformed

    private void btn_ZapiszDruzyneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ZapiszDruzyneActionPerformed
        Boolean err = false;  
        
        try{
        druzyn.setData_zalozenia(team_Datazalozenia.getText());
        druzyn.setBudzet(Double.valueOf(team_budzet.getText()));
        druzyn.setNazwa(team_nazwa.getText());
        
        }catch(Exception ex){
            err = true;
           JOptionPane.showMessageDialog(this, 
             "ErrorMsg", "Failure", JOptionPane.ERROR_MESSAGE);
       }
        if(!err){
          setNonEditableTeamFields();
          btn_ZapiszDruzyne.setEnabled(false);
          JOptionPane.showMessageDialog(this, 
             "Done", "Dane Pilkarza zostaly zmienione", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ZapiszDruzyneActionPerformed

    private void btn_dodajDruzyneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dodajDruzyneActionPerformed
        DodajDruzyneJFrame dDr = new DodajDruzyneJFrame();
        dDr.setVisible(true);
    }//GEN-LAST:event_btn_dodajDruzyneActionPerformed

    private void btn_zmienLigeDruzynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zmienLigeDruzynaActionPerformed
        ZmienLigeFrame zmf = new ZmienLigeFrame(druzyn);
        zmf.setVisible(true);
    }//GEN-LAST:event_btn_zmienLigeDruzynaActionPerformed

    private void setEditableTeamFields(){
        team_Datazalozenia.setEditable(true);
        team_budzet.setEditable(true);
        team_nazwa.setEditable(true);
        
    }
    private void setNonEditableTeamFields(){
        team_Datazalozenia.setEditable(false);
        team_budzet.setEditable(false);
        team_nazwa.setEditable(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
    public void setEnabledofPilkarzProfile(){
        if(pk != null){
        txt_Bramkistrzelone.setEditable(true);
        cb_lepszanoga.setEnabled(true);
        txt_PilkarzDataPoczatkowa.setEditable(true);
        txt_PilkarzDataKoncowa.setEditable(true);
        txt_PilkarzZarobki.setEditable(true);
        txt_PilkarzDataUrodzenia.setEditable(true);
        txt_PilkarzName.setEditable(true);
        txt_PilkarzNazwisko.setEditable(true);
        txt_asysty.setEditable(true);
        cb_pozycja.setEnabled(true);
        txt_rozegranemecze.setEditable(true);
        txt_rozegraneminuty.setEditable(true);
        }
    }
    
    public void setNotEnabledOfPilkarzProfil(){
        txt_PilkarzDataPoczatkowa.setEditable(false);
        txt_PilkarzDataKoncowa.setEditable(false);
        txt_PilkarzZarobki.setEditable(false);
        txt_Bramkistrzelone.setEditable(false);
        cb_lepszanoga.setEnabled(false);
        txt_PilkarzDataUrodzenia.setEditable(false);
        txt_PilkarzName.setEditable(false);
        txt_PilkarzNazwisko.setEditable(false);
        txt_asysty.setEditable(false);
        cb_pozycja.setEnabled(false);
        txt_rozegranemecze.setEditable(false);
        txt_rozegraneminuty.setEditable(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DruzynyPanel;
    private javax.swing.JLabel Image_Pilkarz;
    private javax.swing.JList<String> ListOfFootballerinTeam;
    private javax.swing.JList<String> ListaPilkarzyJList;
    private javax.swing.JPanel MenuGłówne;
    private javax.swing.JLabel PilkarzName;
    private javax.swing.JPanel PilkarzPanelProfil;
    private javax.swing.JPanel PilkarzePanel;
    private javax.swing.JButton btn_AnulujDruzyna;
    private javax.swing.JButton btn_EdytujDruzyna;
    private javax.swing.JButton btn_Transfer;
    private javax.swing.JButton btn_ZapiszDruzyne;
    private javax.swing.JButton btn_dodajDruzyne;
    private javax.swing.JButton btn_edytujPilkarza;
    private javax.swing.JButton btn_pilkrzaSave;
    private javax.swing.JButton btn_zmienLigeDruzyna;
    private javax.swing.JComboBox<String> cb_lepszanoga;
    private javax.swing.JComboBox<String> cb_pozycja;
    private javax.swing.JLabel icon_team;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_pilkarzkontrakDataKoncowa;
    private javax.swing.JLabel lbl_pilkarzkontrakZarobki;
    private javax.swing.JLabel lbl_pilkarzkontraktDataPoczatkowa;
    private javax.swing.JList<String> list_Teams;
    private javax.swing.JTextField team_Datazalozenia;
    private javax.swing.JTextField team_budzet;
    private javax.swing.JTextField team_liga;
    private javax.swing.JTextField team_nazwa;
    private javax.swing.JTextField team_trener;
    private javax.swing.JTextField txt_Bramkistrzelone;
    private javax.swing.JTextField txt_PilkarzDataKoncowa;
    private javax.swing.JTextField txt_PilkarzDataPoczatkowa;
    private javax.swing.JTextField txt_PilkarzDataUrodzenia;
    private javax.swing.JTextField txt_PilkarzName;
    private javax.swing.JTextField txt_PilkarzNazwisko;
    private javax.swing.JTextField txt_PilkarzZarobki;
    private javax.swing.JTextField txt_asysty;
    private javax.swing.JTextField txt_druzyna;
    private javax.swing.JTextField txt_rozegranemecze;
    private javax.swing.JTextField txt_rozegraneminuty;
    // End of variables declaration//GEN-END:variables
}
