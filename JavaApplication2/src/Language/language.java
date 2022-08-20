/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Language;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class language {
    private String MessageInputProtection1,MessageInputProtection2,MessageInputProtection3;  
    private String NIM , NAMA, BOOSTER, VAKSIN, VAKSIN1, VAKSIN2, VAKSIN3, VAKSIN4, VAKSIN5,Search,Mahasiswa,Dashboard,Data,About;
    private String ButtonSimpan,ButtonHapus,ButtonGanti,ButtonTambah,ButtonSearch,ButtonBrowse,ButtonExport;
    public void setLanguage(String bahasa) {
        switch (bahasa) {
            case "Indonesia":
                //=====Message=====
                this.MessageInputProtection1 = "Masukkan NIM terlebih dahulu";
                this.MessageInputProtection2 = "Masukkan Nama terlebih dahulu";
                this.MessageInputProtection3 = "Masukkan NIM dan Nama Terlebih dahulu";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Nama";
                this.VAKSIN1 = "Vaksin 1";
                this.VAKSIN2 = "Vaksin 2";
                this.VAKSIN3 = "Booster 1";
                this.VAKSIN4 = "Booster 2";
                this.VAKSIN5 = "Booster 3";
                this.VAKSIN = "Vaksin";
                this.BOOSTER = "Booster";
                this.Search = "Cari";
                this.Mahasiswa = "Mahasiswa";
                this.Dashboard = "Dasbor";
                this.Data = "Data";
                this.About = "Tentang";
                //=====Button=====
                this.ButtonSimpan = "Simpan";
                this.ButtonHapus = "Hapus";
                this.ButtonGanti = "Ganti";
                this.ButtonTambah = "Tambah";
                this.ButtonSearch = "Cari";
                this.ButtonBrowse = "Jelajahi";
                this.ButtonExport = "Ekspor";
                break;
            case "English":
                //=====Message=====
                this.MessageInputProtection1 = "Enter NIM first";
                this.MessageInputProtection2 = "Enter a Name first";
                this.MessageInputProtection3 = "Enter NIM and Name First";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Name";
                this.VAKSIN1 = "Vaccine 1";
                this.VAKSIN2 = "Vaccine 2";
                this.VAKSIN3 = "Booster 1";
                this.VAKSIN4 = "Booster 2";
                this.VAKSIN5 = "Booster 3";
                this.VAKSIN = "Vaccine";
                this.BOOSTER = "Booster";
                this.Search = "Search";
                this.Mahasiswa = "Student";
                this.Dashboard = "Dashboard";
                this.Data = "Data";
                this.About = "About";
                //=====Button=====
                this.ButtonSimpan = "Save";
                this.ButtonHapus = "Delete";
                this.ButtonGanti = "Change";
                this.ButtonTambah = "Add";
                this.ButtonSearch = "Search";
                this.ButtonBrowse = "Browse";
                this.ButtonExport = "Eksport";
                break;
            case "Rusia":
                //=====Message=====
                this.MessageInputProtection1 = "Сначала введите свой NIM";
                this.MessageInputProtection2 = "Сначала введите имя";
                this.MessageInputProtection3 = "Сначала введите NIM и имя";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Имя";
                this.VAKSIN1 = "вакцина 1";
                this.VAKSIN2 = "вакцина 2";
                this.VAKSIN3 = "Бустеры 1";
                this.VAKSIN4 = "Бустеры 2";
                this.VAKSIN5 = "Бустеры 3";
                this.VAKSIN = "вакцина";
                this.BOOSTER = "Бустеры";
                this.Search = "Поиск";
                this.Mahasiswa = "Ученик";
                this.Dashboard = "Приборная доска";
                this.Data = "Данные";
                this.About = "около";
                //=====Button=====
                this.ButtonSimpan = "Симпан";
                this.ButtonHapus = "Гапус";
                this.ButtonGanti = "Изменять";
                this.ButtonTambah = "Тамба";
                this.ButtonSearch = "Поиск";
                this.ButtonBrowse = "пролистать";
                this.ButtonExport = "Экспорт";
                break;
        }
    }

    public String getMessageInputProtection1() {return MessageInputProtection1;}
    public String getMessageInputProtection2() {return MessageInputProtection2;}
    public String getMessageInputProtection3() {return MessageInputProtection3;}
    public String getNIM() {return NIM;}
    public String getNAMA() {return NAMA;}
    public String getVAKSIN1() {return VAKSIN1;}
    public String getVAKSIN2() {return VAKSIN2;}
    public String getVAKSIN3() {return VAKSIN3;}
    public String getVAKSIN4() {return VAKSIN4;}
    public String getVAKSIN5() {return VAKSIN5;}
    public String getBOOSTER() {return BOOSTER;}
    public String getVAKSIN() {return VAKSIN;}
    public String getButtonSimpan() {return ButtonSimpan;}
    public String getButtonHapus() {return ButtonHapus;}
    public String getButtonGanti() {return ButtonGanti;}
    public String getButtonTambah() {return ButtonTambah;}
    public String getButtonSearch() {return ButtonSearch;}
    public String getButtonBrowse() {return ButtonBrowse;}
    public String getButtonExport() {return ButtonExport;}
    public String getSearch() {return Search;}
    public String getMahasiswa() {return Mahasiswa;}
    public String getDashboard() {return Dashboard;}
    public String getData() {return Data; }
    public String getAbout() {return About;}
}
