/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Data.userData;
import Model.tableModel;
import Model.userModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *[21.00, 8/8/2022] Rosalina: William Jonathan Handoko 672020001
[21.00, 8/8/2022] Rosalina: Nadya Margareth Angkawijaya 672020002
[21.00, 8/8/2022] Rosalina: Michael Yohanson Mesak Foeh 672020003
[21.01, 8/8/2022] Rosalina: Asdie Indra Kurniawan 672020004
[21.01, 8/8/2022] Rosalina: Bayu Ponco Raharjo 672020022
[21.02, 8/8/2022] Rosalina: Alfonsus Liguori Penta Paramayoga 672020026
[21.03, 8/8/2022] Rosalina: Tifano Eng Ogotan 672020019
[21.03, 8/8/2022] Rosalina: Muhammad Faiq Adhitya Faqih 672020017
[21.03, 8/8/2022] Rika Ratri: Netiva Hidayah 672020060@student.uksw.edu
[21.04, 8/8/2022] Rosalina: Natanael Jeffrey Susanto 672020027
[21.04, 8/8/2022] Rika Ratri: Sindy Cristine Baun 672020052@student.uksw.edu
[21.04, 8/8/2022] Rosalina: Yemima Clara Wijaya 672020038
[21.05, 8/8/2022] Rika Ratri: Tiara Syah Indra Putri 672020242@student.uksw.edu
[21.05, 8/8/2022] Rosalina: Nita Fuji Astuti 672020039
[21.05, 8/8/2022] Rosalina: Bernadus Enggar Prasetya 672020032
[21.06, 8/8/2022] Rika Ratri: Usman Syach 672020201@student.uksw.edu
[21.07, 8/8/2022] Rika Ratri: Jordan Briandika 672020040@student.uksw.edu
[21.07, 8/8/2022] Rosalina: Bahar Lanang Prakosa 672020046
[21.07, 8/8/2022] Rosalina: Felix Wisnu Putra Mahendra 672020054
[21.08, 8/8/2022] Rosalina: Fieryando 672020064
[21.08, 8/8/2022] Rosalina: Giovano Vallerian Paleva 672020709
[21.09, 8/8/2022] Rosalina: Ega Fitri Yudha Satria Utama 672020068
[21.09, 8/8/2022] Rosalina: Demira Intan Suranda 672020118
[21.10, 8/8/2022] Rika Ratri: Adelliya Dewi Saputri 672020107@student.uksw.edu
[21.10, 8/8/2022] Rosalina: Evydian Rosa Putri 672020154
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UI extends javax.swing.JFrame {
    boolean crud,repeater = true;
    DefaultTableModel model;
    userModel mahasiswa;
    tableModel TabelModel;
    userData data = new userData();
    double vaksin1,vaksin2,vaksin3,vaksin4,vaksin5;
    int vaksin1Mahasiswa,vaksin2Mahasiswa,vaksin3Mahasiswa,vaksin4Mahasiswa,vaksin5Mahasiswa;
    
    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        displayDataMahasiswa();
        reset();
        startUp();
        colorStartUp();
        defaultTableModel();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        double width = toolkit.getScreenSize().getWidth();
        double height = toolkit.getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }
    private void defaultTableModel(){
        String [] defaultTable = {"NIM","NAMA","VAKSIN1","VAKSIN2","BOOSTER1","BOOSTER2","BOOSTER#"};
        model = new DefaultTableModel(defaultTable, 0);
        dataTable.setModel(model);
    }
    
    private void startUp(){
        
        dataButtonVisible(false);
        DashBoardPanel.setVisible(true);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(false);
        dashboardButton.setContentAreaFilled(false);
        dataButton.setContentAreaFilled(false);
        aboutButton.setContentAreaFilled(false);
        dataSortingProgress();
        progressImplements();
    } 
    
    private void colorStartUp(){
        colorHover();
        themeMainColor1(91,124,253);
        themeMainColor2(245,246,251);
        diagramProgressBar1.setForeground(new Color(91,124,253));
    }
    private void colorHover(){
            cardVaksin1.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            cardVaksin2.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            cardVaksin3.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            cardVaksin4.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            cardVaksin5.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            vaksinDiagram.setBorder(new LineBorder(new Color(208,231,251), 5, true));
            boosterDiagram.setBorder(new LineBorder(new Color(208,231,251), 5, true));
    }
    private void themeMainColor1(int red, int green, int blue){
        //Biru gelap
        //navigasiPanel.setBackground(new Color(red, green, blue));
    }
    private void themeMainColor2(int red, int green, int blue){
        //biru terang
        mainPanel.setBackground(new Color(red, green, blue));
        DashBoardPanel.setBackground(new Color(red, green, blue));
        DataPanel.setBackground(new Color(red, green, blue));
        AboutPanel.setBackground(new Color(red, green, blue));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        DashBoardPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cardVaksin1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        vaksin1ProgressBar = new javax.swing.JProgressBar();
        cardVaksin2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin2 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        vaksin2ProgressBar = new javax.swing.JProgressBar();
        cardVaksin3 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        vaksin3ProgressBar = new javax.swing.JProgressBar();
        cardVaksin4 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin4 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        vaksin4ProgressBar = new javax.swing.JProgressBar();
        cardVaksin5 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin5 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        vaksin5ProgressBar = new javax.swing.JProgressBar();
        vaksinDiagram = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        diagramProgressBar1 = new javax.swing.JProgressBar();
        boosterDiagram = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        DataPanel = new javax.swing.JPanel();
        namaTextField = new javax.swing.JTextField();
        nimTextField = new javax.swing.JTextField();
        vaksin1TextField = new javax.swing.JTextField();
        vaksin3TextField = new javax.swing.JTextField();
        vaksin2TextField = new javax.swing.JTextField();
        vaksin4TextField = new javax.swing.JTextField();
        vaksin5TextField = new javax.swing.JTextField();
        tabelScroll = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        simpanButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        tambahButton = new javax.swing.JButton();
        gantiButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AboutPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dashboardButton = new javax.swing.JButton();
        dataButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(196, 202, 233));
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(245, 246, 251));
        mainPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        DashBoardPanel.setBackground(new java.awt.Color(102, 255, 102));
        DashBoardPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        DashBoardPanel.setPreferredSize(new java.awt.Dimension(1366, 714));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/footerImage.png"))); // NOI18N

        cardVaksin1.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin1.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin1.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel1.setBackground(new java.awt.Color(208, 231, 251));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/vaksinIcon.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Vaccine - 1");

        jumlahMahasiswaCardVaksin1.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin1.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin1.setText("0");

        jLabel28.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Mahasiswa");

        vaksin1ProgressBar.setForeground(new java.awt.Color(91, 124, 253));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jumlahMahasiswaCardVaksin1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addComponent(vaksin1ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin1)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin1ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout cardVaksin1Layout = new javax.swing.GroupLayout(cardVaksin1);
        cardVaksin1.setLayout(cardVaksin1Layout);
        cardVaksin1Layout.setHorizontalGroup(
            cardVaksin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin1Layout.setVerticalGroup(
            cardVaksin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardVaksin1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardVaksin2.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin2.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin2.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel2.setBackground(new java.awt.Color(208, 231, 251));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/vaksinIcon.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Vaccine - 2");

        jumlahMahasiswaCardVaksin2.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin2.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin2.setText("0");

        jLabel36.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Mahasiswa");

        vaksin2ProgressBar.setForeground(new java.awt.Color(91, 124, 253));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36))
                    .addComponent(vaksin2ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin2)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin2ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin2Layout = new javax.swing.GroupLayout(cardVaksin2);
        cardVaksin2.setLayout(cardVaksin2Layout);
        cardVaksin2Layout.setHorizontalGroup(
            cardVaksin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin2Layout.setVerticalGroup(
            cardVaksin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardVaksin2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardVaksin3.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin3.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin3.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel3.setBackground(new java.awt.Color(208, 231, 251));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/boosterIcon.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Booster - 1");

        jumlahMahasiswaCardVaksin3.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin3.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin3.setText("0");

        jLabel35.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("Mahasiswa");

        vaksin3ProgressBar.setForeground(new java.awt.Color(91, 124, 253));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35))
                    .addComponent(vaksin3ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin3)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin3ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin3Layout = new javax.swing.GroupLayout(cardVaksin3);
        cardVaksin3.setLayout(cardVaksin3Layout);
        cardVaksin3Layout.setHorizontalGroup(
            cardVaksin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin3Layout.setVerticalGroup(
            cardVaksin3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardVaksin3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardVaksin4.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin4.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin4.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel4.setBackground(new java.awt.Color(208, 231, 251));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 102));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/boosterIcon.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Booster - 2");

        jumlahMahasiswaCardVaksin4.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin4.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin4.setText("0");

        jLabel34.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("Mahasiswa");

        vaksin4ProgressBar.setForeground(new java.awt.Color(91, 124, 253));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34))
                    .addComponent(vaksin4ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin4)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin4ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin4Layout = new javax.swing.GroupLayout(cardVaksin4);
        cardVaksin4.setLayout(cardVaksin4Layout);
        cardVaksin4Layout.setHorizontalGroup(
            cardVaksin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardVaksin4Layout.setVerticalGroup(
            cardVaksin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardVaksin4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardVaksin5.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin5.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin5.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel5.setBackground(new java.awt.Color(208, 231, 251));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/boosterIcon.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Booster - 3");

        jumlahMahasiswaCardVaksin5.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin5.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin5.setText("0");

        jLabel33.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Mahasiswa");

        vaksin5ProgressBar.setForeground(new java.awt.Color(91, 124, 253));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addComponent(vaksin5ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin5)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin5ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin5Layout = new javax.swing.GroupLayout(cardVaksin5);
        cardVaksin5.setLayout(cardVaksin5Layout);
        cardVaksin5Layout.setHorizontalGroup(
            cardVaksin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin5Layout.setVerticalGroup(
            cardVaksin5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardVaksin5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vaksinDiagram.setBackground(new java.awt.Color(245, 246, 251));

        jPanel8.setBackground(new java.awt.Color(208, 231, 251));

        diagramProgressBar1.setBackground(new java.awt.Color(245, 246, 251));
        diagramProgressBar1.setOrientation(1);
        diagramProgressBar1.setValue(50);
        diagramProgressBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(diagramProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(diagramProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout vaksinDiagramLayout = new javax.swing.GroupLayout(vaksinDiagram);
        vaksinDiagram.setLayout(vaksinDiagramLayout);
        vaksinDiagramLayout.setHorizontalGroup(
            vaksinDiagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vaksinDiagramLayout.setVerticalGroup(
            vaksinDiagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        boosterDiagram.setBackground(new java.awt.Color(245, 246, 251));

        jPanel9.setBackground(new java.awt.Color(208, 231, 251));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout boosterDiagramLayout = new javax.swing.GroupLayout(boosterDiagram);
        boosterDiagram.setLayout(boosterDiagramLayout);
        boosterDiagramLayout.setHorizontalGroup(
            boosterDiagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        boosterDiagramLayout.setVerticalGroup(
            boosterDiagramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashBoardPanelLayout = new javax.swing.GroupLayout(DashBoardPanel);
        DashBoardPanel.setLayout(DashBoardPanelLayout);
        DashBoardPanelLayout.setHorizontalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashBoardPanelLayout.createSequentialGroup()
                        .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardVaksin4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(cardVaksin5, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cardVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardVaksin1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(cardVaksin2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGap(89, 89, 89)
                        .addComponent(vaksinDiagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(boosterDiagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGap(23, 23, 23))
        );
        DashBoardPanelLayout.setVerticalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(cardVaksin1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addComponent(boosterDiagram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vaksinDiagram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(cardVaksin3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(63, 63, 63))
        );

        DataPanel.setBackground(new java.awt.Color(255, 51, 255));
        DataPanel.setPreferredSize(new java.awt.Dimension(1366, 714));

        namaTextField.setText("NAMA");
        namaTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namaTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaTextFieldFocusLost(evt);
            }
        });

        nimTextField.setText("NIM");
        nimTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nimTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nimTextFieldFocusLost(evt);
            }
        });

        vaksin1TextField.setText("VAKSIN 1");
        vaksin1TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vaksin1TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vaksin1TextFieldFocusLost(evt);
            }
        });

        vaksin3TextField.setText("VAKSIN 3");
        vaksin3TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vaksin3TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vaksin3TextFieldFocusLost(evt);
            }
        });

        vaksin2TextField.setText("VAKSIN 2");
        vaksin2TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vaksin2TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vaksin2TextFieldFocusLost(evt);
            }
        });

        vaksin4TextField.setText("VAKSIN 4");
        vaksin4TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vaksin4TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vaksin4TextFieldFocusLost(evt);
            }
        });

        vaksin5TextField.setText("VAKSIN 5");
        vaksin5TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vaksin5TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vaksin5TextFieldFocusLost(evt);
            }
        });

        dataTable.setAutoCreateRowSorter(true);
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "NAMA", "VAKSIN 1", "VAKSIN 2", "BOOSTER 1", "BOOSTER 2", "BOOSTER 3"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        tabelScroll.setViewportView(dataTable);

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        gantiButton.setText("Ganti");
        gantiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gantiButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/footerImage2.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 159, 217));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NIM");

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 159, 217));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(40, 159, 217));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Vaksin - 1");

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(40, 159, 217));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Vaksin - 2");

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 159, 217));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Booster - 1");

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(40, 159, 217));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Booster - 2");

        jLabel10.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 159, 217));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Booster - 3");

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gantiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaTextField)
                    .addComponent(nimTextField)
                    .addComponent(vaksin1TextField)
                    .addComponent(vaksin2TextField)
                    .addComponent(vaksin3TextField)
                    .addComponent(vaksin4TextField)
                    .addComponent(vaksin5TextField)
                    .addComponent(simpanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabelScroll))
                .addGap(36, 36, 36))
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gantiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AboutPanel.setMinimumSize(new java.awt.Dimension(1082, 747));
        AboutPanel.setName(""); // NOI18N
        AboutPanel.setPreferredSize(new java.awt.Dimension(1366, 714));
        AboutPanel.setRequestFocusEnabled(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/aboutImage.png"))); // NOI18N

        javax.swing.GroupLayout AboutPanelLayout = new javax.swing.GroupLayout(AboutPanel);
        AboutPanel.setLayout(AboutPanelLayout);
        AboutPanelLayout.setHorizontalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AboutPanelLayout.setVerticalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dashboardButton.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(153, 153, 153));
        dashboardButton.setText("Dashboard");
        dashboardButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dashboardButton.setBorderPainted(false);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboardButton.setFocusPainted(false);
        dashboardButton.setFocusable(false);
        dashboardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardButtonMouseExited(evt);
            }
        });
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });

        dataButton.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        dataButton.setForeground(new java.awt.Color(153, 153, 153));
        dataButton.setText("Data");
        dataButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dataButton.setBorderPainted(false);
        dataButton.setContentAreaFilled(false);
        dataButton.setFocusPainted(false);
        dataButton.setFocusable(false);
        dataButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dataButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dataButtonMouseExited(evt);
            }
        });
        dataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        aboutButton.setForeground(new java.awt.Color(153, 153, 153));
        aboutButton.setText("About");
        aboutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        aboutButton.setBorderPainted(false);
        aboutButton.setContentAreaFilled(false);
        aboutButton.setFocusPainted(false);
        aboutButton.setFocusable(false);
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonMouseExited(evt);
            }
        });
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(91, 124, 253));
        jLabel11.setText("Medical Assist Software");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(207, 207, 207)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(DashBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(AboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 715, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        dataButtonVisible(false);
        DashBoardPanel.setVisible(true);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(false);
        dataSortingProgress();
        progressImplements();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void dataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataButtonActionPerformed
        dataButtonVisible(true);
        DashBoardPanel.setVisible(false);
        DataPanel.setVisible(true);
        AboutPanel.setVisible(false);
        displayDataMahasiswa();
    }//GEN-LAST:event_dataButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        DashBoardPanel.setVisible(false);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(true);
        dataButtonVisible(false);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        TabelModel = new tableModel();
        mahasiswa = new userModel();
        if (nimTextField.getText().equals(TabelModel.getNIM()) || namaTextField.getText().equals(TabelModel.getNAMA()) ){
            JOptionPane.showMessageDialog(this, "Masukkan NIM atau Nama terlebih dahulu");
        }else{
            mahasiswa.setNIM(nimTextField.getText());
            mahasiswa.setNama(namaTextField.getText());
        }
        if (vaksin1TextField.getText().equals(TabelModel.getVAKSIN1())) {mahasiswa.setVaksin1("-");}else{mahasiswa.setVaksin1(vaksin1TextField.getText());}
        if (vaksin2TextField.getText().equals(TabelModel.getVAKSIN2())) {mahasiswa.setVaksin2("-");}else{mahasiswa.setVaksin2(vaksin2TextField.getText());}
        if (vaksin3TextField.getText().equals(TabelModel.getVAKSIN3())) {mahasiswa.setVaksin3("-");}else{mahasiswa.setVaksin3(vaksin3TextField.getText());}
        if (vaksin4TextField.getText().equals(TabelModel.getVAKSIN4())) {mahasiswa.setVaksin4("-");}else{mahasiswa.setVaksin4(vaksin4TextField.getText());}
        if (vaksin5TextField.getText().equals(TabelModel.getVAKSIN5())) {mahasiswa.setVaksin5("-");}else{mahasiswa.setVaksin5(vaksin5TextField.getText());}
        
        if (data.simpanDataMahasiswa(mahasiswa)) {
            JOptionPane.showMessageDialog(this, "Sukses Menambah Data");
            displayDataMahasiswa();
            reset();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal Menambah Data");
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini?","Delete Mahasiswa",0)==0){
            mahasiswa = new userModel();
            mahasiswa.setNIM(nimTextField.getText());
            if (data.hapusDataMahasiswa(mahasiswa)) {
                JOptionPane.showMessageDialog(this, "Sukses Menghapus Data");
                displayDataMahasiswa();
                reset();
            }else{
                JOptionPane.showMessageDialog(this, "Gagal Menghapus Data");
            }
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        displayDataMahasiswa();
        reset();
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void gantiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gantiButtonActionPerformed
        mahasiswa = new userModel();
        if (nimTextField.getText().equals(TabelModel.getNIM()) || namaTextField.getText().equals(TabelModel.getNAMA()) ){
            JOptionPane.showMessageDialog(this, "Masukkan NIM atau Nama terlebih dahulu");
        }else{
            mahasiswa.setNIM(nimTextField.getText());
            mahasiswa.setNama(namaTextField.getText());
        }
        if (vaksin1TextField.getText().equals(TabelModel.getVAKSIN1())) {mahasiswa.setVaksin1("-");}else{mahasiswa.setVaksin1(vaksin1TextField.getText());}
        if (vaksin2TextField.getText().equals(TabelModel.getVAKSIN2())) {mahasiswa.setVaksin2("-");}else{mahasiswa.setVaksin2(vaksin2TextField.getText());}
        if (vaksin3TextField.getText().equals(TabelModel.getVAKSIN3())) {mahasiswa.setVaksin3("-");}else{mahasiswa.setVaksin3(vaksin3TextField.getText());}
        if (vaksin4TextField.getText().equals(TabelModel.getVAKSIN4())) {mahasiswa.setVaksin4("-");}else{mahasiswa.setVaksin4(vaksin4TextField.getText());}
        if (vaksin5TextField.getText().equals(TabelModel.getVAKSIN5())) {mahasiswa.setVaksin5("-");}else{mahasiswa.setVaksin5(vaksin5TextField.getText());}
        
        if (data.gantiDataMahasiswa(mahasiswa)) {
            JOptionPane.showMessageDialog(this, "Berhasil Ganti Data");
            displayDataMahasiswa();
            reset();
        }else{
            JOptionPane.showMessageDialog(this, "Gagal Ganti Data");
        }
    }//GEN-LAST:event_gantiButtonActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        int row = dataTable.getSelectedRow();
        nimTextField.setText(dataTable.getValueAt(row, 0).toString());
        namaTextField.setText(dataTable.getValueAt(row, 1).toString());
        vaksin1TextField.setText(dataTable.getValueAt(row, 2).toString());
        vaksin2TextField.setText(dataTable.getValueAt(row, 3).toString());
        vaksin3TextField.setText(dataTable.getValueAt(row, 4).toString());
        vaksin4TextField.setText(dataTable.getValueAt(row, 5).toString());
        vaksin5TextField.setText(dataTable.getValueAt(row, 6).toString());
        nimTextField.setForeground(new Color(0,0,0));
        namaTextField.setForeground(new Color(0,0,0));
        vaksin1TextField.setForeground(new Color(0,0,0));
        vaksin2TextField.setForeground(new Color(0,0,0));
        vaksin3TextField.setForeground(new Color(0,0,0));
        vaksin4TextField.setForeground(new Color(0,0,0));
        vaksin5TextField.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_dataTableMouseClicked

    private void nimTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusGained
        if(nimTextField.getText().equals(TabelModel.getNIM())){
            nimTextField.setText("");
            nimTextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_nimTextFieldFocusGained

    private void namaTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaTextFieldFocusGained
        if(namaTextField.getText().equals(TabelModel.getNAMA())){
            namaTextField.setText("");
            namaTextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_namaTextFieldFocusGained

    private void vaksin1TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin1TextFieldFocusGained
        if(vaksin1TextField.getText().equals(TabelModel.getVAKSIN1())){
            vaksin1TextField.setText("");
            vaksin1TextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_vaksin1TextFieldFocusGained

    private void vaksin2TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin2TextFieldFocusGained
        if(vaksin2TextField.getText().equals(TabelModel.getVAKSIN2())){
            vaksin2TextField.setText("");
            vaksin2TextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_vaksin2TextFieldFocusGained

    private void vaksin3TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin3TextFieldFocusGained
        if(vaksin3TextField.getText().equals(TabelModel.getVAKSIN3())){
            vaksin3TextField.setText("");
            vaksin3TextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_vaksin3TextFieldFocusGained

    private void vaksin4TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin4TextFieldFocusGained
        if(vaksin4TextField.getText().equals(TabelModel.getVAKSIN4())){
            vaksin4TextField.setText("");
            vaksin4TextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_vaksin4TextFieldFocusGained

    private void vaksin5TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin5TextFieldFocusGained
        if(vaksin5TextField.getText().equals(TabelModel.getVAKSIN5())){
            vaksin5TextField.setText("");
            vaksin5TextField.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_vaksin5TextFieldFocusGained

    private void nimTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusLost
        if(nimTextField.getText().equals("")){
            nimTextField.setText(TabelModel.getNIM());
            nimTextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_nimTextFieldFocusLost

    private void namaTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaTextFieldFocusLost
        if(namaTextField.getText().equals("")){
            namaTextField.setText(TabelModel.getNAMA());
            namaTextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_namaTextFieldFocusLost

    private void vaksin1TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin1TextFieldFocusLost
        if(vaksin1TextField.getText().equals("")){
            vaksin1TextField.setText(TabelModel.getVAKSIN1());
            vaksin1TextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_vaksin1TextFieldFocusLost

    private void vaksin2TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin2TextFieldFocusLost
        if(vaksin2TextField.getText().equals("")){
            vaksin2TextField.setText(TabelModel.getVAKSIN2());
            vaksin2TextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_vaksin2TextFieldFocusLost

    private void vaksin3TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin3TextFieldFocusLost
        if(vaksin3TextField.getText().equals("")){
            vaksin3TextField.setText(TabelModel.getVAKSIN3());
            vaksin3TextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_vaksin3TextFieldFocusLost

    private void vaksin4TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin4TextFieldFocusLost
        if(vaksin4TextField.getText().equals("")){
            vaksin4TextField.setText(TabelModel.getVAKSIN4());
            vaksin4TextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_vaksin4TextFieldFocusLost

    private void vaksin5TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin5TextFieldFocusLost
        if(vaksin5TextField.getText().equals("")){
            vaksin5TextField.setText(TabelModel.getVAKSIN5());
            vaksin5TextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_vaksin5TextFieldFocusLost

    private void dashboardButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardButtonMouseEntered
        dashboardButton.setForeground(new Color(40,159,217));
    }//GEN-LAST:event_dashboardButtonMouseEntered

    private void dashboardButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardButtonMouseExited
        dashboardButton.setForeground(new Color(153,153,153));
        progressImplements();
    }//GEN-LAST:event_dashboardButtonMouseExited

    private void dataButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataButtonMouseEntered
        dataButton.setForeground(new Color(40,159,217));
    }//GEN-LAST:event_dataButtonMouseEntered

    private void dataButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataButtonMouseExited
        dataButton.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_dataButtonMouseExited

    private void aboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseEntered
        aboutButton.setForeground(new Color(40,159,217));
    }//GEN-LAST:event_aboutButtonMouseEntered

    private void aboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseExited
        aboutButton.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_aboutButtonMouseExited
    private void dataButtonVisible(boolean crud){
        simpanButton.setVisible(crud);
        hapusButton.setVisible(crud);
        tambahButton.setVisible(crud);
        gantiButton.setVisible(crud);
        tabelScroll.setVisible(crud);
        namaTextField.setVisible(crud);
        nimTextField.setVisible(crud);
        vaksin1TextField.setVisible(crud);
        vaksin2TextField.setVisible(crud);
        vaksin3TextField.setVisible(crud);
        vaksin4TextField.setVisible(crud);
        vaksin5TextField.setVisible(crud);
    }
    private void displayDataMahasiswa(){
        List<userModel> ls = new ArrayList<userModel>();
        ls = new userData().getAll();
        String DataMahasiswa[][] = new String[ls.size()][7];
        for (int i = 0; i < ls.size(); i++) {
            DataMahasiswa[i][0] = ls.get(i).getNIM();
            DataMahasiswa[i][1] = ls.get(i).getNama();
            DataMahasiswa[i][2] = ls.get(i).getVaksin1();
            DataMahasiswa[i][3] = ls.get(i).getVaksin2();
            DataMahasiswa[i][4] = ls.get(i).getVaksin3();
            DataMahasiswa[i][5] = ls.get(i).getVaksin4();
            DataMahasiswa[i][6] = ls.get(i).getVaksin5();
        }
        dataTable.setModel(new DefaultTableModel(DataMahasiswa, new String[]{"NIM","NAMA","VAKSIN1","VAKSIN2","BOOSTER1","BOOSTER2","BOOSTER3"}));
    }
    private void reset(){
        TabelModel = new tableModel();
        nimTextField.setText(TabelModel.getNIM());
        namaTextField.setText(TabelModel.getNAMA());
        vaksin1TextField.setText(TabelModel.getVAKSIN1());
        vaksin2TextField.setText(TabelModel.getVAKSIN2());
        vaksin3TextField.setText(TabelModel.getVAKSIN3());
        vaksin4TextField.setText(TabelModel.getVAKSIN4());
        vaksin5TextField.setText(TabelModel.getVAKSIN5());
        nimTextField.setForeground(new Color(153,153,153));
        namaTextField.setForeground(new Color(153,153,153));
        vaksin1TextField.setForeground(new Color(153,153,153));
        vaksin2TextField.setForeground(new Color(153,153,153));
        vaksin3TextField.setForeground(new Color(153,153,153));
        vaksin4TextField.setForeground(new Color(153,153,153));
        vaksin5TextField.setForeground(new Color(153,153,153));
    }
    private void dataSortingProgress(){     
        vaksin1 = 0; vaksin2 = 0; vaksin3 = 0; vaksin4 = 0; vaksin5 = 0;
        vaksin1Mahasiswa = 0; vaksin2Mahasiswa = 0; vaksin3Mahasiswa = 0; vaksin4Mahasiswa = 0; vaksin5Mahasiswa = 0;
        List<userModel> ls = new ArrayList<userModel>();
        ls = new userData().getAll();
        String DataSort[][] = new String[ls.size()][7];
            for (int i = 0; i < ls.size(); i++) {
                DataSort[i][0] = ls.get(i).getNIM();
                DataSort[i][1] = ls.get(i).getNama();
                DataSort[i][2] = ls.get(i).getVaksin1();
                if (DataSort[i][2].equals("-") == false) {vaksin1++;vaksin1Mahasiswa++;}
                DataSort[i][3] = ls.get(i).getVaksin2();
                if (DataSort[i][3].equals("-") == false) {vaksin2++;vaksin2Mahasiswa++;}
                DataSort[i][4] = ls.get(i).getVaksin3();
                if (DataSort[i][4].equals("-") == false) {vaksin3++;vaksin3Mahasiswa++;}
                DataSort[i][5] = ls.get(i).getVaksin4();
                if (DataSort[i][5].equals("-") == false) {vaksin4++;vaksin4Mahasiswa++;}
                DataSort[i][6] = ls.get(i).getVaksin5();
                if (DataSort[i][6].equals("-") == false) {vaksin5++;vaksin5Mahasiswa++;}
            }
    }
    private void progressImplements(){
        vaksin1ProgressBar.setValue(progressAlgoritm(vaksin1));
        vaksin2ProgressBar.setValue(progressAlgoritm(vaksin2));
        vaksin3ProgressBar.setValue(progressAlgoritm(vaksin3));
        vaksin4ProgressBar.setValue(progressAlgoritm(vaksin4));
        vaksin5ProgressBar.setValue(progressAlgoritm(vaksin5));
        jumlahMahasiswaCardVaksin1.setText("" + vaksin1Mahasiswa);
        jumlahMahasiswaCardVaksin2.setText("" + vaksin2Mahasiswa);
        jumlahMahasiswaCardVaksin3.setText("" + vaksin3Mahasiswa);
        jumlahMahasiswaCardVaksin4.setText("" + vaksin4Mahasiswa);
        jumlahMahasiswaCardVaksin5.setText("" + vaksin5Mahasiswa);
    }
    private int progressAlgoritm(double vaksin){
        double barisTabel = dataTable.getRowCount();
        double pembagian = (vaksin/barisTabel);
        int persentasi = (int) (pembagian * 100);
        return persentasi;
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AboutPanel;
    private javax.swing.JPanel DashBoardPanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton aboutButton;
    private javax.swing.JPanel boosterDiagram;
    private javax.swing.JPanel cardVaksin1;
    private javax.swing.JPanel cardVaksin2;
    private javax.swing.JPanel cardVaksin3;
    private javax.swing.JPanel cardVaksin4;
    private javax.swing.JPanel cardVaksin5;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton dataButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JProgressBar diagramProgressBar1;
    private javax.swing.JButton gantiButton;
    private javax.swing.JButton hapusButton;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin1;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin2;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin3;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin4;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JButton simpanButton;
    private javax.swing.JScrollPane tabelScroll;
    private javax.swing.JButton tambahButton;
    private javax.swing.JProgressBar vaksin1ProgressBar;
    private javax.swing.JTextField vaksin1TextField;
    private javax.swing.JProgressBar vaksin2ProgressBar;
    private javax.swing.JTextField vaksin2TextField;
    private javax.swing.JProgressBar vaksin3ProgressBar;
    private javax.swing.JTextField vaksin3TextField;
    private javax.swing.JProgressBar vaksin4ProgressBar;
    private javax.swing.JTextField vaksin4TextField;
    private javax.swing.JProgressBar vaksin5ProgressBar;
    private javax.swing.JTextField vaksin5TextField;
    private javax.swing.JPanel vaksinDiagram;
    // End of variables declaration//GEN-END:variables
}
