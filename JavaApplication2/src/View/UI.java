 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Data.userData;
import Language.language;
import Model.userModel;
import Storage.colorData;
import Storage.informationData;
import Storage.valueData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UI extends javax.swing.JFrame {
    boolean crud,repeater = true;
    DefaultTableModel model;
    userModel mahasiswa;
    userData data = new userData();
    UrlSource urlSource = new UrlSource();
    
    valueData value = new valueData();
    language bahasa = new language();
    informationData information = new informationData();
    colorData colorSource = new colorData();
    int maxDiagramVaksinValue = 20,maxDiagramBoosterValue = 20,card1InformationRepeater = 0;
    int sinovacVaksin,sputnikVaksin,novavaxVaksin,oxfordAZVaksin,pfizerBTVaksin,modernaVaksin,sinopharmVaksin, pfizerBTBooster, oxfordAZBooster, modernaBooster;
    int vaksinCardValue1,vaksinCardValue2,vaksinCardValue3,vaksinCardValue4,vaksinCardValue5,vaksinCardValue6,vaksinCardValue7,boosterValue1,boosterValue2,boosterValue3;
    boolean card1=true,card2=true,card3=true,card4=true,card5=true,card6=true,card7=true,card8 = true, card9 = true, card10=true;
    boolean sinovac=true,sputnik=true,novavax=true,oxfordaz=true,pfizerbt=true,moderna=true,sinopharm=true;
    boolean pfizerCard = true, astrazenecaCard = true, modernaCard =true, tableClicked = false;
    int sinovacValue,sputnikValue,novavaxValue,oxfordazValue,pfizerbtValue,modernaValue,sinopharmValue;
    /**
     * Creates new form UI
     */
    public UI() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        double width = toolkit.getScreenSize().getWidth();
        double height = toolkit.getScreenSize().getHeight();
        
        if (width > 1366 && height > 768) {
            this.setSize(1366, 768);
        }else{
            this.setSize((int)width, (int)height);
        }   
        initComponents();
        bahasa();
        displayDataMahasiswa();
        reset();
        startUp();
        colorStartUp();
        defaultTableModel();

    }

    private void defaultTableModel(){
        String [] defaultTable = {"NIM",bahasa.getNAMA(),bahasa.getVAKSIN1(),bahasa.getVAKSIN2(),bahasa.getVAKSIN3(),bahasa.getVAKSIN4(),bahasa.getVAKSIN5()};
        model = new DefaultTableModel(defaultTable, 0);
        dataTable.setModel(model);
    }
    private void bahasa(){
        bahasa.setLanguage("Indonesia");
    }
    private void startUp(){
        dataButtonVisible(false);
        DashBoardPanel.setVisible(true);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(false);
        InformationPanel.setVisible(false);
        dashboardButton.setContentAreaFilled(false);
        dataButton.setContentAreaFilled(false);
        otherButton.setContentAreaFilled(false);
        otherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.about2Url)));
        dashboardButton.setForeground(new Color(91,124,253));
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.dashboard1Url)));
        dataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.data2Url)));
        informationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.info2Url)));
        dataSortingProgress();
        cardVaksinSortingAlgortim();
        progressImplements();
        cardBoosterSortingAlgoritm();
        hiddenPanel.setVisible(false);
    } 
    
    class UrlSource{
        String sinovacUrl = "/Image/sinovacCard.png";
        String sputnik = "/Image/sputnikCard.png";
        String novavaxUrl = "/Image/novavaxCard.png";
        String astrazenecaUrl = "/Image/astrazenecaCard.png";
        String pfizerUrl = "/Image/pfizerCard.png";
        String modernaUrl = "/Image/modernaCard.png";
        String sinopharmUrl = "/Image/sinopharmCard.png";
        String dashboard1Url = "/Image/dashboardIcon1.png";
        String dashboard2Url = "/Image/dashboardIcon2.png";
        String data1Url = "/Image/dataIcon1.png";
        String data2Url = "/Image/dataIcon2.png";
        String about1Url = "/Image/otherIcon1.png";
        String about2Url = "/Image/otherIcon2.png";
        String info1Url = "/Image/infoIcon1.png";
        String info2Url = "/Image/infoIcon2.png";
    }
    
    private void colorStartUp(){
        colorHover();
        themeMainColor1(91,124,253);
        themeMainColor2(245,246,251);
    }
    private void colorHover(){
            cardVaksin1.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            cardVaksin2.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            cardVaksin3.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            cardVaksin4.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            cardVaksin5.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            cardVaksin6.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin7.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin8.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin9.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin10.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin11.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardVaksin12.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardBooster1.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardBooster2.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            cardBooster3.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            centerAboutPage.setBorder(new LineBorder(colorSource.biruTua(), 8, true));
            vaksinDiagram.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            boosterDiagram.setBorder(new LineBorder(colorSource.biruTua(), 5, true));
            
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
        dataTable.setModel(new DefaultTableModel(DataMahasiswa, new String[]{"NIM",bahasa.getNAMA(),bahasa.getVAKSIN1(),bahasa.getVAKSIN2(),bahasa.getVAKSIN3(),bahasa.getVAKSIN4(),bahasa.getVAKSIN5()}));
        
    }
    private void reset(){
        nimTextField.setEditable(true);
        nimTextField.setText(bahasa.getNIM());
        namaTextField.setText(bahasa.getNAMA());
        vaksin1TextField.setText(bahasa.getVAKSIN1());
        vaksin2TextField.setText(bahasa.getVAKSIN2());
        vaksin3TextField.setText(bahasa.getVAKSIN3());
        vaksin4TextField.setText(bahasa.getVAKSIN4());
        vaksin5TextField.setText(bahasa.getVAKSIN5());
        nimTextField.setForeground(colorSource.abuabu());
        namaTextField.setForeground(colorSource.abuabu());
        vaksin1TextField.setForeground(colorSource.abuabu());
        vaksin2TextField.setForeground(colorSource.abuabu());
        vaksin3TextField.setForeground(colorSource.abuabu());
        vaksin4TextField.setForeground(colorSource.abuabu());
        vaksin5TextField.setForeground(colorSource.abuabu());
        //==========Label==========
        cardLabel1.setText(bahasa.getVAKSIN() + " - 1");
        cardLabel2.setText(bahasa.getVAKSIN() + " - 2");
        cardLabel3.setText(bahasa.getBOOSTER() + " - 1");
        cardLabel4.setText(bahasa.getBOOSTER() + " - 2");
        cardLabel5.setText(bahasa.getBOOSTER() + " - 3");
        dataLabel1.setText(bahasa.getNIM());
        dataLabel2.setText(bahasa.getNAMA());
        dataLabel3.setText(bahasa.getVAKSIN()+ " - 1");
        dataLabel4.setText(bahasa.getVAKSIN()+ " - 2");
        dataLabel5.setText(bahasa.getBOOSTER()+ " - 1");
        dataLabel6.setText(bahasa.getBOOSTER()+ " - 2");
        dataLabel7.setText(bahasa.getBOOSTER()+ " - 3");
        diagramLabel1.setText(bahasa.getVAKSIN());
        diagramLabel2.setText(bahasa.getBOOSTER());
        searchTextField.setText(bahasa.getSearch());
        labelMahasiswa1.setText(bahasa.getMahasiswa());
        labelMahasiswa2.setText(bahasa.getMahasiswa());
        labelMahasiswa3.setText(bahasa.getMahasiswa());
        labelMahasiswa4.setText(bahasa.getMahasiswa());
        labelMahasiswa5.setText(bahasa.getMahasiswa());
        dashboardButton.setText(bahasa.getDashboard());
        dataButton.setText(bahasa.getData());
        informationButton.setText(bahasa.getInformation());
        otherButton.setText(bahasa.getOther());
        //=======Button========
        simpanButton.setText(bahasa.getButtonSimpan());
        hapusButton.setText(bahasa.getButtonHapus());
        gantiButton.setText(bahasa.getButtonGanti());
        tambahButton.setText(bahasa.getButtonTambah());
        searchButton.setText(bahasa.getButtonSearch());
        browseButton.setText(bahasa.getButtonBrowse());
        exportButton.setText(bahasa.getButtonExport());
        showComboBox.setSelectedIndex(0);
        exportComboBox.setSelectedIndex(0);
        tableClicked = false;
    }
    private void dataSortingProgress(){     
        value.setVaksin1(0); value.setVaksin2(0); value.setVaksin3(0);value.setVaksin4(0);value.setVaksin5(0);
        value.setMahasiswaVaksin1(0); value.setMahasiswaVaksin2(0);value.setMahasiswaVaksin3(0);value.setMahasiswaVaksin4(0);value.setMahasiswaVaksin5(0);
        sinovacVaksin = 0; sputnikVaksin = 0; novavaxVaksin = 0; oxfordAZVaksin = 0; pfizerBTVaksin = 0; modernaVaksin = 0; sinopharmVaksin = 0;
        pfizerBTBooster = 0; oxfordAZBooster = 0; modernaBooster = 0;
        List<userModel> ls = new ArrayList<userModel>();
        ls = new userData().getAll();
        String DataSort[][] = new String[ls.size()][7];
            for (int i = 0; i < ls.size(); i++) {
                DataSort[i][0] = ls.get(i).getNIM();
                DataSort[i][1] = ls.get(i).getNama();
                DataSort[i][2] = ls.get(i).getVaksin1();
                if (DataSort[i][2].equals("-") == false) {value.addVaksin1();value.addMahasiswaVaksin1();}
                if(DataSort[i][2].equals("Sinovac") == true){sinovacVaksin++;}
                else if(DataSort[i][2].equals("Sputnik V") == true){sputnikVaksin++;}
                else if(DataSort[i][2].equals("Novavax") == true){novavaxVaksin++;}
                else if(DataSort[i][2].equals("Oxford-AstraZeneca") == true){oxfordAZVaksin++;}
                else if(DataSort[i][2].equals("Pfizer-BioNTech") == true){pfizerBTVaksin++;}
                else if(DataSort[i][2].equals("Moderna") == true){modernaVaksin++;}
                else if(DataSort[i][2].equals("Sinopharm") == true){sinopharmVaksin++;}
                DataSort[i][3] = ls.get(i).getVaksin2();
                if (DataSort[i][3].equals("-") == false) {value.addVaksin2();value.addMahasiswaVaksin2();}
                DataSort[i][4] = ls.get(i).getVaksin3();
                if (DataSort[i][4].equals("-") == false) {value.addVaksin3();value.addMahasiswaVaksin3();}
                if (DataSort[i][4].equals("Pfizer-BioNTech") == true) {pfizerBTBooster++;}
                else if (DataSort[i][4].equals("Oxford-AstraZeneca") == true) {oxfordAZBooster++;}
                else if (DataSort[i][4].equals("Moderna") == true) {modernaBooster++;}
                DataSort[i][5] = ls.get(i).getVaksin4();
                if (DataSort[i][5].equals("-") == false) {value.addVaksin4();value.addMahasiswaVaksin4();}
                DataSort[i][6] = ls.get(i).getVaksin5();
                if (DataSort[i][6].equals("-") == false) {value.addVaksin5();value.addMahasiswaVaksin5();}
            }
        diagramValueResponsive();
        
    }
    private void cardBoosterSortingAlgoritm(){
        int pfizerBoosterValue = pfizerBTBooster;
        int oxfordBoosterValue = oxfordAZBooster;
        int modernaBoosterValue = modernaBooster;
        card8 = true; card9 = true; card10 = true;
        pfizerCard = true; astrazenecaCard = true; modernaCard =true;
        int boosterArray[] = {pfizerBoosterValue,oxfordBoosterValue,modernaBoosterValue};
        Arrays.sort(boosterArray);
        sortData(boosterArray);
        boosterCardValue1.setText(""+boosterValue1);
        boosterCardValue2.setText(""+boosterValue2);
        boosterCardValue3.setText(""+boosterValue3);
        boosterSorting(pfizerBTBooster);
        boosterSorting(oxfordAZBooster);
        boosterSorting(modernaBoosterValue);
    }
    private void sortData(int[] sortBooster){
        for (int i = 0; i < 3; ) {
            boosterValue3 = sortBooster[0];
            boosterValue2 = sortBooster[1];
            boosterValue1 = sortBooster[2];
            i++;
        }        
    }
    private void boosterSorting(int value){
        if(value == boosterValue1 && card8 == true){
            if (boosterValue1 == pfizerBTBooster && pfizerCard == true) {//========================================================================= Card 1 =========================================================//
                cardBoosterImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                boosterTitle1.setText("Pfizer");
                pfizerCard = false;
            }else if (boosterValue1 == oxfordAZBooster && astrazenecaCard == true) {
                cardBoosterImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                boosterTitle1.setText("AstraZeneca");
                astrazenecaCard = false;
            }else if (boosterValue1 == modernaBooster && modernaCard == true) {
                cardBoosterImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                boosterTitle1.setText("Moderna");
                modernaCard = false;
            }
            card8 = false;
        }else if(value == boosterValue2 && card9 == true){
            if (boosterValue2 == pfizerBTBooster && pfizerCard == true) {//========================================================================= Card 2 =========================================================//
                cardBoosterImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                boosterTitle2.setText("Pfizer");
                pfizerCard = false;
            }else if (boosterValue2 == oxfordAZBooster && astrazenecaCard == true) {
                cardBoosterImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                boosterTitle2.setText("AstraZeneca");
                astrazenecaCard = false;
            }else if (boosterValue2 == modernaBooster && modernaCard == true) {
                cardBoosterImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                boosterTitle2.setText("Moderna");
                modernaCard = false;
            }
            card9 = false;
        }else if(value == boosterValue3 && card10 == true){
            if (boosterValue3 == pfizerBTBooster && pfizerCard == true) {//========================================================================= Card 3 =========================================================//
                cardBoosterImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                boosterTitle3.setText("Pfizer");
                pfizerCard = false;
            }else if (boosterValue3 == oxfordAZBooster && astrazenecaCard == true) {
                cardBoosterImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                boosterTitle3.setText("AstraZeneca");
                astrazenecaCard = false;
            }else if (boosterValue3 == modernaBooster && modernaCard == true) {
                cardBoosterImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                boosterTitle3.setText("Moderna");
                modernaCard = false;
            }
            card10 = false;
        }
        
    }
    
    private void cardVaksinSortingAlgortim(){
        //String sinovacString = "" + sinovacVaksin;
        sinovac=true;sputnik=true;novavax=true;oxfordaz=true;pfizerbt=true;moderna=true;sinopharm=true;
        card1 = true;card2 = true;card3 = true;card4 = true;card5 = true;card6 = true;card7 = true;
        sinovacValue = sinovacVaksin;
        sputnikValue = sputnikVaksin;
        novavaxValue = novavaxVaksin;
        oxfordazValue = oxfordAZVaksin;
        pfizerbtValue = pfizerBTVaksin;
        modernaValue = modernaVaksin;
        sinopharmValue = sinopharmVaksin;
        int vaccineArray[] = {sinovacValue,sputnikValue,novavaxValue,oxfordazValue,pfizerbtValue,modernaValue,sinopharmValue};
        Arrays.sort(vaccineArray);
        showSort(vaccineArray);
        cardVaksinValue1.setText("" + vaksinCardValue1);
        cardVaksinValue2.setText("" + vaksinCardValue2);
        cardVaksinValue3.setText("" + vaksinCardValue3);
        cardVaksinValue4.setText("" + vaksinCardValue4);
        cardVaksinValue5.setText("" + vaksinCardValue5);
        cardVaksinValue6.setText("" + vaksinCardValue6);
        cardVaksinValue7.setText("" + vaksinCardValue7);
        titleSort(sinovacVaksin);
        titleSort(sputnikVaksin);
        titleSort(novavaxVaksin);
        titleSort(oxfordAZVaksin);
        titleSort(pfizerBTVaksin);
        titleSort(modernaVaksin);
        titleSort(sinopharmVaksin);
    }
    public void showSort(int[] sortVaksin){
        for (int i = 0; i < 7; ) {
            vaksinCardValue7 = sortVaksin[0];
            vaksinCardValue6 = sortVaksin[1];
            vaksinCardValue5 = sortVaksin[2];
            vaksinCardValue4 = sortVaksin[3];
            vaksinCardValue3 = sortVaksin[4];
            vaksinCardValue2 = sortVaksin[5];
            vaksinCardValue1 = sortVaksin[6];
            i++;
        }
    }
    public void titleSort(int value){
        if (value == vaksinCardValue1 && card1 == true) {
            
            if (vaksinCardValue1 == sinovacVaksin && sinovac == true) {//========================================================================= Card 1 =========================================================//
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle1.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue1 == sputnikVaksin && sputnik == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle1.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue1 == novavaxVaksin && novavax == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle1.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue1 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle1.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue1 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle1.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue1 == modernaVaksin && moderna == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle1.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue1 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle1.setText("Sinopharm");
                sinopharm = false;
            }
            card1 = false;
        }else if (value == vaksinCardValue2 && card2 == true) {//========================================================================= Card 2 =========================================================//
            
            if (vaksinCardValue2 == sinovacVaksin && sinovac == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle2.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue2 == sputnikVaksin && sputnik == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle2.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue2 == novavaxVaksin && novavax == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle2.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue2 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle2.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue2 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle2.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue2 == modernaVaksin && moderna == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle2.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue2 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle2.setText("Sinopharm");
                sinopharm = false;
            }
            card2 = false;
        }else if (value == vaksinCardValue3 && card3 == true) {//========================================================================= Card 3 =========================================================//
            
            if (vaksinCardValue3 == sinovacVaksin && sinovac == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle3.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue3 == sputnikVaksin && sputnik == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle3.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue3 == novavaxVaksin && novavax == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle3.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue3 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle3.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue3 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle3.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue3 == modernaVaksin && moderna == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle3.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue3 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle3.setText("Sinopharm");
                sinopharm = false;
            }
            card3 = false;
        }else if (value == vaksinCardValue4 && card4 == true) {//========================================================================= Card 4 =========================================================//
            
            if (vaksinCardValue4 == sinovacVaksin && sinovac == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle4.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue4 == sputnikVaksin && sputnik == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle4.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue4 == novavaxVaksin && novavax == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle4.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue4 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle4.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue4 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle4.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue4 == modernaVaksin && moderna == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle4.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue4 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle4.setText("Sinopharm");
                sinopharm = false;
            }
            card4 = false;
        }else if (value == vaksinCardValue5 && card5 == true) {//========================================================================= Card 5 =========================================================//
            
            if (vaksinCardValue5 == sinovacVaksin && sinovac == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle5.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue5 == sputnikVaksin && sputnik == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle5.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue5 == novavaxVaksin && novavax == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle5.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue5 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle5.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue5 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle5.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue5 == modernaVaksin && moderna == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle5.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue5 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle5.setText("Sinopharm");
                sinopharm = false;
            }
            card5 = false;
        }else if (value == vaksinCardValue6 && card6 == true) {//========================================================================= Card 6 =========================================================//
            
            if (vaksinCardValue6 == sinovacVaksin && sinovac == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle6.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue3 == sputnikVaksin && sputnik == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle6.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue6 == novavaxVaksin && novavax == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle6.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue6 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle6.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue6 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle6.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue6 == modernaVaksin && moderna == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle6.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue6 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle6.setText("Sinopharm");
                sinopharm = false;
            }
            card6 = false;
        }else if (value == vaksinCardValue7 && card7 == true) {//========================================================================= Card 7 =========================================================//
            
            if (vaksinCardValue7 == sinovacVaksin && sinovac == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinovacUrl)));
                cardTitle7.setText("Sinovac");
                sinovac = false;
            }else if (vaksinCardValue7 == sputnikVaksin && sputnik == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sputnik)));
                cardTitle7.setText("Sputnik V");
                sputnik = false;
            }else if (vaksinCardValue7 == novavaxVaksin && novavax == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.novavaxUrl)));
                cardTitle7.setText("Novavax");
                novavax = false;
            }else if (vaksinCardValue7 == oxfordAZVaksin && oxfordaz == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.astrazenecaUrl)));
                cardTitle7.setText("AstraZeneca");
                oxfordaz = false;
            }else if (vaksinCardValue7 == pfizerBTVaksin && pfizerbt == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.pfizerUrl)));
                cardTitle7.setText("Pfizer");
                pfizerbt = false;
            }else if (vaksinCardValue7 == modernaVaksin && moderna == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.modernaUrl)));
                cardTitle7.setText("Moderna");
                moderna = false;
            }else if (vaksinCardValue7 == sinopharmVaksin && sinopharm == true) {
                cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.sinopharmUrl)));
                cardTitle7.setText("Sinopharm");
                sinopharm = false;
            }
            card7 = false;
        }
    }
    private void diagramValueResponsive(){
    if (sinovacVaksin > maxDiagramVaksinValue || sputnikVaksin > maxDiagramVaksinValue || novavaxVaksin > maxDiagramVaksinValue || oxfordAZVaksin > maxDiagramVaksinValue | pfizerBTVaksin > maxDiagramVaksinValue || modernaVaksin > maxDiagramVaksinValue || sinopharmVaksin > maxDiagramVaksinValue) {
            maxDiagramVaksinValue += 20;
        }
    if (pfizerBTBooster > maxDiagramBoosterValue || oxfordAZBooster > maxDiagramBoosterValue || modernaBooster > maxDiagramBoosterValue) {
            maxDiagramBoosterValue += 20;
    }
    int halfDiagramVaksinValue = (maxDiagramVaksinValue / 2);
    int halfDiagramBoosterValue = (maxDiagramBoosterValue / 2);
    diagramHalfMaxValueBooster.setText("" + halfDiagramBoosterValue);
    diagramHalfMaxValueVaksin.setText("" + halfDiagramVaksinValue);
    diagramMaxValueBooster.setText("" + maxDiagramBoosterValue);
    diagramMaxValueVaksin.setText("" + maxDiagramVaksinValue);
    diagramProgressBarVaksin1.setMaximum(maxDiagramVaksinValue);
    diagramProgressBaVaksinr2.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarVaksin3.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarVaksin4.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarVaksin5.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarVaksin6.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarVaksin7.setMaximum(maxDiagramVaksinValue);
    diagramProgressBarBooster1.setMaximum(maxDiagramBoosterValue);
    diagramProgressBarBooster2.setMaximum(maxDiagramBoosterValue);
    diagramProgressBarBooster3.setMaximum(maxDiagramBoosterValue);
    }
    private void progressImplements(){
        vaksin1ProgressBar.setValue(progressAlgoritm(value.getVaksin1()));
        vaksin2ProgressBar.setValue(progressAlgoritm(value.getVaksin2()));
        vaksin3ProgressBar.setValue(progressAlgoritm(value.getVaksin3()));
        vaksin4ProgressBar.setValue(progressAlgoritm(value.getVaksin4()));
        vaksin5ProgressBar.setValue(progressAlgoritm(value.getVaksin5()));
        persentasiVaksin1.setText(progressAlgoritm(value.getVaksin1()) +"%");
        persentasiVaksin2.setText(progressAlgoritm(value.getVaksin2())+"%");
        persentasiVaksin3.setText(progressAlgoritm(value.getVaksin3())+"%");
        persentasiVaksin4.setText(progressAlgoritm(value.getVaksin4())+"%");
        persentasiVaksin5.setText(progressAlgoritm(value.getVaksin5())+"%");
        diagramProgressBarVaksin1.setValue(sinovacVaksin);
        diagramProgressBaVaksinr2.setValue(sputnikVaksin);
        diagramProgressBarVaksin3.setValue(novavaxVaksin);
        diagramProgressBarVaksin4.setValue(oxfordAZVaksin);
        diagramProgressBarVaksin5.setValue(pfizerBTVaksin);
        diagramProgressBarVaksin6.setValue( modernaVaksin);
        diagramProgressBarVaksin7.setValue(sinopharmVaksin);
        diagramProgressBarBooster1.setValue(pfizerBTBooster);
        diagramProgressBarBooster2.setValue(oxfordAZBooster);
        diagramProgressBarBooster3.setValue(modernaBooster);
        jumlahMahasiswaCardVaksin1.setText("" + value.getMahasiswaVaksin1());
        jumlahMahasiswaCardVaksin2.setText("" + value.getMahasiswaVaksin2());
        jumlahMahasiswaCardVaksin3.setText("" + value.getMahasiswaVaksin3());
        jumlahMahasiswaCardVaksin4.setText("" + value.getMahasiswaVaksin4());
        jumlahMahasiswaCardVaksin5.setText("" + value.getMahasiswaVaksin5());
    }
    private int progressAlgoritm(double vaksin){
        double barisTabel = dataTable.getRowCount();
        double pembagian = (vaksin/barisTabel);
        int persentasi = (int) (pembagian * 100);
        return persentasi;
    }
    private void printCard(final JPanel panel){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");
        
        printerJob.setPrintable(new Printable() {

            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                graphics2D.scale(0.6, 0.6);
                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        if (returningResult) {
            try {
                printerJob.print();
            } catch (Exception e) {
                showMessageDialog("Print Error");
            }
        }
    }
    private void fileChooser(String dataType){
        JFileChooser fileChooser = new JFileChooser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date = dateFormat.format(new Date());
        fileChooser.showOpenDialog(this);
        try {
            File save = fileChooser.getSelectedFile();
            String path = save.getAbsolutePath();
            path = path +"_"+date+dataType;
            browseText.setText(path);
        } catch (Exception e) {
            
        }
    }
    public void exportToTXT(){
        String filePath = browseText.getText();
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < dataTable.getRowCount(); i++) {
                for (int j = 0; j < dataTable.getColumnCount(); j++) {
                    bw.write(dataTable.getValueAt(i, j).toString()+" ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(this, bahasa.getMessageError7());
        } catch (IOException | HeadlessException e) {
        }
    }
    public void exportToPDF(){
        MessageFormat footer = new MessageFormat("Halaman {0,number,integer}");
        MessageFormat header = new MessageFormat("Medical Assist Software");
        try {
            dataTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
        }
    }
    public void exportToExcel(){
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet workSheet = workBook.createSheet();
        //TableModel model = dataTable.getModel();
        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        TreeMap<String, Object[] > map = new TreeMap<>();
        map.put("0", new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),
        model.getColumnName(4),model.getColumnName(5),model.getColumnName(6)});
        
        for (int i = 1; i < model.getRowCount(); ) {
            map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),
            model.getValueAt(i, 2),model.getValueAt(i, 3),model.getValueAt(i, 4),model.getValueAt(i, 5),
            model.getValueAt(i, 6)});
            i++;
        }
        Set<String> id = map.keySet();
        XSSFRow fRow;
        int rowId = 0;
        
        for (String key: id) {
            fRow = workSheet.createRow(rowId);
            Object[] value = map.get(key);
            int cellId = 0;
            for(Object object : value){
                XSSFCell cell = fRow.createCell(cellId);
                cell.setCellValue(object.toString());
                cellId++;
            }
            rowId++;
        }
        try(FileOutputStream output = new FileOutputStream(new File(browseText.getText()));) {
            
            workBook.write(output);
            JOptionPane.showMessageDialog(this, bahasa.getMessageError8());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     private void searchData(String input){
        List<userModel> ls = new ArrayList<userModel>();
        ls = new userData().searchData(input);
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
        dataTable.setModel(new DefaultTableModel(DataMahasiswa, new String[]{"NIM",bahasa.getNAMA(),bahasa.getVAKSIN1(),bahasa.getVAKSIN2(),bahasa.getVAKSIN3(),bahasa.getVAKSIN4(),bahasa.getVAKSIN5()}));
    }
    private void showOnlySort(int value){
        List<userModel> ls = new ArrayList<userModel>();
        ls = new userData().showOnly(value);
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
        dataTable.setModel(new DefaultTableModel(DataMahasiswa, new String[]{"NIM",bahasa.getNAMA(),bahasa.getVAKSIN1(),bahasa.getVAKSIN2(),bahasa.getVAKSIN3(),bahasa.getVAKSIN4(),bahasa.getVAKSIN5()}));
    }
    private void centerInformation(int vaksin){
        informationData information = new informationData();
                //Header
                informationImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(information.getVaksin(vaksin, 0))));
                informationVaksinTitle.setText(information.getVaksin(vaksin, 1));
                //Section
                informationJenisVaksin.setText(information.getVaksin(vaksin, 2));
                informationEfikasi.setText(information.getVaksin(vaksin, 3));
                informationDosis.setText(information.getVaksin(vaksin, 4));
                informationUsia.setText(information.getVaksin(vaksin, 5));
                //Footer
                informationVaksin.setText(information.getVaksin(vaksin, 6));
                informationBooster1.setText(information.getVaksin(vaksin, 7));
                informationBooster2.setText(information.getVaksin(vaksin, 8));
                informationBooster3.setText(information.getVaksin(vaksin, 9));
                informationEfektivitas1.setText(information.getVaksin(vaksin, 10));
                informationEfektivitas2.setText(information.getVaksin(vaksin, 11));
                informationEfektivitas3.setText(information.getVaksin(vaksin, 12));
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        DashBoardPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cardVaksin1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cardLabel1 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin1 = new javax.swing.JLabel();
        labelMahasiswa1 = new javax.swing.JLabel();
        vaksin1ProgressBar = new javax.swing.JProgressBar();
        persentasiVaksin1 = new javax.swing.JLabel();
        cardVaksin2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cardLabel2 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin2 = new javax.swing.JLabel();
        labelMahasiswa2 = new javax.swing.JLabel();
        vaksin2ProgressBar = new javax.swing.JProgressBar();
        persentasiVaksin2 = new javax.swing.JLabel();
        cardVaksin3 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cardLabel3 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin3 = new javax.swing.JLabel();
        labelMahasiswa3 = new javax.swing.JLabel();
        vaksin3ProgressBar = new javax.swing.JProgressBar();
        persentasiVaksin3 = new javax.swing.JLabel();
        cardVaksin4 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cardLabel4 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin4 = new javax.swing.JLabel();
        labelMahasiswa4 = new javax.swing.JLabel();
        vaksin4ProgressBar = new javax.swing.JProgressBar();
        persentasiVaksin4 = new javax.swing.JLabel();
        cardVaksin5 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cardLabel5 = new javax.swing.JLabel();
        jumlahMahasiswaCardVaksin5 = new javax.swing.JLabel();
        labelMahasiswa5 = new javax.swing.JLabel();
        vaksin5ProgressBar = new javax.swing.JProgressBar();
        persentasiVaksin5 = new javax.swing.JLabel();
        vaksinDiagram = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        diagramProgressBarVaksin1 = new javax.swing.JProgressBar();
        diagramProgressBaVaksinr2 = new javax.swing.JProgressBar();
        diagramProgressBarVaksin3 = new javax.swing.JProgressBar();
        diagramProgressBarVaksin4 = new javax.swing.JProgressBar();
        diagramProgressBarVaksin5 = new javax.swing.JProgressBar();
        diagramProgressBarVaksin6 = new javax.swing.JProgressBar();
        diagramProgressBarVaksin7 = new javax.swing.JProgressBar();
        diagramMaxValueVaksin = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        diagramHalfMaxValueVaksin = new javax.swing.JLabel();
        diagramHalfMaxValue2 = new javax.swing.JLabel();
        diagramHalfMaxValue3 = new javax.swing.JLabel();
        diagramHalfMaxValue4 = new javax.swing.JLabel();
        diagramHalfMaxValue1 = new javax.swing.JLabel();
        diagramHalfMaxValue5 = new javax.swing.JLabel();
        diagramHalfMaxValue7 = new javax.swing.JLabel();
        diagramHalfMaxValue6 = new javax.swing.JLabel();
        diagramLabel1 = new javax.swing.JLabel();
        boosterDiagram = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        diagramHalfMaxValue10 = new javax.swing.JLabel();
        diagramProgressBarBooster3 = new javax.swing.JProgressBar();
        diagramHalfMaxValue11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        diagramHalfMaxValueBooster = new javax.swing.JLabel();
        diagramProgressBarBooster2 = new javax.swing.JProgressBar();
        diagramMaxValueBooster = new javax.swing.JLabel();
        diagramProgressBarBooster1 = new javax.swing.JProgressBar();
        diagramHalfMaxValue12 = new javax.swing.JLabel();
        diagramLabel2 = new javax.swing.JLabel();
        cardVaksin6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cardVaksinImage1 = new javax.swing.JLabel();
        cardTitle1 = new javax.swing.JLabel();
        cardVaksinValue1 = new javax.swing.JLabel();
        cardVaksin7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        cardVaksinImage2 = new javax.swing.JLabel();
        cardTitle2 = new javax.swing.JLabel();
        cardVaksinValue2 = new javax.swing.JLabel();
        cardVaksin8 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        cardVaksinImage3 = new javax.swing.JLabel();
        cardTitle3 = new javax.swing.JLabel();
        cardVaksinValue3 = new javax.swing.JLabel();
        cardVaksin9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        cardVaksinImage4 = new javax.swing.JLabel();
        cardTitle4 = new javax.swing.JLabel();
        cardVaksinValue4 = new javax.swing.JLabel();
        cardVaksin10 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        cardVaksinImage5 = new javax.swing.JLabel();
        cardTitle5 = new javax.swing.JLabel();
        cardVaksinValue5 = new javax.swing.JLabel();
        cardVaksin11 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        cardVaksinImage6 = new javax.swing.JLabel();
        cardTitle6 = new javax.swing.JLabel();
        cardVaksinValue6 = new javax.swing.JLabel();
        cardVaksin12 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        cardVaksinImage7 = new javax.swing.JLabel();
        cardTitle7 = new javax.swing.JLabel();
        cardVaksinValue7 = new javax.swing.JLabel();
        cardBooster1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        cardBoosterImage1 = new javax.swing.JLabel();
        boosterTitle1 = new javax.swing.JLabel();
        boosterCardValue1 = new javax.swing.JLabel();
        cardBooster3 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        cardBoosterImage3 = new javax.swing.JLabel();
        boosterTitle3 = new javax.swing.JLabel();
        boosterCardValue3 = new javax.swing.JLabel();
        cardBooster2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        cardBoosterImage2 = new javax.swing.JLabel();
        boosterTitle2 = new javax.swing.JLabel();
        boosterCardValue2 = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        dataLabel1 = new javax.swing.JLabel();
        dataLabel2 = new javax.swing.JLabel();
        dataLabel3 = new javax.swing.JLabel();
        dataLabel4 = new javax.swing.JLabel();
        dataLabel5 = new javax.swing.JLabel();
        dataLabel6 = new javax.swing.JLabel();
        dataLabel7 = new javax.swing.JLabel();
        simpanPanel = new javax.swing.JPanel();
        simpanButton = new javax.swing.JButton();
        hapusPanel = new javax.swing.JPanel();
        hapusButton = new javax.swing.JButton();
        gantiPanel = new javax.swing.JPanel();
        gantiButton = new javax.swing.JButton();
        tambahPanel = new javax.swing.JPanel();
        tambahButton = new javax.swing.JButton();
        showComboBox = new javax.swing.JComboBox();
        searchTextField = new javax.swing.JTextField();
        exportComboBox = new javax.swing.JComboBox();
        exportPanel = new javax.swing.JPanel();
        exportButton = new javax.swing.JButton();
        browsePanel = new javax.swing.JPanel();
        browseButton = new javax.swing.JButton();
        browseText = new javax.swing.JTextField();
        searchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        hiddenPanel = new javax.swing.JPanel();
        vaksinCardPrint = new javax.swing.JPanel();
        vaksinCardPrint1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        vaksin1CardPrint = new javax.swing.JLabel();
        vaksin2CardPrint = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        booster1CardPrint = new javax.swing.JLabel();
        booster2CardPrint = new javax.swing.JLabel();
        booster3CardPrint = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nimCardPrint = new javax.swing.JLabel();
        namaCardPrint = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        InformationPanel = new javax.swing.JPanel();
        centerInformationPanel = new javax.swing.JPanel();
        informationPanel = new javax.swing.JPanel();
        informationImage = new javax.swing.JLabel();
        informationVaksinTitle = new javax.swing.JLabel();
        informationJenisLabel = new javax.swing.JLabel();
        informationEfikasiLabel = new javax.swing.JLabel();
        informationDosisLabel = new javax.swing.JLabel();
        informationUsiaLabel = new javax.swing.JLabel();
        informationTitle1 = new javax.swing.JLabel();
        informationSeparator = new javax.swing.JSeparator();
        informationTitle2 = new javax.swing.JLabel();
        informationTitle3 = new javax.swing.JLabel();
        informationVaksin = new javax.swing.JLabel();
        informationBooster1 = new javax.swing.JLabel();
        informationBooster2 = new javax.swing.JLabel();
        informationBooster3 = new javax.swing.JLabel();
        informationEfektivitas1 = new javax.swing.JLabel();
        informationEfektivitas2 = new javax.swing.JLabel();
        informationEfektivitas3 = new javax.swing.JLabel();
        informationJenisVaksin = new javax.swing.JLabel();
        informationEfikasi = new javax.swing.JLabel();
        informationDosis = new javax.swing.JLabel();
        informationUsia = new javax.swing.JLabel();
        informationPanel1 = new javax.swing.JPanel();
        sinovacInformationButton = new javax.swing.JButton();
        informationPanel2 = new javax.swing.JPanel();
        sputnikInformationButton = new javax.swing.JButton();
        informationPanel3 = new javax.swing.JPanel();
        novavaxInformationButton = new javax.swing.JButton();
        informationPanel4 = new javax.swing.JPanel();
        astrazenecaInformationButton = new javax.swing.JButton();
        informationPanel5 = new javax.swing.JPanel();
        pfizerInformationButton = new javax.swing.JButton();
        informationPanel6 = new javax.swing.JPanel();
        modernaInformationButton = new javax.swing.JButton();
        informationPanel7 = new javax.swing.JPanel();
        sinopharmInformationButton = new javax.swing.JButton();
        AboutPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        bahasaComboBox = new javax.swing.JComboBox();
        centerAboutPage = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        cardAbout1 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        cardAbout2 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        cardAbout3 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        cardAbout4 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        dashboardButton = new javax.swing.JButton();
        dataButton = new javax.swing.JButton();
        otherButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        informationButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel20)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel20)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medical Assist Software");
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

        cardLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardLabel1.setForeground(new java.awt.Color(102, 102, 102));
        cardLabel1.setText("Vaccine - 1");

        jumlahMahasiswaCardVaksin1.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin1.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin1.setText("0");

        labelMahasiswa1.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        labelMahasiswa1.setForeground(new java.awt.Color(102, 102, 102));
        labelMahasiswa1.setText("Mahasiswa");

        vaksin1ProgressBar.setForeground(new java.awt.Color(91, 124, 253));
        vaksin1ProgressBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        persentasiVaksin1.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        persentasiVaksin1.setForeground(new java.awt.Color(91, 124, 253));
        persentasiVaksin1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persentasiVaksin1.setText("100%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vaksin1ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jumlahMahasiswaCardVaksin1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMahasiswa1))
                            .addComponent(cardLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(persentasiVaksin1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cardLabel1)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlahMahasiswaCardVaksin1)
                            .addComponent(labelMahasiswa1)
                            .addComponent(persentasiVaksin1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vaksin1ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 11, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        javax.swing.GroupLayout cardVaksin1Layout = new javax.swing.GroupLayout(cardVaksin1);
        cardVaksin1.setLayout(cardVaksin1Layout);
        cardVaksin1Layout.setHorizontalGroup(
            cardVaksin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin1Layout.setVerticalGroup(
            cardVaksin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardVaksin1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        cardVaksin2.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin2.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin2.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel2.setBackground(new java.awt.Color(208, 231, 251));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/vaksinIcon.png"))); // NOI18N

        cardLabel2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardLabel2.setForeground(new java.awt.Color(102, 102, 102));
        cardLabel2.setText("Vaccine - 2");

        jumlahMahasiswaCardVaksin2.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin2.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin2.setText("0");

        labelMahasiswa2.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        labelMahasiswa2.setForeground(new java.awt.Color(102, 102, 102));
        labelMahasiswa2.setText("Mahasiswa");

        vaksin2ProgressBar.setForeground(new java.awt.Color(91, 124, 253));
        vaksin2ProgressBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        persentasiVaksin2.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        persentasiVaksin2.setForeground(new java.awt.Color(91, 124, 253));
        persentasiVaksin2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persentasiVaksin2.setText("100%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vaksin2ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cardLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMahasiswa2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(persentasiVaksin2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cardLabel2)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin2)
                    .addComponent(labelMahasiswa2)
                    .addComponent(persentasiVaksin2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin2ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout cardVaksin2Layout = new javax.swing.GroupLayout(cardVaksin2);
        cardVaksin2.setLayout(cardVaksin2Layout);
        cardVaksin2Layout.setHorizontalGroup(
            cardVaksin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin2Layout.setVerticalGroup(
            cardVaksin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin3.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin3.setMaximumSize(new java.awt.Dimension(186, 100));
        cardVaksin3.setPreferredSize(new java.awt.Dimension(240, 100));

        jPanel3.setBackground(new java.awt.Color(208, 231, 251));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/boosterIcon.png"))); // NOI18N

        cardLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardLabel3.setForeground(new java.awt.Color(102, 102, 102));
        cardLabel3.setText("Booster - 1");

        jumlahMahasiswaCardVaksin3.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin3.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin3.setText("0");

        labelMahasiswa3.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        labelMahasiswa3.setForeground(new java.awt.Color(102, 102, 102));
        labelMahasiswa3.setText("Mahasiswa");

        vaksin3ProgressBar.setForeground(new java.awt.Color(91, 124, 253));
        vaksin3ProgressBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        persentasiVaksin3.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        persentasiVaksin3.setForeground(new java.awt.Color(91, 124, 253));
        persentasiVaksin3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persentasiVaksin3.setText("100%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vaksin3ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cardLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMahasiswa3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(persentasiVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cardLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin3)
                    .addComponent(labelMahasiswa3)
                    .addComponent(persentasiVaksin3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin3ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        cardLabel4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardLabel4.setForeground(new java.awt.Color(102, 102, 102));
        cardLabel4.setText("Booster - 2");

        jumlahMahasiswaCardVaksin4.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin4.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin4.setText("0");

        labelMahasiswa4.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        labelMahasiswa4.setForeground(new java.awt.Color(102, 102, 102));
        labelMahasiswa4.setText("Mahasiswa");

        vaksin4ProgressBar.setForeground(new java.awt.Color(91, 124, 253));
        vaksin4ProgressBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        persentasiVaksin4.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        persentasiVaksin4.setForeground(new java.awt.Color(91, 124, 253));
        persentasiVaksin4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persentasiVaksin4.setText("100%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cardLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(vaksin4ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMahasiswa4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(persentasiVaksin4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cardLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin4)
                    .addComponent(labelMahasiswa4)
                    .addComponent(persentasiVaksin4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin4ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout cardVaksin4Layout = new javax.swing.GroupLayout(cardVaksin4);
        cardVaksin4.setLayout(cardVaksin4Layout);
        cardVaksin4Layout.setHorizontalGroup(
            cardVaksin4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
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

        cardLabel5.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardLabel5.setForeground(new java.awt.Color(102, 102, 102));
        cardLabel5.setText("Booster - 3");

        jumlahMahasiswaCardVaksin5.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jumlahMahasiswaCardVaksin5.setForeground(new java.awt.Color(102, 102, 102));
        jumlahMahasiswaCardVaksin5.setText("0");

        labelMahasiswa5.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        labelMahasiswa5.setForeground(new java.awt.Color(102, 102, 102));
        labelMahasiswa5.setText("Mahasiswa");

        vaksin5ProgressBar.setForeground(new java.awt.Color(91, 124, 253));
        vaksin5ProgressBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        persentasiVaksin5.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        persentasiVaksin5.setForeground(new java.awt.Color(91, 124, 253));
        persentasiVaksin5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        persentasiVaksin5.setText("100%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cardLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jumlahMahasiswaCardVaksin5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMahasiswa5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(persentasiVaksin5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vaksin5ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(cardLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahMahasiswaCardVaksin5)
                    .addComponent(labelMahasiswa5)
                    .addComponent(persentasiVaksin5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaksin5ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        diagramProgressBarVaksin1.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin1.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin1.setOrientation(1);
        diagramProgressBarVaksin1.setBorderPainted(false);

        diagramProgressBaVaksinr2.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBaVaksinr2.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBaVaksinr2.setOrientation(1);
        diagramProgressBaVaksinr2.setBorderPainted(false);

        diagramProgressBarVaksin3.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin3.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin3.setOrientation(1);
        diagramProgressBarVaksin3.setBorderPainted(false);

        diagramProgressBarVaksin4.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin4.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin4.setOrientation(1);
        diagramProgressBarVaksin4.setBorderPainted(false);

        diagramProgressBarVaksin5.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin5.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin5.setOrientation(1);
        diagramProgressBarVaksin5.setBorderPainted(false);

        diagramProgressBarVaksin6.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin6.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin6.setOrientation(1);
        diagramProgressBarVaksin6.setBorderPainted(false);

        diagramProgressBarVaksin7.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarVaksin7.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarVaksin7.setOrientation(1);
        diagramProgressBarVaksin7.setBorderPainted(false);

        diagramMaxValueVaksin.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramMaxValueVaksin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramMaxValueVaksin.setText("100");

        jLabel23.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("0");

        diagramHalfMaxValueVaksin.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValueVaksin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValueVaksin.setText("50");

        diagramHalfMaxValue2.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue2.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue2.setText("Sinovac");

        diagramHalfMaxValue3.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue3.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue3.setText("Sputnik V");

        diagramHalfMaxValue4.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue4.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue4.setText("Novovax");

        diagramHalfMaxValue1.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue1.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue1.setText("OxfordAZ");

        diagramHalfMaxValue5.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue5.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue5.setText("PfizerBT");

        diagramHalfMaxValue7.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue7.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue7.setText("Moderna");

        diagramHalfMaxValue6.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue6.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue6.setText("Sinopharm");

        diagramLabel1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        diagramLabel1.setForeground(new java.awt.Color(102, 102, 102));
        diagramLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramLabel1.setText("Vaccine");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(diagramLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(diagramMaxValueVaksin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(diagramHalfMaxValueVaksin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diagramHalfMaxValue2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(diagramProgressBarVaksin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(diagramProgressBaVaksinr2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diagramProgressBarVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(diagramHalfMaxValue3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diagramHalfMaxValue4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diagramHalfMaxValue1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(diagramProgressBarVaksin4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diagramProgressBarVaksin5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diagramHalfMaxValue5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diagramHalfMaxValue7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(diagramProgressBarVaksin6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diagramProgressBarVaksin7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diagramHalfMaxValue6))
                        .addGap(51, 51, 51))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(diagramLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(diagramProgressBarVaksin7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBarVaksin6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBarVaksin5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBarVaksin4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBarVaksin3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBaVaksinr2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(diagramProgressBarVaksin1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(diagramMaxValueVaksin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diagramHalfMaxValueVaksin)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagramHalfMaxValue2)
                    .addComponent(diagramHalfMaxValue3)
                    .addComponent(diagramHalfMaxValue4)
                    .addComponent(diagramHalfMaxValue1)
                    .addComponent(diagramHalfMaxValue5)
                    .addComponent(diagramHalfMaxValue7)
                    .addComponent(diagramHalfMaxValue6))
                .addGap(9, 9, 9))
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

        diagramHalfMaxValue10.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue10.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue10.setText("Moderna");

        diagramProgressBarBooster3.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarBooster3.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarBooster3.setOrientation(1);
        diagramProgressBarBooster3.setBorderPainted(false);

        diagramHalfMaxValue11.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue11.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue11.setText("Oxford-AstraZeneca");

        jLabel24.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("0");

        diagramHalfMaxValueBooster.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValueBooster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValueBooster.setText("50");

        diagramProgressBarBooster2.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarBooster2.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarBooster2.setOrientation(1);
        diagramProgressBarBooster2.setBorderPainted(false);

        diagramMaxValueBooster.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramMaxValueBooster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramMaxValueBooster.setText("100");

        diagramProgressBarBooster1.setBackground(new java.awt.Color(208, 231, 251));
        diagramProgressBarBooster1.setForeground(new java.awt.Color(91, 124, 253));
        diagramProgressBarBooster1.setOrientation(1);
        diagramProgressBarBooster1.setBorderPainted(false);

        diagramHalfMaxValue12.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        diagramHalfMaxValue12.setForeground(new java.awt.Color(91, 124, 253));
        diagramHalfMaxValue12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramHalfMaxValue12.setText("Plizer-BioNTech");

        diagramLabel2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        diagramLabel2.setForeground(new java.awt.Color(102, 102, 102));
        diagramLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        diagramLabel2.setText("Booster");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(diagramMaxValueBooster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(diagramHalfMaxValueBooster, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diagramHalfMaxValue12, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(diagramProgressBarBooster1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(diagramProgressBarBooster2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(diagramProgressBarBooster3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(diagramHalfMaxValue11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diagramHalfMaxValue10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(diagramLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(diagramLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(diagramProgressBarBooster3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagramProgressBarBooster2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(diagramProgressBarBooster1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(diagramMaxValueBooster)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diagramHalfMaxValueBooster)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel24))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diagramHalfMaxValue12)
                    .addComponent(diagramHalfMaxValue11)
                    .addComponent(diagramHalfMaxValue10))
                .addContainerGap())
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

        cardVaksin6.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin6.setPreferredSize(new java.awt.Dimension(130, 200));

        jPanel7.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle1.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle1.setText("Vaccine");

        cardVaksinValue1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue1.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue1.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage1)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(cardTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardVaksinValue1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage1)
                .addGap(18, 18, 18)
                .addComponent(cardTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin6Layout = new javax.swing.GroupLayout(cardVaksin6);
        cardVaksin6.setLayout(cardVaksin6Layout);
        cardVaksin6Layout.setHorizontalGroup(
            cardVaksin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardVaksin6Layout.setVerticalGroup(
            cardVaksin6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin7.setBackground(new java.awt.Color(245, 246, 251));
        cardVaksin7.setPreferredSize(new java.awt.Dimension(130, 0));

        jPanel14.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle2.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle2.setText("Vaccine");

        cardVaksinValue2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue2.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue2.setText("0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage2)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(cardTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardVaksinValue2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage2)
                .addGap(18, 18, 18)
                .addComponent(cardTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin7Layout = new javax.swing.GroupLayout(cardVaksin7);
        cardVaksin7.setLayout(cardVaksin7Layout);
        cardVaksin7Layout.setHorizontalGroup(
            cardVaksin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin7Layout.setVerticalGroup(
            cardVaksin7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin8.setPreferredSize(new java.awt.Dimension(130, 0));

        jPanel15.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle3.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle3.setText("Vaccine");

        cardVaksinValue3.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue3.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue3.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage3)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(cardTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(cardVaksinValue3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage3)
                .addGap(18, 18, 18)
                .addComponent(cardTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin8Layout = new javax.swing.GroupLayout(cardVaksin8);
        cardVaksin8.setLayout(cardVaksin8Layout);
        cardVaksin8Layout.setHorizontalGroup(
            cardVaksin8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin8Layout.setVerticalGroup(
            cardVaksin8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin9.setPreferredSize(new java.awt.Dimension(130, 0));

        jPanel16.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle4.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle4.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle4.setText("Vaccine");

        cardVaksinValue4.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue4.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue4.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cardTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(cardVaksinValue4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage4)
                .addGap(18, 18, 18)
                .addComponent(cardTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin9Layout = new javax.swing.GroupLayout(cardVaksin9);
        cardVaksin9.setLayout(cardVaksin9Layout);
        cardVaksin9Layout.setHorizontalGroup(
            cardVaksin9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin9Layout.setVerticalGroup(
            cardVaksin9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin10.setPreferredSize(new java.awt.Dimension(130, 0));

        jPanel17.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle5.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle5.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle5.setText("Vaccine");

        cardVaksinValue5.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue5.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue5.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cardTitle5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardVaksinValue5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage5)
                .addGap(18, 18, 18)
                .addComponent(cardTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin10Layout = new javax.swing.GroupLayout(cardVaksin10);
        cardVaksin10.setLayout(cardVaksin10Layout);
        cardVaksin10Layout.setHorizontalGroup(
            cardVaksin10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin10Layout.setVerticalGroup(
            cardVaksin10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin11.setPreferredSize(new java.awt.Dimension(130, 200));

        jPanel18.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle6.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle6.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle6.setText("Vaccine");

        cardVaksinValue6.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue6.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue6.setText("0");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cardTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(cardVaksinValue6, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage6)
                .addGap(18, 18, 18)
                .addComponent(cardTitle6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin11Layout = new javax.swing.GroupLayout(cardVaksin11);
        cardVaksin11.setLayout(cardVaksin11Layout);
        cardVaksin11Layout.setHorizontalGroup(
            cardVaksin11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin11Layout.setVerticalGroup(
            cardVaksin11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardVaksin12.setPreferredSize(new java.awt.Dimension(130, 200));

        jPanel19.setBackground(new java.awt.Color(208, 231, 251));

        cardVaksinImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        cardTitle7.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        cardTitle7.setForeground(new java.awt.Color(102, 102, 102));
        cardTitle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardTitle7.setText("Vaccine");

        cardVaksinValue7.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        cardVaksinValue7.setForeground(new java.awt.Color(102, 102, 102));
        cardVaksinValue7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardVaksinValue7.setText("0");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cardTitle7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(cardVaksinValue7, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardVaksinImage7)
                .addGap(18, 18, 18)
                .addComponent(cardTitle7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardVaksinValue7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardVaksin12Layout = new javax.swing.GroupLayout(cardVaksin12);
        cardVaksin12.setLayout(cardVaksin12Layout);
        cardVaksin12Layout.setHorizontalGroup(
            cardVaksin12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardVaksin12Layout.setVerticalGroup(
            cardVaksin12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardBooster1.setPreferredSize(new java.awt.Dimension(0, 60));

        jPanel12.setBackground(new java.awt.Color(208, 231, 251));

        cardBoosterImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modernaCard.png"))); // NOI18N

        boosterTitle1.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        boosterTitle1.setForeground(new java.awt.Color(102, 102, 102));
        boosterTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterTitle1.setText("Booster");

        boosterCardValue1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        boosterCardValue1.setForeground(new java.awt.Color(102, 102, 102));
        boosterCardValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterCardValue1.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(cardBoosterImage1)
                .addGap(18, 18, 18)
                .addComponent(boosterTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boosterCardValue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardBoosterImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boosterTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boosterCardValue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardBooster1Layout = new javax.swing.GroupLayout(cardBooster1);
        cardBooster1.setLayout(cardBooster1Layout);
        cardBooster1Layout.setHorizontalGroup(
            cardBooster1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardBooster1Layout.setVerticalGroup(
            cardBooster1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBooster1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardBooster3.setPreferredSize(new java.awt.Dimension(90, 60));

        jPanel20.setBackground(new java.awt.Color(208, 231, 251));
        jPanel20.setPreferredSize(new java.awt.Dimension(320, 60));

        cardBoosterImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modernaCard.png"))); // NOI18N
        cardBoosterImage3.setPreferredSize(new java.awt.Dimension(90, 60));

        boosterTitle3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        boosterTitle3.setForeground(new java.awt.Color(102, 102, 102));
        boosterTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterTitle3.setText("Booster");
        boosterTitle3.setPreferredSize(new java.awt.Dimension(61, 60));

        boosterCardValue3.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        boosterCardValue3.setForeground(new java.awt.Color(102, 102, 102));
        boosterCardValue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterCardValue3.setText("0");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(cardBoosterImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boosterTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boosterCardValue3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardBoosterImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boosterTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boosterCardValue3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardBooster3Layout = new javax.swing.GroupLayout(cardBooster3);
        cardBooster3.setLayout(cardBooster3Layout);
        cardBooster3Layout.setHorizontalGroup(
            cardBooster3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardBooster3Layout.setVerticalGroup(
            cardBooster3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardBooster2.setPreferredSize(new java.awt.Dimension(0, 60));

        jPanel13.setBackground(new java.awt.Color(208, 231, 251));

        cardBoosterImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modernaCard.png"))); // NOI18N

        boosterTitle2.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        boosterTitle2.setForeground(new java.awt.Color(102, 102, 102));
        boosterTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterTitle2.setText("Booster");

        boosterCardValue2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        boosterCardValue2.setForeground(new java.awt.Color(102, 102, 102));
        boosterCardValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boosterCardValue2.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(cardBoosterImage2)
                .addGap(18, 18, 18)
                .addComponent(boosterTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boosterCardValue2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(boosterTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(cardBoosterImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(boosterCardValue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cardBooster2Layout = new javax.swing.GroupLayout(cardBooster2);
        cardBooster2.setLayout(cardBooster2Layout);
        cardBooster2Layout.setHorizontalGroup(
            cardBooster2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardBooster2Layout.setVerticalGroup(
            cardBooster2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashBoardPanelLayout = new javax.swing.GroupLayout(DashBoardPanel);
        DashBoardPanel.setLayout(DashBoardPanelLayout);
        DashBoardPanelLayout.setHorizontalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardVaksin5, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(cardVaksin4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cardVaksin1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(cardVaksin2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(cardVaksin3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(cardVaksin6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardVaksin12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(vaksinDiagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boosterDiagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardBooster1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(cardBooster3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(cardBooster2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        DashBoardPanelLayout.setVerticalGroup(
            DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(cardVaksin1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addComponent(vaksinDiagram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boosterDiagram, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addComponent(cardVaksin3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cardVaksin5, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(DashBoardPanelLayout.createSequentialGroup()
                        .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cardVaksin12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardVaksin11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardVaksin6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardVaksin7, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cardVaksin8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cardVaksin9, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cardVaksin10, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DashBoardPanelLayout.createSequentialGroup()
                                .addComponent(cardBooster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cardBooster2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cardBooster3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        dataTable.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        dataTable.setForeground(new java.awt.Color(91, 123, 253));
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
        dataTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataTable.setFocusable(false);
        dataTable.setGridColor(new java.awt.Color(91, 123, 253));
        dataTable.setRowHeight(25);
        dataTable.setRowMargin(0);
        dataTable.setShowVerticalLines(false);
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        tabelScroll.setViewportView(dataTable);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/footerImage2.png"))); // NOI18N

        dataLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel1.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel1.setText("NIM");

        dataLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel2.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel2.setText("Nama");

        dataLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel3.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel3.setText("Vaksin - 1");

        dataLabel4.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel4.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel4.setText("Vaksin - 2");

        dataLabel5.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel5.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel5.setText("Booster - 1");

        dataLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel6.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel6.setText("Booster - 2");

        dataLabel7.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        dataLabel7.setForeground(new java.awt.Color(40, 159, 217));
        dataLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataLabel7.setText("Booster - 3");

        simpanPanel.setBackground(new java.awt.Color(245, 246, 251));

        simpanButton.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        simpanButton.setForeground(new java.awt.Color(91, 123, 253));
        simpanButton.setText("Simpan");
        simpanButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        simpanButton.setContentAreaFilled(false);
        simpanButton.setFocusable(false);
        simpanButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        simpanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanButtonMouseExited(evt);
            }
        });
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout simpanPanelLayout = new javax.swing.GroupLayout(simpanPanel);
        simpanPanel.setLayout(simpanPanelLayout);
        simpanPanelLayout.setHorizontalGroup(
            simpanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simpanPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        simpanPanelLayout.setVerticalGroup(
            simpanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpanButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        hapusPanel.setBackground(new java.awt.Color(245, 246, 251));
        hapusPanel.setPreferredSize(new java.awt.Dimension(100, 45));

        hapusButton.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        hapusButton.setForeground(new java.awt.Color(91, 123, 253));
        hapusButton.setText("Hapus");
        hapusButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        hapusButton.setContentAreaFilled(false);
        hapusButton.setFocusable(false);
        hapusButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hapusButtonMouseExited(evt);
            }
        });
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hapusPanelLayout = new javax.swing.GroupLayout(hapusPanel);
        hapusPanel.setLayout(hapusPanelLayout);
        hapusPanelLayout.setHorizontalGroup(
            hapusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hapusPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(hapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        hapusPanelLayout.setVerticalGroup(
            hapusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hapusButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        gantiPanel.setBackground(new java.awt.Color(245, 246, 251));
        gantiPanel.setPreferredSize(new java.awt.Dimension(100, 45));

        gantiButton.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        gantiButton.setForeground(new java.awt.Color(91, 123, 253));
        gantiButton.setText("Ganti");
        gantiButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gantiButton.setContentAreaFilled(false);
        gantiButton.setFocusable(false);
        gantiButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gantiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gantiButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gantiButtonMouseExited(evt);
            }
        });
        gantiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gantiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gantiPanelLayout = new javax.swing.GroupLayout(gantiPanel);
        gantiPanel.setLayout(gantiPanelLayout);
        gantiPanelLayout.setHorizontalGroup(
            gantiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gantiPanelLayout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(gantiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        gantiPanelLayout.setVerticalGroup(
            gantiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gantiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        tambahPanel.setBackground(new java.awt.Color(245, 246, 251));
        tambahPanel.setPreferredSize(new java.awt.Dimension(100, 45));

        tambahButton.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        tambahButton.setForeground(new java.awt.Color(91, 123, 253));
        tambahButton.setText("Tambah");
        tambahButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tambahButton.setContentAreaFilled(false);
        tambahButton.setFocusable(false);
        tambahButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tambahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahButtonMouseExited(evt);
            }
        });
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tambahPanelLayout = new javax.swing.GroupLayout(tambahPanel);
        tambahPanel.setLayout(tambahPanelLayout);
        tambahPanelLayout.setHorizontalGroup(
            tambahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahPanelLayout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tambahPanelLayout.setVerticalGroup(
            tambahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tambahButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        showComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        showComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show All", "Show Vaccine 1", "Show Vaccine 2", "Show Booster 1", "Show Booster 2", "Show Booster 3" }));
        showComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showComboBoxActionPerformed(evt);
            }
        });

        searchTextField.setText("Search");
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });

        exportComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        exportComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Export PDF", "Export Excel", "Export Txt", "Export Card(PDF)" }));

        exportPanel.setPreferredSize(new java.awt.Dimension(137, 30));

        exportButton.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        exportButton.setForeground(new java.awt.Color(91, 123, 253));
        exportButton.setText("Export");
        exportButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exportButton.setContentAreaFilled(false);
        exportButton.setFocusable(false);
        exportButton.setPreferredSize(new java.awt.Dimension(111, 30));
        exportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportButtonMouseExited(evt);
            }
        });
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exportPanelLayout = new javax.swing.GroupLayout(exportPanel);
        exportPanel.setLayout(exportPanelLayout);
        exportPanelLayout.setHorizontalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        exportPanelLayout.setVerticalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        browsePanel.setPreferredSize(new java.awt.Dimension(131, 30));

        browseButton.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        browseButton.setForeground(new java.awt.Color(91, 123, 253));
        browseButton.setText("Browse");
        browseButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        browseButton.setContentAreaFilled(false);
        browseButton.setFocusable(false);
        browseButton.setPreferredSize(new java.awt.Dimension(111, 30));
        browseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseButtonMouseExited(evt);
            }
        });
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout browsePanelLayout = new javax.swing.GroupLayout(browsePanel);
        browsePanel.setLayout(browsePanelLayout);
        browsePanelLayout.setHorizontalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browsePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        browsePanelLayout.setVerticalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        browseText.setEditable(false);

        searchButton.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(91, 123, 253));
        searchButton.setText("Search");
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusable(false);
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButtonMouseExited(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nimTextField)
                            .addComponent(vaksin1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(vaksin2TextField)
                            .addComponent(vaksin3TextField)
                            .addComponent(vaksin4TextField)
                            .addComponent(vaksin5TextField)
                            .addComponent(namaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPanelLayout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tambahPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(gantiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(hapusPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(simpanPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(40, 40, 40)))
                .addGap(28, 28, 28)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseText, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browsePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(exportPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(exportComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(17, 17, 17))
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField)
                        .addGap(18, 18, 18))
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1))
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DataPanelLayout.createSequentialGroup()
                        .addComponent(namaTextField)
                        .addGap(1, 1, 1)))
                .addGap(17, 17, 17)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaksin5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(simpanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hapusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gantiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambahPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vaksinCardPrint.setBackground(new java.awt.Color(0, 0, 0));

        vaksinCardPrint1.setBackground(new java.awt.Color(216, 26, 96));
        vaksinCardPrint1.setPreferredSize(new java.awt.Dimension(800, 400));
        vaksinCardPrint1.setRequestFocusEnabled(false);
        vaksinCardPrint1.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Kartu Vaksinasi");

        jLabel5.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NIM");

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NAMA");

        jLabel7.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DOSIS");

        jLabel8.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("JENIS VAKSIN");

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VALIDASI");

        jLabel10.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("I");

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("II");

        vaksin1CardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        vaksin1CardPrint.setForeground(new java.awt.Color(255, 255, 255));
        vaksin1CardPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vaksin1CardPrint.setText("VAKSIN 1");

        vaksin2CardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        vaksin2CardPrint.setForeground(new java.awt.Color(255, 255, 255));
        vaksin2CardPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vaksin2CardPrint.setText("VAKSIN 2");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(216, 26, 96));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("DOSIS");

        jLabel22.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(216, 26, 96));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("STATUS PEMBERIAN BOOSTER");

        jLabel25.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(216, 26, 96));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("I");

        jLabel26.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(216, 26, 96));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("II");

        jLabel27.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(216, 26, 96));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("III");

        jLabel28.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(216, 26, 96));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("JENIS BOOSTER");

        jLabel29.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(216, 26, 96));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("VALIDASI");

        booster1CardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        booster1CardPrint.setForeground(new java.awt.Color(216, 26, 96));
        booster1CardPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booster1CardPrint.setText("DOSIS - 1");

        booster2CardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        booster2CardPrint.setForeground(new java.awt.Color(216, 26, 96));
        booster2CardPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booster2CardPrint.setText("DOSIS - 2");

        booster3CardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        booster3CardPrint.setForeground(new java.awt.Color(216, 26, 96));
        booster3CardPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booster3CardPrint.setText("DOSIS - 3");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printImage1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booster3CardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booster2CardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booster1CardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(booster1CardPrint))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(booster2CardPrint))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(booster3CardPrint))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(jLabel2))))
        );

        nimCardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        nimCardPrint.setForeground(new java.awt.Color(255, 255, 255));
        nimCardPrint.setText("NIM USER");

        namaCardPrint.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        namaCardPrint.setForeground(new java.awt.Color(255, 255, 255));
        namaCardPrint.setText("NAMA USER");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printImage2.png"))); // NOI18N

        javax.swing.GroupLayout vaksinCardPrint1Layout = new javax.swing.GroupLayout(vaksinCardPrint1);
        vaksinCardPrint1.setLayout(vaksinCardPrint1Layout);
        vaksinCardPrint1Layout.setHorizontalGroup(
            vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                        .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nimCardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaCardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                        .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vaksin2CardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vaksin1CardPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaksinCardPrint1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(183, 183, 183))
            .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaksinCardPrint1Layout.createSequentialGroup()
                    .addContainerGap(366, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addContainerGap()))
        );
        vaksinCardPrint1Layout.setVerticalGroup(
            vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nimCardPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(namaCardPrint))
                .addGap(18, 18, 18)
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(vaksin1CardPrint))
                .addGap(18, 18, 18)
                .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(vaksin2CardPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(vaksinCardPrint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(vaksinCardPrint1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel18)
                    .addContainerGap(419, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout vaksinCardPrintLayout = new javax.swing.GroupLayout(vaksinCardPrint);
        vaksinCardPrint.setLayout(vaksinCardPrintLayout);
        vaksinCardPrintLayout.setHorizontalGroup(
            vaksinCardPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
            .addGroup(vaksinCardPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(vaksinCardPrintLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(vaksinCardPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        vaksinCardPrintLayout.setVerticalGroup(
            vaksinCardPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(vaksinCardPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(vaksinCardPrintLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(vaksinCardPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout hiddenPanelLayout = new javax.swing.GroupLayout(hiddenPanel);
        hiddenPanel.setLayout(hiddenPanelLayout);
        hiddenPanelLayout.setHorizontalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hiddenPanelLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(vaksinCardPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        hiddenPanelLayout.setVerticalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hiddenPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(vaksinCardPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        InformationPanel.setBackground(new java.awt.Color(245, 246, 251));

        centerInformationPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerInformationPanel.setPreferredSize(new java.awt.Dimension(300, 440));

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));

        informationImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sinovacCard.png"))); // NOI18N

        informationVaksinTitle.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        informationVaksinTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationVaksinTitle.setText("VACCINE");

        informationJenisLabel.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationJenisLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationJenisLabel.setText(" Jenis");

        informationEfikasiLabel.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationEfikasiLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationEfikasiLabel.setText(" Efikasi*");

        informationDosisLabel.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationDosisLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationDosisLabel.setText(" Dosis");

        informationUsiaLabel.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationUsiaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationUsiaLabel.setText(" Usia");

        informationTitle1.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationTitle1.setText("Vaksin");

        informationTitle2.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationTitle2.setText("Booster");

        informationTitle3.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        informationTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationTitle3.setText("Efektivitas");

        informationVaksin.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationVaksin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationVaksin.setText("Vaksin");
        informationVaksin.setPreferredSize(new java.awt.Dimension(79, 21));

        informationBooster1.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationBooster1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationBooster1.setText("Bosoter");
        informationBooster1.setPreferredSize(new java.awt.Dimension(89, 21));

        informationBooster2.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationBooster2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationBooster2.setText("Booster");
        informationBooster2.setPreferredSize(new java.awt.Dimension(89, 21));

        informationBooster3.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationBooster3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationBooster3.setText("Booster");
        informationBooster3.setPreferredSize(new java.awt.Dimension(89, 21));

        informationEfektivitas1.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationEfektivitas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationEfektivitas1.setText("Efektivitas");
        informationEfektivitas1.setPreferredSize(new java.awt.Dimension(89, 21));

        informationEfektivitas2.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationEfektivitas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationEfektivitas2.setText("Efektivitas");
        informationEfektivitas2.setPreferredSize(new java.awt.Dimension(89, 21));

        informationEfektivitas3.setFont(new java.awt.Font("Dubai Light", 0, 12)); // NOI18N
        informationEfektivitas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informationEfektivitas3.setText("Efektivitas");
        informationEfektivitas3.setPreferredSize(new java.awt.Dimension(89, 21));

        informationJenisVaksin.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        informationJenisVaksin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationJenisVaksin.setText("Jenis Vaksin");

        informationEfikasi.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        informationEfikasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationEfikasi.setText("Efikasi");

        informationDosis.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        informationDosis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationDosis.setText("Dosis");

        informationUsia.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        informationUsia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        informationUsia.setText("Rentan Usia");

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(informationSeparator)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addComponent(informationVaksin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationBooster1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(informationEfektivitas1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addComponent(informationTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(informationTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationVaksinTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(informationPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(informationBooster2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informationPanelLayout.createSequentialGroup()
                                .addComponent(informationBooster3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informationEfektivitas2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(informationEfektivitas3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(informationJenisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationEfikasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(informationDosisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationUsiaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationJenisVaksin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationEfikasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationDosis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationUsia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationVaksinTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationJenisLabel)
                    .addComponent(informationJenisVaksin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationEfikasiLabel)
                    .addComponent(informationEfikasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationDosisLabel)
                    .addComponent(informationDosis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationUsiaLabel)
                    .addComponent(informationUsia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationTitle1)
                    .addComponent(informationTitle2)
                    .addComponent(informationTitle3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationVaksin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationBooster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationEfektivitas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationEfektivitas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationBooster2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationBooster3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationEfektivitas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout centerInformationPanelLayout = new javax.swing.GroupLayout(centerInformationPanel);
        centerInformationPanel.setLayout(centerInformationPanelLayout);
        centerInformationPanelLayout.setHorizontalGroup(
            centerInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        centerInformationPanelLayout.setVerticalGroup(
            centerInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        informationPanel1.setBackground(new java.awt.Color(16, 116, 182));

        sinovacInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        sinovacInformationButton.setForeground(new java.awt.Color(98, 177, 229));
        sinovacInformationButton.setText("SINOVAC");
        sinovacInformationButton.setBorderPainted(false);
        sinovacInformationButton.setContentAreaFilled(false);
        sinovacInformationButton.setFocusable(false);
        sinovacInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSinovacMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sinovacInformationButtonMouseExited(evt);
            }
        });
        sinovacInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinovacInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel1Layout = new javax.swing.GroupLayout(informationPanel1);
        informationPanel1.setLayout(informationPanel1Layout);
        informationPanel1Layout.setHorizontalGroup(
            informationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sinovacInformationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        informationPanel1Layout.setVerticalGroup(
            informationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sinovacInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel2.setBackground(new java.awt.Color(0, 165, 143));

        sputnikInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        sputnikInformationButton.setForeground(new java.awt.Color(71, 236, 214));
        sputnikInformationButton.setText("SPUTNIK V");
        sputnikInformationButton.setBorderPainted(false);
        sputnikInformationButton.setContentAreaFilled(false);
        sputnikInformationButton.setFocusable(false);
        sputnikInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sputnikInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sputnikInformationButtonMouseExited(evt);
            }
        });
        sputnikInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sputnikInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel2Layout = new javax.swing.GroupLayout(informationPanel2);
        informationPanel2.setLayout(informationPanel2Layout);
        informationPanel2Layout.setHorizontalGroup(
            informationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sputnikInformationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        informationPanel2Layout.setVerticalGroup(
            informationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sputnikInformationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel3.setBackground(new java.awt.Color(149, 182, 71));

        novavaxInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        novavaxInformationButton.setForeground(new java.awt.Color(193, 213, 147));
        novavaxInformationButton.setText("NOVAVAX");
        novavaxInformationButton.setBorderPainted(false);
        novavaxInformationButton.setContentAreaFilled(false);
        novavaxInformationButton.setFocusable(false);
        novavaxInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                novavaxInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                novavaxInformationButtonMouseExited(evt);
            }
        });
        novavaxInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novavaxInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel3Layout = new javax.swing.GroupLayout(informationPanel3);
        informationPanel3.setLayout(informationPanel3Layout);
        informationPanel3Layout.setHorizontalGroup(
            informationPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(novavaxInformationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        informationPanel3Layout.setVerticalGroup(
            informationPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(novavaxInformationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel4.setBackground(new java.awt.Color(250, 168, 33));

        astrazenecaInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        astrazenecaInformationButton.setForeground(new java.awt.Color(254, 204, 124));
        astrazenecaInformationButton.setText("ASTRAZENECA");
        astrazenecaInformationButton.setBorderPainted(false);
        astrazenecaInformationButton.setContentAreaFilled(false);
        astrazenecaInformationButton.setFocusable(false);
        astrazenecaInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                astrazenecaInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                astrazenecaInformationButtonMouseExited(evt);
            }
        });
        astrazenecaInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                astrazenecaInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel4Layout = new javax.swing.GroupLayout(informationPanel4);
        informationPanel4.setLayout(informationPanel4Layout);
        informationPanel4Layout.setHorizontalGroup(
            informationPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(astrazenecaInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        informationPanel4Layout.setVerticalGroup(
            informationPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(astrazenecaInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel5.setBackground(new java.awt.Color(199, 60, 60));

        pfizerInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        pfizerInformationButton.setForeground(new java.awt.Color(223, 140, 140));
        pfizerInformationButton.setText("PFIZER");
        pfizerInformationButton.setBorderPainted(false);
        pfizerInformationButton.setContentAreaFilled(false);
        pfizerInformationButton.setFocusable(false);
        pfizerInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pfizerInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pfizerInformationButtonMouseExited(evt);
            }
        });
        pfizerInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfizerInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel5Layout = new javax.swing.GroupLayout(informationPanel5);
        informationPanel5.setLayout(informationPanel5Layout);
        informationPanel5Layout.setHorizontalGroup(
            informationPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pfizerInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        informationPanel5Layout.setVerticalGroup(
            informationPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pfizerInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel6.setBackground(new java.awt.Color(66, 84, 106));

        modernaInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        modernaInformationButton.setForeground(new java.awt.Color(135, 154, 174));
        modernaInformationButton.setText("MODERNA");
        modernaInformationButton.setBorderPainted(false);
        modernaInformationButton.setContentAreaFilled(false);
        modernaInformationButton.setFocusable(false);
        modernaInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modernaInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modernaInformationButtonMouseExited(evt);
            }
        });
        modernaInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modernaInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel6Layout = new javax.swing.GroupLayout(informationPanel6);
        informationPanel6.setLayout(informationPanel6Layout);
        informationPanel6Layout.setHorizontalGroup(
            informationPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modernaInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        informationPanel6Layout.setVerticalGroup(
            informationPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modernaInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        informationPanel7.setBackground(new java.awt.Color(128, 90, 163));

        sinopharmInformationButton.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        sinopharmInformationButton.setForeground(new java.awt.Color(204, 153, 210));
        sinopharmInformationButton.setText("SINOPHARM");
        sinopharmInformationButton.setBorderPainted(false);
        sinopharmInformationButton.setContentAreaFilled(false);
        sinopharmInformationButton.setFocusable(false);
        sinopharmInformationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sinopharmInformationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sinopharmInformationButtonMouseExited(evt);
            }
        });
        sinopharmInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinopharmInformationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informationPanel7Layout = new javax.swing.GroupLayout(informationPanel7);
        informationPanel7.setLayout(informationPanel7Layout);
        informationPanel7Layout.setHorizontalGroup(
            informationPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sinopharmInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        informationPanel7Layout.setVerticalGroup(
            informationPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sinopharmInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InformationPanelLayout = new javax.swing.GroupLayout(InformationPanel);
        InformationPanel.setLayout(InformationPanelLayout);
        InformationPanelLayout.setHorizontalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationPanelLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(informationPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(centerInformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(informationPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        InformationPanelLayout.setVerticalGroup(
            InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InformationPanelLayout.createSequentialGroup()
                        .addComponent(informationPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(informationPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(InformationPanelLayout.createSequentialGroup()
                        .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(centerInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InformationPanelLayout.createSequentialGroup()
                                .addComponent(informationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(informationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(InformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(informationPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informationPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        AboutPanel.setBackground(new java.awt.Color(245, 246, 251));
        AboutPanel.setMinimumSize(new java.awt.Dimension(1082, 747));
        AboutPanel.setName(""); // NOI18N
        AboutPanel.setPreferredSize(new java.awt.Dimension(1366, 712));
        AboutPanel.setRequestFocusEnabled(false);

        jPanel11.setBackground(new java.awt.Color(208, 231, 251));

        jLabel19.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Bahasa");

        bahasaComboBox.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        bahasaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Indonesia", "Inggris", "Spanyol", "Germany", "India" }));
        bahasaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bahasaComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bahasaComboBox, 0, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bahasaComboBox))
                .addContainerGap())
        );

        centerAboutPage.setBackground(new java.awt.Color(245, 246, 251));

        jPanel22.setBackground(new java.awt.Color(208, 231, 251));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/aboutImage1.png"))); // NOI18N

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(91, 124, 253));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Medical Assist Software");

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(91, 124, 253));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("2.0");

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(91, 124, 253));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Vaccine Developement");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(91, 124, 253));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("KBM PEDES");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(91, 124, 253));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Kelompok Bakat Minat Pemrograman Desktop");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(97, 97, 97)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout centerAboutPageLayout = new javax.swing.GroupLayout(centerAboutPage);
        centerAboutPage.setLayout(centerAboutPageLayout);
        centerAboutPageLayout.setHorizontalGroup(
            centerAboutPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        centerAboutPageLayout.setVerticalGroup(
            centerAboutPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        text.setEditable(false);
        text.setColumns(20);
        text.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        text.setRows(5);
        text.setText("Initial Commit -- August 5, 2022\nV0.1 -- August 5, 2022 -- UI initial\nV0.2 -- August 6, 2022 -- Table, Place holder added\nV0.3 -- August 8, 2022 -- CRUD updated\nV0.4 -- August 8, 2022 -- new UI, Image added\nV0.5 -- August 10, 2022 -- add new color & Icon\nV0.6 -- August 11, 2022 -- add Diagram & Algoritm\nV0.7 -- August 11, 2022 -- new Diagram & Icon\nV0.8 -- August 14, 2022 -- add Object Sorting Algoritm\nV0.9 -- August 14, 2022 -- new Image & Card\nV1.0 -- August 16, 2022 -- Table Data Sorting added\nV1.1 -- August 18, 2022 -- add Export to Excel & PDF\nV1.2 -- August 19, 2022 -- add Search Engine\nV1.3 -- August 21, 2022 -- add Language (Indonesia & English)\nV1.4 -- August 21, 2022 -- new Export Card & Spanish Language\nV1.5 -- August 24, 2022 -- new panel UI (Information)\nV1.6 -- August 24, 2022 -- add Login Page\nV1.7 -- August 25, 2022 -- add Registration Page\nV1.8 -- August 27, 2022 -- new About Page\n");
        jScrollPane1.setViewportView(text);

        cardAbout1.setBackground(new java.awt.Color(245, 246, 251));

        jPanel30.setBackground(new java.awt.Color(208, 231, 251));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(91, 124, 253));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Vaccine Developement 1.0");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 199, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardAbout1Layout = new javax.swing.GroupLayout(cardAbout1);
        cardAbout1.setLayout(cardAbout1Layout);
        cardAbout1Layout.setHorizontalGroup(
            cardAbout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardAbout1Layout.setVerticalGroup(
            cardAbout1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardAbout2.setBackground(new java.awt.Color(245, 246, 251));

        jPanel31.setBackground(new java.awt.Color(208, 231, 251));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(91, 124, 253));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Vaccine Developement 2.0");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardAbout2Layout = new javax.swing.GroupLayout(cardAbout2);
        cardAbout2.setLayout(cardAbout2Layout);
        cardAbout2Layout.setHorizontalGroup(
            cardAbout2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardAbout2Layout.setVerticalGroup(
            cardAbout2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardAbout3.setBackground(new java.awt.Color(245, 246, 251));

        jPanel32.setBackground(new java.awt.Color(208, 231, 251));
        jPanel32.setPreferredSize(new java.awt.Dimension(469, 150));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(91, 124, 253));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Medical Assist Software");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41)
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardAbout3Layout = new javax.swing.GroupLayout(cardAbout3);
        cardAbout3.setLayout(cardAbout3Layout);
        cardAbout3Layout.setHorizontalGroup(
            cardAbout3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardAbout3Layout.setVerticalGroup(
            cardAbout3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardAbout4.setBackground(new java.awt.Color(245, 246, 251));

        jPanel33.setBackground(new java.awt.Color(208, 231, 251));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(91, 124, 253));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("KBM PEDES");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40)
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardAbout4Layout = new javax.swing.GroupLayout(cardAbout4);
        cardAbout4.setLayout(cardAbout4Layout);
        cardAbout4Layout.setHorizontalGroup(
            cardAbout4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardAbout4Layout.setVerticalGroup(
            cardAbout4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AboutPanelLayout = new javax.swing.GroupLayout(AboutPanel);
        AboutPanel.setLayout(AboutPanelLayout);
        AboutPanelLayout.setHorizontalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26)
                .addComponent(centerAboutPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardAbout4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardAbout2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardAbout3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        AboutPanelLayout.setVerticalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addGroup(AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AboutPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AboutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(centerAboutPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AboutPanelLayout.createSequentialGroup()
                                .addComponent(cardAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardAbout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardAbout3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardAbout4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        dashboardButton.setFont(new java.awt.Font("Dubai", 0, 20)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(153, 153, 153));
        dashboardButton.setText("  Dashboard");
        dashboardButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dashboardButton.setBorderPainted(false);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dashboardButton.setFocusPainted(false);
        dashboardButton.setFocusable(false);
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });

        dataButton.setFont(new java.awt.Font("Dubai", 0, 20)); // NOI18N
        dataButton.setForeground(new java.awt.Color(153, 153, 153));
        dataButton.setText("  Data");
        dataButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dataButton.setBorderPainted(false);
        dataButton.setContentAreaFilled(false);
        dataButton.setFocusPainted(false);
        dataButton.setFocusable(false);
        dataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataButtonActionPerformed(evt);
            }
        });

        otherButton.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        otherButton.setForeground(new java.awt.Color(153, 153, 153));
        otherButton.setText("  Other");
        otherButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        otherButton.setBorderPainted(false);
        otherButton.setContentAreaFilled(false);
        otherButton.setFocusPainted(false);
        otherButton.setFocusable(false);
        otherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherButtonActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(91, 124, 253));
        jLabel11.setText("Medical Assist Software");

        informationButton.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        informationButton.setForeground(new java.awt.Color(153, 153, 153));
        informationButton.setText("  Information");
        informationButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        informationButton.setBorderPainted(false);
        informationButton.setContentAreaFilled(false);
        informationButton.setFocusPainted(false);
        informationButton.setFocusable(false);
        informationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(129, 129, 129)
                .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(informationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(otherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 251, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(hiddenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dashboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(DashBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(AboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(hiddenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(InformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        dashboardButton.setForeground(new Color(91,124,253));
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.dashboard1Url)));
        otherButton.setForeground(colorSource.abuabu());
        otherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.about2Url)));
        dataButton.setForeground(colorSource.abuabu());
        dataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.data2Url)));
        informationButton.setForeground(colorSource.abuabu());
        informationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.info2Url)));
        dataButtonVisible(false);
        DashBoardPanel.setVisible(true);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(false);
        InformationPanel.setVisible(false);
        displayDataMahasiswa();
        reset();
        dataSortingProgress();
        progressImplements();
        cardVaksinSortingAlgortim();
        cardBoosterSortingAlgoritm();
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void dataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataButtonActionPerformed
        dashboardButton.setForeground(colorSource.abuabu());
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.dashboard2Url)));
        otherButton.setForeground(colorSource.abuabu());
        otherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.about2Url)));
        dataButton.setForeground(new Color(91,124,253));
        dataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.data1Url)));
        informationButton.setForeground(colorSource.abuabu());
        informationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.info2Url)));
        InformationPanel.setVisible(false);
        dataButtonVisible(true);
        DashBoardPanel.setVisible(false);
        DataPanel.setVisible(true);
        AboutPanel.setVisible(false);
        displayDataMahasiswa();
    }//GEN-LAST:event_dataButtonActionPerformed

    private void otherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherButtonActionPerformed
        dashboardButton.setForeground(colorSource.abuabu());
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.dashboard2Url)));
        otherButton.setForeground(new Color(91,124,253));
        otherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.about1Url)));
        dataButton.setForeground(colorSource.abuabu());
        dataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.data2Url)));
        informationButton.setForeground(colorSource.abuabu());
        informationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.info2Url)));
        InformationPanel.setVisible(false);
        DashBoardPanel.setVisible(false);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(true);
        dataButtonVisible(false);
    }//GEN-LAST:event_otherButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        boolean prompt = true;
        mahasiswa = new userModel();
            if(nimTextField.getText().equals(bahasa.getNIM()) && namaTextField.getText().equals(bahasa.getNAMA())){
                JOptionPane.showMessageDialog(this, bahasa.getMessageInputProtection3());
                prompt =false;
            }else if (nimTextField.getText().equals(bahasa.getNIM())){
                JOptionPane.showMessageDialog(this, bahasa.getMessageInputProtection1());
                prompt = false;
            }else if(namaTextField.getText().equals(bahasa.getNAMA())){
                JOptionPane.showMessageDialog(this, bahasa.getMessageInputProtection2());
                prompt = false;
            }else{
                mahasiswa.setNIM(nimTextField.getText());
                mahasiswa.setNama(namaTextField.getText());
            }
        if (vaksin1TextField.getText().equals(bahasa.getVAKSIN1())) {mahasiswa.setVaksin1("-");}else{mahasiswa.setVaksin1(vaksin1TextField.getText());}
        if (vaksin2TextField.getText().equals(bahasa.getVAKSIN2())) {mahasiswa.setVaksin2("-");}else{mahasiswa.setVaksin2(vaksin2TextField.getText());}
        if (vaksin3TextField.getText().equals(bahasa.getVAKSIN3())) {mahasiswa.setVaksin3("-");}else{mahasiswa.setVaksin3(vaksin3TextField.getText());}
        if (vaksin4TextField.getText().equals(bahasa.getVAKSIN4())) {mahasiswa.setVaksin4("-");}else{mahasiswa.setVaksin4(vaksin4TextField.getText());}
        if (vaksin5TextField.getText().equals(bahasa.getVAKSIN5())) {mahasiswa.setVaksin5("-");}else{mahasiswa.setVaksin5(vaksin5TextField.getText());}
        
        if (data.simpanDataMahasiswa(mahasiswa)) {
            JOptionPane.showMessageDialog(this, bahasa.getMessageDialog1() + bahasa.getMessageDialog3() + bahasa.getData());
            displayDataMahasiswa();
            reset();
        }else {
            System.out.println(bahasa.getMessageDialog2() + bahasa.getMessageDialog3() + bahasa.getData());
            if (prompt == true) {
                showMessageDialog(bahasa.getMessageError1());
            }
        }
    }//GEN-LAST:event_simpanButtonActionPerformed
    private void showMessageDialog(String input){
        JOptionPane.showMessageDialog(this, input);
    }
    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        if(nimTextField.getText().equals(bahasa.getNIM()) || namaTextField.getText().equals(bahasa.getNAMA())){
            JOptionPane.showMessageDialog(this, bahasa.getMessageError2());
        }else{
            if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini?","Delete Mahasiswa",0)==0){
                mahasiswa = new userModel();
                mahasiswa.setNIM(nimTextField.getText());
                if (data.hapusDataMahasiswa(mahasiswa)) {
                    JOptionPane.showMessageDialog(this, bahasa.getMessageDialog1() + bahasa.getMessageDialog5() + bahasa.getData());
                    displayDataMahasiswa();
                    reset();
                }else{
                    JOptionPane.showMessageDialog(this,  bahasa.getMessageDialog2() + bahasa.getMessageDialog5() + bahasa.getData());
                }
            }
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        displayDataMahasiswa();
        reset();
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void gantiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gantiButtonActionPerformed
        mahasiswa = new userModel();
        if(nimTextField.getText().equals(bahasa.getNIM()) || namaTextField.getText().equals(bahasa.getNAMA())){
            JOptionPane.showMessageDialog(this, bahasa.getMessageError3());
        }else{
            mahasiswa.setNIM(nimTextField.getText());
            mahasiswa.setNama(namaTextField.getText());
            if (vaksin1TextField.getText().equals(bahasa.getVAKSIN1())) {mahasiswa.setVaksin1("-");}else{mahasiswa.setVaksin1(vaksin1TextField.getText());}
            if (vaksin2TextField.getText().equals(bahasa.getVAKSIN2())) {mahasiswa.setVaksin2("-");}else{mahasiswa.setVaksin2(vaksin2TextField.getText());}
            if (vaksin3TextField.getText().equals(bahasa.getVAKSIN3())) {mahasiswa.setVaksin3("-");}else{mahasiswa.setVaksin3(vaksin3TextField.getText());}
            if (vaksin4TextField.getText().equals(bahasa.getVAKSIN4())) {mahasiswa.setVaksin4("-");}else{mahasiswa.setVaksin4(vaksin4TextField.getText());}
            if (vaksin5TextField.getText().equals(bahasa.getVAKSIN5())) {mahasiswa.setVaksin5("-");}else{mahasiswa.setVaksin5(vaksin5TextField.getText());}

            if (data.gantiDataMahasiswa(mahasiswa)) {
                JOptionPane.showMessageDialog(this, bahasa.getMessageDialog1() + bahasa.getMessageDialog4() + bahasa.getData());
                displayDataMahasiswa();
                reset();
            }else{
                showMessageDialog(bahasa.getMessageError1());
            }
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
        nimTextField.setForeground(colorSource.hitam());
        namaTextField.setForeground(colorSource.hitam());
        vaksin1TextField.setForeground(colorSource.hitam());
        vaksin2TextField.setForeground(colorSource.hitam());
        vaksin3TextField.setForeground(colorSource.hitam());
        vaksin4TextField.setForeground(colorSource.hitam());
        vaksin5TextField.setForeground(colorSource.hitam());
        nimCardPrint.setText(dataTable.getValueAt(row, 0).toString());
        namaCardPrint.setText(dataTable.getValueAt(row, 1).toString());
        vaksin1CardPrint.setText(dataTable.getValueAt(row, 2).toString());
        vaksin2CardPrint.setText(dataTable.getValueAt(row, 3).toString());
        booster1CardPrint.setText(dataTable.getValueAt(row, 4).toString());
        booster2CardPrint.setText(dataTable.getValueAt(row, 5).toString());
        booster3CardPrint.setText(dataTable.getValueAt(row, 6).toString());   
        nimTextField.setEditable(false);
        tableClicked = true;
    }//GEN-LAST:event_dataTableMouseClicked

    private void nimTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusGained
        if(nimTextField.getText().equals(bahasa.getNIM())){
            nimTextField.setText("");
            nimTextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_nimTextFieldFocusGained

    private void namaTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaTextFieldFocusGained
        if(namaTextField.getText().equals(bahasa.getNAMA())){
            namaTextField.setText("");
            namaTextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_namaTextFieldFocusGained

    private void vaksin1TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin1TextFieldFocusGained
        if(vaksin1TextField.getText().equals(bahasa.getVAKSIN1())){
            vaksin1TextField.setText("");
            vaksin1TextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_vaksin1TextFieldFocusGained

    private void vaksin2TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin2TextFieldFocusGained
        if(vaksin2TextField.getText().equals(bahasa.getVAKSIN2())){
            vaksin2TextField.setText("");
            vaksin2TextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_vaksin2TextFieldFocusGained

    private void vaksin3TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin3TextFieldFocusGained
        if(vaksin3TextField.getText().equals(bahasa.getVAKSIN3())){
            vaksin3TextField.setText("");
            vaksin3TextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_vaksin3TextFieldFocusGained

    private void vaksin4TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin4TextFieldFocusGained
        if(vaksin4TextField.getText().equals(bahasa.getVAKSIN4())){
            vaksin4TextField.setText("");
            vaksin4TextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_vaksin4TextFieldFocusGained

    private void vaksin5TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin5TextFieldFocusGained
        if(vaksin5TextField.getText().equals(bahasa.getVAKSIN5())){
            vaksin5TextField.setText("");
            vaksin5TextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_vaksin5TextFieldFocusGained

    private void nimTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusLost
        if(nimTextField.getText().equals("")){
            nimTextField.setText(bahasa.getNIM());
            nimTextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_nimTextFieldFocusLost

    private void namaTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaTextFieldFocusLost
        if(namaTextField.getText().equals("")){
            namaTextField.setText(bahasa.getNAMA());
            namaTextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_namaTextFieldFocusLost

    private void vaksin1TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin1TextFieldFocusLost
        if(vaksin1TextField.getText().equals("")){
            vaksin1TextField.setText(bahasa.getVAKSIN1());
            vaksin1TextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_vaksin1TextFieldFocusLost

    private void vaksin2TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin2TextFieldFocusLost
        if(vaksin2TextField.getText().equals("")){
            vaksin2TextField.setText(bahasa.getVAKSIN2());
            vaksin2TextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_vaksin2TextFieldFocusLost

    private void vaksin3TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin3TextFieldFocusLost
        if(vaksin3TextField.getText().equals("")){
            vaksin3TextField.setText(bahasa.getVAKSIN3());
            vaksin3TextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_vaksin3TextFieldFocusLost

    private void vaksin4TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin4TextFieldFocusLost
        if(vaksin4TextField.getText().equals("")){
            vaksin4TextField.setText(bahasa.getVAKSIN4());
            vaksin4TextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_vaksin4TextFieldFocusLost

    private void vaksin5TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vaksin5TextFieldFocusLost
        if(vaksin5TextField.getText().equals("")){
            vaksin5TextField.setText(bahasa.getVAKSIN5());
            vaksin5TextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_vaksin5TextFieldFocusLost

    private void simpanButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanButtonMouseEntered
        simpanPanel.setBackground(colorSource.biruMuda());
        simpanButton.setForeground(Color.white);
    }//GEN-LAST:event_simpanButtonMouseEntered

    private void simpanButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanButtonMouseExited
        simpanPanel.setBackground(colorSource.background());
        simpanButton.setForeground(colorSource.biruMuda());
    }//GEN-LAST:event_simpanButtonMouseExited

    private void hapusButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusButtonMouseEntered
        hapusPanel.setBackground(colorSource.biruMuda());
        hapusButton.setForeground(Color.white);
    }//GEN-LAST:event_hapusButtonMouseEntered

    private void hapusButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusButtonMouseExited
        hapusPanel.setBackground(colorSource.background());
        hapusButton.setForeground(colorSource.biruMuda());
    }//GEN-LAST:event_hapusButtonMouseExited

    private void gantiButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gantiButtonMouseEntered
        gantiPanel.setBackground(colorSource.biruMuda());
        gantiButton.setForeground(Color.white);
    }//GEN-LAST:event_gantiButtonMouseEntered

    private void gantiButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gantiButtonMouseExited
        gantiPanel.setBackground(colorSource.background());
        gantiButton.setForeground(colorSource.biruMuda());
    }//GEN-LAST:event_gantiButtonMouseExited

    private void tambahButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahButtonMouseEntered
        tambahPanel.setBackground(colorSource.biruMuda());
        tambahButton.setForeground(Color.white);
    }//GEN-LAST:event_tambahButtonMouseEntered

    private void tambahButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahButtonMouseExited
        tambahPanel.setBackground(colorSource.background());
        tambahButton.setForeground(colorSource.biruMuda());
    }//GEN-LAST:event_tambahButtonMouseExited

    private void showComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showComboBoxActionPerformed
        switch(showComboBox.getSelectedIndex()){
            case 0 ://show all
                displayDataMahasiswa();
        break;
            case 1 ://show vaksin 1
                showOnlySort(1);
        break;
            case 2 ://show vaksin 2
                showOnlySort(2);
        break;
            case 3 ://show booster 1
                showOnlySort(3);
        break;
            case 4 ://show booster 2
                showOnlySort(4);
        break;
            case 5 ://show booster 3
                showOnlySort(5);
        break;
        }
    }//GEN-LAST:event_showComboBoxActionPerformed
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        if (exportComboBox.getSelectedIndex()==0 || exportComboBox.getSelectedIndex()==3) {
            JOptionPane.showMessageDialog(this, bahasa.getMessageError4());
        } else {
            switch(exportComboBox.getSelectedIndex()){
                case 0://pdf
                    fileChooser(".pdf");
                break;
                case 1://Excel
                    fileChooser(".xlsx");
                break;
                case 2://txt
                    fileChooser(".txt");
                break;
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed
   
    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        if (dataTable.getRowCount()==0) {
            JOptionPane.showMessageDialog(this, bahasa.getMessageError5());
           displayDataMahasiswa();
           reset();
        }else{
            switch(exportComboBox.getSelectedIndex()){
                case 0 ://PDF
                        exportToPDF();
            break;
                case 1 ://Excel
                    if (browseText.getText().equals("")==true) {
                        JOptionPane.showMessageDialog(this, bahasa.getMessageError6());
                    }else{
                        exportToExcel();
                    }
            break;
                case 2 :
                    if (browseText.getText().equals("")==true) {
                        JOptionPane.showMessageDialog(this, bahasa.getMessageError6());
                    }else{
                        exportToTXT();
                    }
            break; 
                case 3 :  
                    if (tableClicked == false) {
                        showMessageDialog("Pilih data yang akan di ekspor");
                    }else {
                        printCard(vaksinCardPrint);
                    }
            break;
        
            }
        }
        
        browseText.setText("");
    }//GEN-LAST:event_exportButtonActionPerformed
    
    private void exportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportButtonMouseEntered
        exportButton.setForeground(Color.white);
        exportPanel.setBackground(colorSource.biruMuda());
    }//GEN-LAST:event_exportButtonMouseEntered

    private void exportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportButtonMouseExited
        exportButton.setForeground(colorSource.biruMuda());
        exportPanel.setBackground(colorSource.background());
    }//GEN-LAST:event_exportButtonMouseExited

    private void browseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseEntered
        browseButton.setForeground(Color.white);
        browsePanel.setBackground(colorSource.biruMuda());
    }//GEN-LAST:event_browseButtonMouseEntered

    private void browseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseButtonMouseExited
        browseButton.setForeground(colorSource.biruMuda());
        browsePanel.setBackground(colorSource.background());
    }//GEN-LAST:event_browseButtonMouseExited

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        if(searchTextField.getText().equals(bahasa.getSearch())){
            searchTextField.setText("");
            searchTextField.setForeground(colorSource.hitam());
        }
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        if(searchTextField.getText().equals("")){
            searchTextField.setText(bahasa.getSearch());
            searchTextField.setForeground(colorSource.abuabu());
        }
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (searchTextField.getText().equals(bahasa.getSearch())) {
            JOptionPane.showMessageDialog(this, bahasa.getMessageError9());
        }else {
            searchData(searchTextField.getText());
            if (dataTable.getRowCount()==0) {
                JOptionPane.showMessageDialog(this, bahasa.getMessageError10());
                displayDataMahasiswa();            
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseEntered
        searchButton.setForeground(Color.white);
        searchPanel.setBackground(colorSource.biruMuda());
    }//GEN-LAST:event_searchButtonMouseEntered

    private void searchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseExited
        searchButton.setForeground(colorSource.biruMuda());
        searchPanel.setBackground(colorSource.background());
    }//GEN-LAST:event_searchButtonMouseExited

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        if (evt.getKeyCode() ==8){displayDataMahasiswa();}
        if (searchTextField.getText().equals(bahasa.getSearch())) {
            JOptionPane.showMessageDialog(this, bahasa.getMessageError9());
        }else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                searchData(searchTextField.getText());
                if (dataTable.getRowCount()==0) {
                    JOptionPane.showMessageDialog(this, bahasa.getMessageError10());
                    displayDataMahasiswa();            
                }
            }
        }

        
    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void bahasaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bahasaComboBoxActionPerformed
        if (bahasaComboBox.getSelectedIndex()==0) {
            bahasa.setLanguage("Indonesia");
            reset();
            //bahasa indo
        }else if (bahasaComboBox.getSelectedIndex()==1) {
            //bahasa inggris
            bahasa.setLanguage("English");
            reset();
        }else if (bahasaComboBox.getSelectedIndex()==2) {
            bahasa.setLanguage("Spanish");
            reset();
            //bahasa Spanyol
        }else if (bahasaComboBox.getSelectedIndex()==3) {
            bahasa.setLanguage("Germany");
            reset();
            //bahasa German
        }else if (bahasaComboBox.getSelectedIndex()==4) {
            bahasa.setLanguage("India");
            reset();
            //bahasa India
        }
    }//GEN-LAST:event_bahasaComboBoxActionPerformed

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void informationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationButtonActionPerformed
        dashboardButton.setForeground(colorSource.abuabu());
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.dashboard2Url)));
        otherButton.setForeground(colorSource.abuabu());
        otherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.about2Url)));
        dataButton.setForeground(colorSource.abuabu());
        dataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.data2Url)));
        informationButton.setForeground(colorSource.biruMuda());
        informationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlSource.info1Url)));
        dataButtonVisible(false);
        DashBoardPanel.setVisible(false);
        DataPanel.setVisible(false);
        AboutPanel.setVisible(false);
        InformationPanel.setVisible(true);
        resetInformationPanel(false);
    }//GEN-LAST:event_informationButtonActionPerformed
    private void resetInformationPanel(boolean bool){
        if (bool == true) {
            informationJenisLabel.setText("Jenis");
            informationEfikasiLabel.setText("Efikasi*");
            informationDosisLabel.setText("Dosis");
            informationUsiaLabel.setText("Usia");
            informationTitle1.setText("Vaksin");
            informationTitle2.setText("Booster");
            informationTitle3.setText("Efiktivasi");
            informationSeparator.setVisible(true);
        }else{
            centerInformation(7);
            informationImage.setText("");
            informationJenisLabel.setText("");
            informationEfikasiLabel.setText("");
            informationDosisLabel.setText("");
            informationUsiaLabel.setText("");
            informationTitle1.setText("");
            informationTitle2.setText("");
            informationTitle3.setText("");
            informationSeparator.setVisible(false);
            centerInformationPanel.setBackground(colorSource.background());
        }
    }
    private void sinovacInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinovacInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.SinovacCardPanel(false));
            centerInformation(0);
            resetInformationPanel(true);
    }//GEN-LAST:event_sinovacInformationButtonActionPerformed
    
    private void sputnikInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sputnikInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.SputnikCardPanel(false));
            centerInformation(1);
            resetInformationPanel(true);
    }//GEN-LAST:event_sputnikInformationButtonActionPerformed

    private void novavaxInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novavaxInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.NovavaxCardPanel(false));
            centerInformation(2);
            resetInformationPanel(true);
    }//GEN-LAST:event_novavaxInformationButtonActionPerformed

    private void astrazenecaInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_astrazenecaInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.AstrazenecaCardPanel(false));
            centerInformation(3);
            resetInformationPanel(true);
    }//GEN-LAST:event_astrazenecaInformationButtonActionPerformed

    private void pfizerInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfizerInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.PfizerCardPanel(false));
            centerInformation(4);
            resetInformationPanel(true);
    }//GEN-LAST:event_pfizerInformationButtonActionPerformed

    private void modernaInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modernaInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.ModernaCardPanel(false));
            centerInformation(5);
            resetInformationPanel(true);
    }//GEN-LAST:event_modernaInformationButtonActionPerformed

    private void sinopharmInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinopharmInformationButtonActionPerformed
            centerInformationPanel.setBackground(colorSource.SinopharmCardPanel(false));
            centerInformation(6);
            resetInformationPanel(true);
    }//GEN-LAST:event_sinopharmInformationButtonActionPerformed

    private void buttonSinovacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSinovacMouseEntered
        informationPanel1.setBackground(colorSource.SinovacCardPanel(false));
        sinovacInformationButton.setForeground(colorSource.SinovacCardPanel(true));
    }//GEN-LAST:event_buttonSinovacMouseEntered

    private void sinovacInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinovacInformationButtonMouseExited
        informationPanel1.setBackground(colorSource.SinovacCardPanel(true));
        sinovacInformationButton.setForeground(colorSource.SinovacCardPanel(false));
    }//GEN-LAST:event_sinovacInformationButtonMouseExited

    private void sputnikInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sputnikInformationButtonMouseEntered
        informationPanel2.setBackground(colorSource.SputnikCardPanel(false));
        sputnikInformationButton.setForeground(colorSource.SputnikCardPanel(true));
    }//GEN-LAST:event_sputnikInformationButtonMouseEntered

    private void sputnikInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sputnikInformationButtonMouseExited
        informationPanel2.setBackground(colorSource.SputnikCardPanel(true));
        sputnikInformationButton.setForeground(colorSource.SputnikCardPanel(false));
    }//GEN-LAST:event_sputnikInformationButtonMouseExited

    private void novavaxInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novavaxInformationButtonMouseEntered
        informationPanel3.setBackground(colorSource.NovavaxCardPanel(false));
        novavaxInformationButton.setForeground(colorSource.NovavaxCardPanel(true));
    }//GEN-LAST:event_novavaxInformationButtonMouseEntered

    private void novavaxInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novavaxInformationButtonMouseExited
        informationPanel3.setBackground(colorSource.NovavaxCardPanel(true));
        novavaxInformationButton.setForeground(colorSource.NovavaxCardPanel(false));
    }//GEN-LAST:event_novavaxInformationButtonMouseExited

    private void astrazenecaInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_astrazenecaInformationButtonMouseEntered
        informationPanel4.setBackground(colorSource.AstrazenecaCardPanel(false));
        astrazenecaInformationButton.setForeground(colorSource.AstrazenecaCardPanel(true));
    }//GEN-LAST:event_astrazenecaInformationButtonMouseEntered

    private void astrazenecaInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_astrazenecaInformationButtonMouseExited
        informationPanel4.setBackground(colorSource.NovavaxCardPanel(true));
        novavaxInformationButton.setForeground(colorSource.NovavaxCardPanel(false));
    }//GEN-LAST:event_astrazenecaInformationButtonMouseExited

    private void pfizerInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pfizerInformationButtonMouseEntered
        informationPanel5.setBackground(colorSource.PfizerCardPanel(false));
        pfizerInformationButton.setForeground(colorSource.PfizerCardPanel(true));
    }//GEN-LAST:event_pfizerInformationButtonMouseEntered

    private void pfizerInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pfizerInformationButtonMouseExited
        informationPanel5.setBackground(colorSource.PfizerCardPanel(true));
        pfizerInformationButton.setForeground(colorSource.PfizerCardPanel(false));
    }//GEN-LAST:event_pfizerInformationButtonMouseExited

    private void modernaInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modernaInformationButtonMouseEntered
        informationPanel6.setBackground(colorSource.ModernaCardPanel(false));
        modernaInformationButton.setForeground(colorSource.ModernaCardPanel(true));
    }//GEN-LAST:event_modernaInformationButtonMouseEntered

    private void modernaInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modernaInformationButtonMouseExited
        informationPanel6.setBackground(colorSource.ModernaCardPanel(true));
        modernaInformationButton.setForeground(colorSource.ModernaCardPanel(false));
    }//GEN-LAST:event_modernaInformationButtonMouseExited

    private void sinopharmInformationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinopharmInformationButtonMouseEntered
        informationPanel7.setBackground(colorSource.SinopharmCardPanel(false));
        sinopharmInformationButton.setForeground(colorSource.SinopharmCardPanel(true));
    }//GEN-LAST:event_sinopharmInformationButtonMouseEntered

    private void sinopharmInformationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinopharmInformationButtonMouseExited
        informationPanel7.setBackground(colorSource.SinopharmCardPanel(true));
        sinopharmInformationButton.setForeground(colorSource.SinopharmCardPanel(false));
    }//GEN-LAST:event_sinopharmInformationButtonMouseExited
    

   
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
            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AboutPanel;
    private javax.swing.JPanel DashBoardPanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JPanel InformationPanel;
    private javax.swing.JButton astrazenecaInformationButton;
    private javax.swing.JComboBox bahasaComboBox;
    private javax.swing.JLabel booster1CardPrint;
    private javax.swing.JLabel booster2CardPrint;
    private javax.swing.JLabel booster3CardPrint;
    private javax.swing.JLabel boosterCardValue1;
    private javax.swing.JLabel boosterCardValue2;
    private javax.swing.JLabel boosterCardValue3;
    private javax.swing.JPanel boosterDiagram;
    private javax.swing.JLabel boosterTitle1;
    private javax.swing.JLabel boosterTitle2;
    private javax.swing.JLabel boosterTitle3;
    private javax.swing.JButton browseButton;
    private javax.swing.JPanel browsePanel;
    private javax.swing.JTextField browseText;
    private javax.swing.JPanel cardAbout1;
    private javax.swing.JPanel cardAbout2;
    private javax.swing.JPanel cardAbout3;
    private javax.swing.JPanel cardAbout4;
    private javax.swing.JPanel cardBooster1;
    private javax.swing.JPanel cardBooster2;
    private javax.swing.JPanel cardBooster3;
    private javax.swing.JLabel cardBoosterImage1;
    private javax.swing.JLabel cardBoosterImage2;
    private javax.swing.JLabel cardBoosterImage3;
    private javax.swing.JLabel cardLabel1;
    private javax.swing.JLabel cardLabel2;
    private javax.swing.JLabel cardLabel3;
    private javax.swing.JLabel cardLabel4;
    private javax.swing.JLabel cardLabel5;
    private javax.swing.JLabel cardTitle1;
    private javax.swing.JLabel cardTitle2;
    private javax.swing.JLabel cardTitle3;
    private javax.swing.JLabel cardTitle4;
    private javax.swing.JLabel cardTitle5;
    private javax.swing.JLabel cardTitle6;
    private javax.swing.JLabel cardTitle7;
    private javax.swing.JPanel cardVaksin1;
    private javax.swing.JPanel cardVaksin10;
    private javax.swing.JPanel cardVaksin11;
    private javax.swing.JPanel cardVaksin12;
    private javax.swing.JPanel cardVaksin2;
    private javax.swing.JPanel cardVaksin3;
    private javax.swing.JPanel cardVaksin4;
    private javax.swing.JPanel cardVaksin5;
    private javax.swing.JPanel cardVaksin6;
    private javax.swing.JPanel cardVaksin7;
    private javax.swing.JPanel cardVaksin8;
    private javax.swing.JPanel cardVaksin9;
    private javax.swing.JLabel cardVaksinImage1;
    private javax.swing.JLabel cardVaksinImage2;
    private javax.swing.JLabel cardVaksinImage3;
    private javax.swing.JLabel cardVaksinImage4;
    private javax.swing.JLabel cardVaksinImage5;
    private javax.swing.JLabel cardVaksinImage6;
    private javax.swing.JLabel cardVaksinImage7;
    private javax.swing.JLabel cardVaksinValue1;
    private javax.swing.JLabel cardVaksinValue2;
    private javax.swing.JLabel cardVaksinValue3;
    private javax.swing.JLabel cardVaksinValue4;
    private javax.swing.JLabel cardVaksinValue5;
    private javax.swing.JLabel cardVaksinValue6;
    private javax.swing.JLabel cardVaksinValue7;
    private javax.swing.JPanel centerAboutPage;
    private javax.swing.JPanel centerInformationPanel;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton dataButton;
    private javax.swing.JLabel dataLabel1;
    private javax.swing.JLabel dataLabel2;
    private javax.swing.JLabel dataLabel3;
    private javax.swing.JLabel dataLabel4;
    private javax.swing.JLabel dataLabel5;
    private javax.swing.JLabel dataLabel6;
    private javax.swing.JLabel dataLabel7;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel diagramHalfMaxValue1;
    private javax.swing.JLabel diagramHalfMaxValue10;
    private javax.swing.JLabel diagramHalfMaxValue11;
    private javax.swing.JLabel diagramHalfMaxValue12;
    private javax.swing.JLabel diagramHalfMaxValue2;
    private javax.swing.JLabel diagramHalfMaxValue3;
    private javax.swing.JLabel diagramHalfMaxValue4;
    private javax.swing.JLabel diagramHalfMaxValue5;
    private javax.swing.JLabel diagramHalfMaxValue6;
    private javax.swing.JLabel diagramHalfMaxValue7;
    private javax.swing.JLabel diagramHalfMaxValueBooster;
    private javax.swing.JLabel diagramHalfMaxValueVaksin;
    private javax.swing.JLabel diagramLabel1;
    private javax.swing.JLabel diagramLabel2;
    private javax.swing.JLabel diagramMaxValueBooster;
    private javax.swing.JLabel diagramMaxValueVaksin;
    private javax.swing.JProgressBar diagramProgressBaVaksinr2;
    private javax.swing.JProgressBar diagramProgressBarBooster1;
    private javax.swing.JProgressBar diagramProgressBarBooster2;
    private javax.swing.JProgressBar diagramProgressBarBooster3;
    private javax.swing.JProgressBar diagramProgressBarVaksin1;
    private javax.swing.JProgressBar diagramProgressBarVaksin3;
    private javax.swing.JProgressBar diagramProgressBarVaksin4;
    private javax.swing.JProgressBar diagramProgressBarVaksin5;
    private javax.swing.JProgressBar diagramProgressBarVaksin6;
    private javax.swing.JProgressBar diagramProgressBarVaksin7;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox exportComboBox;
    private javax.swing.JPanel exportPanel;
    private javax.swing.JButton gantiButton;
    private javax.swing.JPanel gantiPanel;
    private javax.swing.JButton hapusButton;
    private javax.swing.JPanel hapusPanel;
    private javax.swing.JPanel hiddenPanel;
    private javax.swing.JLabel informationBooster1;
    private javax.swing.JLabel informationBooster2;
    private javax.swing.JLabel informationBooster3;
    private javax.swing.JButton informationButton;
    private javax.swing.JLabel informationDosis;
    private javax.swing.JLabel informationDosisLabel;
    private javax.swing.JLabel informationEfektivitas1;
    private javax.swing.JLabel informationEfektivitas2;
    private javax.swing.JLabel informationEfektivitas3;
    private javax.swing.JLabel informationEfikasi;
    private javax.swing.JLabel informationEfikasiLabel;
    private javax.swing.JLabel informationImage;
    private javax.swing.JLabel informationJenisLabel;
    private javax.swing.JLabel informationJenisVaksin;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel informationPanel1;
    private javax.swing.JPanel informationPanel2;
    private javax.swing.JPanel informationPanel3;
    private javax.swing.JPanel informationPanel4;
    private javax.swing.JPanel informationPanel5;
    private javax.swing.JPanel informationPanel6;
    private javax.swing.JPanel informationPanel7;
    private javax.swing.JSeparator informationSeparator;
    private javax.swing.JLabel informationTitle1;
    private javax.swing.JLabel informationTitle2;
    private javax.swing.JLabel informationTitle3;
    private javax.swing.JLabel informationUsia;
    private javax.swing.JLabel informationUsiaLabel;
    private javax.swing.JLabel informationVaksin;
    private javax.swing.JLabel informationVaksinTitle;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin1;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin2;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin3;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin4;
    private javax.swing.JLabel jumlahMahasiswaCardVaksin5;
    private javax.swing.JLabel labelMahasiswa1;
    private javax.swing.JLabel labelMahasiswa2;
    private javax.swing.JLabel labelMahasiswa3;
    private javax.swing.JLabel labelMahasiswa4;
    private javax.swing.JLabel labelMahasiswa5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton modernaInformationButton;
    private javax.swing.JLabel namaCardPrint;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JLabel nimCardPrint;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JButton novavaxInformationButton;
    private javax.swing.JButton otherButton;
    private javax.swing.JLabel persentasiVaksin1;
    private javax.swing.JLabel persentasiVaksin2;
    private javax.swing.JLabel persentasiVaksin3;
    private javax.swing.JLabel persentasiVaksin4;
    private javax.swing.JLabel persentasiVaksin5;
    private javax.swing.JButton pfizerInformationButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox showComboBox;
    private javax.swing.JButton simpanButton;
    private javax.swing.JPanel simpanPanel;
    private javax.swing.JButton sinopharmInformationButton;
    private javax.swing.JButton sinovacInformationButton;
    private javax.swing.JButton sputnikInformationButton;
    private javax.swing.JScrollPane tabelScroll;
    private javax.swing.JButton tambahButton;
    private javax.swing.JPanel tambahPanel;
    private javax.swing.JTextArea text;
    private javax.swing.JLabel vaksin1CardPrint;
    private javax.swing.JProgressBar vaksin1ProgressBar;
    private javax.swing.JTextField vaksin1TextField;
    private javax.swing.JLabel vaksin2CardPrint;
    private javax.swing.JProgressBar vaksin2ProgressBar;
    private javax.swing.JTextField vaksin2TextField;
    private javax.swing.JProgressBar vaksin3ProgressBar;
    private javax.swing.JTextField vaksin3TextField;
    private javax.swing.JProgressBar vaksin4ProgressBar;
    private javax.swing.JTextField vaksin4TextField;
    private javax.swing.JProgressBar vaksin5ProgressBar;
    private javax.swing.JTextField vaksin5TextField;
    private javax.swing.JPanel vaksinCardPrint;
    private javax.swing.JPanel vaksinCardPrint1;
    private javax.swing.JPanel vaksinDiagram;
    // End of variables declaration//GEN-END:variables

}
