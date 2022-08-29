/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Storage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class valueData {
    private double vaksin1,vaksin2,vaksin3,vaksin4,vaksin5;
    private int mahasiswaVaksin1,mahasiswaVaksin2,mahasiswaVaksin3,mahasiswaVaksin4,mahasiswaVaksin5;
    private int cardRepeater,maxDiagramVaksinValue, maxDiagramBoosterValue;
    private int vaksinValue1,vaksinValue2,vaksinValue3,vaksinValue4,vaksinValue5,vaksinValue6,vaksinValue7,boosterValue1,boosterValue2,boosterValue3;
    private int sinovacValue, sputnikvalue, novavaxValue, oxfordazValue, pfizerbtValue, modernaValue, sinopharmValue;
    private int sinovacVaksin,sputnikvaksin,novavaxVaksin,oxfordAZVaksin,pfizerBTVaksin,modernaVaksin,sinopharmVaksin, pfizerBTBooster, oxfordAZBooster, modernaBooster;
    public double getVaksin1() {return vaksin1;}
    public void addVaksin1(){this.vaksin1++;}
    public void setVaksin1(double vaksin1) {this.vaksin1 = vaksin1;}
    public double getVaksin2() {return vaksin2;}
    public void addVaksin2(){this.vaksin2++;}
    public void setVaksin2(double vaksin2) {this.vaksin2 = vaksin2;}
    public double getVaksin3() {return vaksin3;}
    public void addVaksin3(){this.vaksin3++;}
    public void setVaksin3(double vaksin3) {this.vaksin3 = vaksin3;}
    public double getVaksin4() {return vaksin4;}
    public void addVaksin4(){this.vaksin4++;}
    public void setVaksin4(double vaksin4) {this.vaksin4 = vaksin4;}
    public double getVaksin5() {return vaksin5;}
    public void addVaksin5(){this.vaksin5++;}
    public void setVaksin5(double vaksin5) {this.vaksin5 = vaksin5;}

    public int getMahasiswaVaksin1() {return mahasiswaVaksin1;}
    public void addMahasiswaVaksin1(){this.mahasiswaVaksin1++;}
    public void setMahasiswaVaksin1(int mahasiswaVaksin1) {this.mahasiswaVaksin1 = mahasiswaVaksin1;}
    public int getMahasiswaVaksin2() {return mahasiswaVaksin2;}
    public void addMahasiswaVaksin2(){this.mahasiswaVaksin2++;}
    public void setMahasiswaVaksin2(int mahasiswaVaksin2) {this.mahasiswaVaksin2 = mahasiswaVaksin2;}
    public int getMahasiswaVaksin3() {return mahasiswaVaksin3;}
    public void addMahasiswaVaksin3(){this.mahasiswaVaksin3++;}
    public void setMahasiswaVaksin3(int mahasiswaVaksin3) {this.mahasiswaVaksin3 = mahasiswaVaksin3;}
    public int getMahasiswaVaksin4() {return mahasiswaVaksin4;}
    public void addMahasiswaVaksin4(){this.mahasiswaVaksin4++;}
    public void setMahasiswaVaksin4(int mahasiswaVaksin4) {this.mahasiswaVaksin4 = mahasiswaVaksin4;}
    public int getMahasiswaVaksin5() {return mahasiswaVaksin5;}
    public void addMahasiswaVaksin5(){this.mahasiswaVaksin5++;}
    public void setMahasiswaVaksin5(int mahasiswaVaksin5) {this.mahasiswaVaksin5 = mahasiswaVaksin5;}
    public int getCard1Repeater() {return cardRepeater;}
    public void addCardRepeater(){this.cardRepeater++;}
    public int getSinovacValue() {return sinovacValue;}
    public void setSinovacValue(int sinovacValue) {this.sinovacValue = sinovacValue;}
    public int getSputnikvalue() {return sputnikvalue;}
    public void setSputnikvalue(int sputnikvalue) {this.sputnikvalue = sputnikvalue;}
    public int getNovavaxValue() {return novavaxValue;}
    public void setNovavaxValue(int novavaxValue) {this.novavaxValue = novavaxValue;}
    public int getOxfordazValue() {return oxfordazValue;}
    public void setOxfordazValue(int oxfordazValue) {this.oxfordazValue = oxfordazValue;}
    public int getPfizerbtValue() {return pfizerbtValue;}
    public void setPfizerbtValue(int pfizerbtValue) {this.pfizerbtValue = pfizerbtValue;}
    public int getModernaValue() {return modernaValue;}
    public void setModernaValue(int modernaValue) {this.modernaValue = modernaValue;}
    public int getSinopharmValue() {return sinopharmValue;}
    public void setSinopharmValue(int sinopharmValue) {this.sinopharmValue = sinopharmValue;}

    public int getMaxDiagramVaksinValue() {
        return maxDiagramVaksinValue;
    }
    public int addMaxDiagramVaksinValue(int val){
        return this.maxDiagramVaksinValue += val;
    }
    public void setMaxDiagramVaksinValue(int maxDiagramVaksinValue) {
        this.maxDiagramVaksinValue = maxDiagramVaksinValue;
    }

    public int getMaxDiagramBoosterValue() {
        return maxDiagramBoosterValue;
    }
    public int addMaxDiagramBoosterValue(int val){
        return this.maxDiagramBoosterValue += val;
    }
    public void setMaxDiagramBoosterValue(int maxDiagramBoosterValue) {
        this.maxDiagramBoosterValue = maxDiagramBoosterValue;
    }

    
    
    public int getCardRepeater() {
        return cardRepeater;
    }

    public void setCardRepeater(int cardRepeater) {
        this.cardRepeater = cardRepeater;
    }

    public int getSinovacVaksin() {
        return sinovacVaksin;
    }
    public int addSinovacVaksin(){
        return this.sinovacVaksin++;
    }
    public void setSinovacVaksin(int sinovacVaksin) {
        this.sinovacVaksin = sinovacVaksin;
    }
    
    public int getSputnikvaksin() {
        return sputnikvaksin;
    }
    public int addSputnikvaksin(){
        return this.sputnikvaksin++;
    }
    public void setSputnikvaksin(int sputnikvaksin) {
        this.sputnikvaksin = sputnikvaksin;
    }

    public int getNovavaxVaksin() {
        return novavaxVaksin;
    }
    public int addNovavaxVaksin(){
        return this.novavaxVaksin++;
    }
    public void setNovavaxVaksin(int novavaxVaksin) {
        this.novavaxVaksin = novavaxVaksin;
    }

    public int getOxfordAZVaksin() {
        return oxfordAZVaksin;
    }
    public int addOxfordAZVaksin(){
        return this.oxfordAZVaksin++;
    }
    public void setOxfordAZVaksin(int oxfordAZVaksin) {
        this.oxfordAZVaksin = oxfordAZVaksin;
    }

    public int getPfizerBTVaksin() {
        return pfizerBTVaksin;
    }
    public int addPfizerVaksin(){
        return this.pfizerBTVaksin++;
    }
    public void setPfizerBTVaksin(int pfizerBTVaksin) {
        this.pfizerBTVaksin = pfizerBTVaksin;
    }

    public int getModernaVaksin() {
        return modernaVaksin;
    }
    public int addModernaVaksin(){
        return this.modernaVaksin++;
    }
    public void setModernaVaksin(int modernaVaksin) {
        this.modernaVaksin = modernaVaksin;
    }

    public int getSinopharmVaksin() {
        return sinopharmVaksin;
    }
    public int addSinopharmVaksin(){
        return this.sinopharmVaksin++;
    }
    public void setSinopharmVaksin(int sinopharmVaksin) {
        this.sinopharmVaksin = sinopharmVaksin;
    }

    public int getPfizerBTBooster() {
        return pfizerBTBooster;
    }
    public int addPfizerBTBooster(){
        return this.pfizerBTBooster++;
    }
    public void setPfizerBTBooster(int pfizerBTBooster) {
        this.pfizerBTBooster = pfizerBTBooster;
    }

    public int getOxfordAZBooster() {
        return oxfordAZBooster;
    }
    public int addOxfordAZBooster(){
        return this.oxfordAZBooster++;
    }
    public void setOxfordAZBooster(int oxfordAZBooster) {
        this.oxfordAZBooster = oxfordAZBooster;
    }

    public int getModernaBooster() {
        return modernaBooster;
    }
    public int addModernaBooster(){
        return this.modernaBooster++;
    }
    public void setModernaBooster(int modernaBooster) {
        this.modernaBooster = modernaBooster;
    }
    
    
    
    public int getVaksinValue1() {
        return vaksinValue1;
    }

    public void setVaksinValue1(int vaksinValue1) {
        this.vaksinValue1 = vaksinValue1;
    }

    public int getVaksinValue2() {
        return vaksinValue2;
    }

    public void setVaksinValue2(int vaksinValue2) {
        this.vaksinValue2 = vaksinValue2;
    }

    public int getVaksinValue3() {
        return vaksinValue3;
    }

    public void setVaksinValue3(int vaksinValue3) {
        this.vaksinValue3 = vaksinValue3;
    }

    public int getVaksinValue4() {
        return vaksinValue4;
    }

    public void setVaksinValue4(int vaksinValue4) {
        this.vaksinValue4 = vaksinValue4;
    }

    public int getVaksinValue5() {
        return vaksinValue5;
    }

    public void setVaksinValue5(int vaksinValue5) {
        this.vaksinValue5 = vaksinValue5;
    }

    public int getVaksinValue6() {
        return vaksinValue6;
    }

    public void setVaksinValue6(int vaksinValue6) {
        this.vaksinValue6 = vaksinValue6;
    }

    public int getVaksinValue7() {
        return vaksinValue7;
    }

    public void setVaksinValue7(int vaksinValue7) {
        this.vaksinValue7 = vaksinValue7;
    }

    public int getBoosterValue1() {
        return boosterValue1;
    }

    public void setBoosterValue1(int boosterValue1) {
        this.boosterValue1 = boosterValue1;
    }

    public int getBoosterValue2() {
        return boosterValue2;
    }

    public void setBoosterValue2(int boosterValue2) {
        this.boosterValue2 = boosterValue2;
    }

    public int getBoosterValue3() {
        return boosterValue3;
    }

    public void setBoosterValue3(int boosterValue3) {
        this.boosterValue3 = boosterValue3;
    }
    
}
