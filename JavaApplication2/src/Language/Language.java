/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Language;

import Storage.InformationData;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Language {
    private String MessageInputProtection1,MessageInputProtection2,MessageInputProtection3; 
    private String MessageDialog1, MessageDialog2,MessageDialog3,MessageDialog4,MessageDialog5;
    private String NIM , NAMA, BOOSTER, VAKSIN, VAKSIN1, VAKSIN2, VAKSIN3, VAKSIN4, VAKSIN5,Search,Mahasiswa,Dashboard,Data,Information,Other;
    private String ButtonSimpan,ButtonHapus,ButtonGanti,ButtonTambah,ButtonSearch,ButtonBrowse,ButtonExport;
    private String MessageError1,MessageError2,MessageError3,MessageError4,MessageError5,MessageError6,MessageError7,MessageError8,MessageError9,MessageError10;
    private String cardTitle1,cardTitle2,cardTitle3,cardTitle4,cardDesc1,cardDesc2,cardDesc3,cardDesc4;

    
    public void setLanguage(String bahasa) {
        switch (bahasa) {
            case "Indonesia":
                //=====Message=====
                this.MessageInputProtection1 = "Masukkan NIM terlebih dahulu";
                this.MessageInputProtection2 = "Masukkan Nama terlebih dahulu";
                this.MessageInputProtection3 = "Masukkan NIM dan Nama Terlebih dahulu";
                this.MessageDialog1 = "Berhasil ";
                this.MessageDialog2 = "Gagal ";
                this.MessageDialog3 = "Menambah ";
                this.MessageDialog4 = "Mengganti ";
                this.MessageDialog5 = "Menghapus ";
                this.MessageError1 = "NIM tidak dapat diduplikat";
                this.MessageError2 = "Pilih data yang ingin dihapus";
                this.MessageError3 = "Pilih data yang ingin diganti";
                this.MessageError4 = "Export PDF tidak perlu isi alamat file";
                this.MessageError5 = "Tidak ada data yang bisa di-eksport";
                this.MessageError6 = "Pilih lokasi export terlebih dahulu";
                this.MessageError7 = "Berhasil export .txt";
                this.MessageError8 = "Berhasil export .xlsx";
                this.MessageError9 = "Isi textfield search terlebih dahulu";
                this.MessageError10 = "Data yang dicari tidak ditemukan";
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
                this.Other = "Lainnya";
                //=====Button=====
                this.ButtonSimpan = "Simpan";
                this.ButtonHapus = "Hapus";
                this.ButtonGanti = "Ganti";
                this.ButtonTambah = "Tambah";
                this.ButtonSearch = "Cari";
                this.ButtonBrowse = "Jelajahi";
                this.ButtonExport = "Ekspor";
                this.Information = "Informasi";
                //=====About Card=====
                this.cardTitle1 = "Versi Pertama";
                this.cardTitle2 = "Versi Kedua";
                this.cardTitle3 = "Tema";
                this.cardTitle4 = "Program";
                this.cardDesc1 = "Non-MVC, UI Lama, Program Simpel";
                this.cardDesc2 = "MVC, UI Baru, Program Kompleks";
                this.cardDesc3 = "Assisten Aplikasi";
                this.cardDesc4 = "Pemrograman Desktop";
                break;
            case "English":
                //=====Message=====
                this.MessageInputProtection1 = "Enter NIM first";
                this.MessageInputProtection2 = "Enter a Name first";
                this.MessageInputProtection3 = "Enter NIM and Name First";
                this.MessageDialog1 = "Succeed ";
                this.MessageDialog2 = "Fail ";
                this.MessageDialog3 = "Add ";
                this.MessageDialog4 = "Replace ";
                this.MessageDialog5 = "Delete ";
                this.MessageError1 = "NIM cannot be duplicated";
                this.MessageError2 = "Select the data you want to delete";
                this.MessageError3 = "Select the data you want to replace";
                this.MessageError4 = "Export PDF no need to fill in the file address";
                this.MessageError5 = "No data can be exported";
                this.MessageError6 = "Choose the export location first";
                this.MessageError7 = "Successful export .txt";
                this.MessageError8 = "Successful export .xlsx";
                this.MessageError9 = "Fill in the search textfield first";
                this.MessageError10 = "The data you are looking for is not found";
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
                this.Other = "Other";
                //=====Button=====
                this.ButtonSimpan = "Save";
                this.ButtonHapus = "Delete";
                this.ButtonGanti = "Change";
                this.ButtonTambah = "Add";
                this.ButtonSearch = "Search";
                this.ButtonBrowse = "Browse";
                this.ButtonExport = "Eksport";
                this.Information = "Information";
                //=====About Card=====
                this.cardTitle1 = "First Version";
                this.cardTitle2 = "Second Version";
                this.cardTitle3 = "Theme";
                this.cardTitle4 = "Program";
                this.cardDesc1 = "Non-MVC, Old UI, Simple Program";
                this.cardDesc2 = "MVC, New UI, Complex Program";
                this.cardDesc3 = "Software Assistant";
                this.cardDesc4 = "Desktop Programming";
                
                break;
            case "Spanish":
                //=====Message=====
                this.MessageInputProtection1 = "Introduzca NIM primero";
                this.MessageInputProtection2 = "Ingrese un nombre primero";
                this.MessageInputProtection3 = "Ingrese NIM y nombre primero";
                this.MessageDialog1 = "Éxito ";
                this.MessageDialog2 = "Expediente ";
                this.MessageDialog3 = "Agregar ";
                this.MessageDialog4 = "Reemplazar ";
                this.MessageDialog5 = "Borrar ";
                this.MessageError1 = "NIM no se puede duplicar";
                this.MessageError2 = "Seleccione los datos que desea eliminar";
                this.MessageError3 = "Seleccione los datos que desea reemplazar";
                this.MessageError4 = "Exportar PDF sin necesidad de completar la dirección del archivo";
                this.MessageError5 = "No se pueden exportar datos";
                this.MessageError6 = "Elija primero la ubicación de exportación";
                this.MessageError7 = "Exportación exitosa .txt";
                this.MessageError8 = "Exportación exitosa .xlsx";
                this.MessageError9 = "Complete el campo de texto de búsqueda primero";
                this.MessageError10 = "Los datos que busca no se encuentran";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Nombre";
                this.VAKSIN1 = "Vacuna 1";
                this.VAKSIN2 = "Vacuna 2";
                this.VAKSIN3 = "Refuerzo 1";
                this.VAKSIN4 = "Refuerzo 2";
                this.VAKSIN5 = "Refuerzo 3";
                this.VAKSIN = "Vacuna";
                this.BOOSTER = "Refuerzo";
                this.Search = "Búsqueda";
                this.Mahasiswa = "Alumno";
                this.Dashboard = "Tablero";
                this.Data = "Datos";
                this.Other = "Otro";
                //=====Button=====
                this.ButtonSimpan = "Ahorrar";
                this.ButtonHapus = "Borrar";
                this.ButtonGanti = "Cambio";
                this.ButtonTambah = "Agregar";
                this.ButtonSearch = "Búsqueda";
                this.ButtonBrowse = "Navegar";
                this.ButtonExport = "Eksport";
                this.Information = "información";
                //=====About Card=====
                this.cardTitle1 = "Primera versión";
                this.cardTitle2 = "Segunda versión";
                this.cardTitle3 = "Tema";
                this.cardTitle4 = "Programa";
                this.cardDesc1 = "Non-MVC, Antiguo UI, Programa Sencillo";
                this.cardDesc2 = "MVC, Nuevo UI, Programas Complejos";
                this.cardDesc3 = "Asistente de software";
                this.cardDesc4 = "Programación de escritorio";
                break;
             case "Germany":
                //=====Message=====
                this.MessageInputProtection1 = "Geben Sie zuerst NIM ein";
                this.MessageInputProtection2 = "Geben Sie zuerst einen Namen ein";
                this.MessageInputProtection3 = "Geben Sie zuerst NIM und Name ein";
                this.MessageDialog1 = "Erfolgreich ";
                this.MessageDialog2 = "Scheitern ";
                this.MessageDialog3 = "Hinzufügen ";
                this.MessageDialog4 = "Ersetzen ";
                this.MessageDialog5 = "Löschen ";
                this.MessageError1 = "NIM kann nicht dupliziert werden";
                this.MessageError2 = "Wählen Sie die Daten aus, die Sie löschen möchten";
                this.MessageError3 = "Wählen Sie die Daten aus, die Sie ersetzen möchten";
                this.MessageError4 = "Exportieren Sie PDF, ohne dass Sie die Dateiadresse eingeben müssen";
                this.MessageError5 = "Es können keine Daten exportiert werden";
                this.MessageError6 = "Wählen Sie zuerst den Exportspeicherort aus";
                this.MessageError7 = "Erfolgreicher Export .txt";
                this.MessageError8 = "Erfolgreicher Export .xlsx";
                this.MessageError9 = "Füllen Sie zuerst das Suchtextfeld aus";
                this.MessageError10 = "Die gesuchten Daten wurden nicht gefunden";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Name";
                this.VAKSIN1 = "Impfung 1";
                this.VAKSIN2 = "Impfung 2";
                this.VAKSIN3 = "Booster 1";
                this.VAKSIN4 = "Booster 2";
                this.VAKSIN5 = "Booster 3";
                this.VAKSIN = "Impfung";
                this.BOOSTER = "Booster";
                this.Search = "Suche";
                this.Mahasiswa = "Student";
                this.Dashboard = "Armaturenbrett";
                this.Data = "Daten";
                this.Other = "Sonstiges";
                //=====Button=====
                this.ButtonSimpan = "Speichern";
                this.ButtonHapus = "Löschen";
                this.ButtonGanti = "Veränderung";
                this.ButtonTambah = "Hinzufügen";
                this.ButtonSearch = "Suche";
                this.ButtonBrowse = "Durchsuche";
                this.ButtonExport = "Eksport";
                this.Information = "Information";
                //=====About Card=====
                this.cardTitle1 = "Erste Version";
                this.cardTitle2 = "Zweite Fassung";
                this.cardTitle3 = "Thema";
                this.cardTitle4 = "Programm";
                this.cardDesc1 = "Non-MVC, Alt UI, Einfaches Programm";
                this.cardDesc2 = "MVC, Neu UI, Komplexes Programm";
                this.cardDesc3 = "Software-Assistant";
                this.cardDesc4 = "Desktop-Programmierung";
                
                break;
            case "Poland":
                //=====Message=====
                this.MessageInputProtection1 = "Wpisz NIM jako pierwszy";
                this.MessageInputProtection2 = "Najpierw wpisz imię";
                this.MessageInputProtection3 = "Wprowadź NIM i imię i nazwisko";
                this.MessageDialog1 = "Odnieść sukces ";
                this.MessageDialog2 = "Ponieść porażkę ";
                this.MessageDialog3 = "Dodać ";
                this.MessageDialog4 = "Zastępować ";
                this.MessageDialog5 = "Usuwać ";
                this.MessageError1 = "NIM nie może być duplikowany";
                this.MessageError2 = "Wybierz dane, które chcesz usunąć";
                this.MessageError3 = "Wybierz dane, które chcesz zastąpić";
                this.MessageError4 = "Eksportuj PDF bez konieczności wpisywania adresu pliku";
                this.MessageError5 = "Żadne dane nie mogą być eksportowane";
                this.MessageError6 = "Najpierw wybierz lokalizację eksportu";
                this.MessageError7 = "Udany eksport .txt";
                this.MessageError8 = "Udany eksport .xlsx";
                this.MessageError9 = "Wypełnij najpierw pole tekstowe wyszukiwania";
                this.MessageError10 = "Nie znaleziono danych, których szukasz";
                //=====Label=====
                this.NIM = "NIM";
                this.NAMA = "Nazwa";
                this.VAKSIN1 = "Szczepionka 1";
                this.VAKSIN2 = "Szczepionka 2";
                this.VAKSIN3 = "Wzmacniacz 1";
                this.VAKSIN4 = "Wzmacniacz 2";
                this.VAKSIN5 = "Wzmacniacz 3";
                this.VAKSIN = "Szczepionka";
                this.BOOSTER = "Wzmacniacz";
                this.Search = "Szukaj";
                this.Mahasiswa = "Student";
                this.Dashboard = "Panel";
                this.Data = "Dane";
                this.Other = "Inny";
                //=====Button=====
                this.ButtonSimpan = "Ratować";
                this.ButtonHapus = "Usuwać";
                this.ButtonGanti = "Zmiana";
                this.ButtonTambah = "Dodać";
                this.ButtonSearch = "Szukaj";
                this.ButtonBrowse = "Przeglądaj";
                this.ButtonExport = "Eksportuj";
                this.Information = "Informacja";
                //=====About Card=====
                this.cardTitle1 = "Pierwsza wersja";
                this.cardTitle2 = "Druga wersja";
                this.cardTitle3 = "Motyw";
                this.cardTitle4 = "Program";
                this.cardDesc1 = "Non-MVC, Stary UI, Prosty program";
                this.cardDesc2 = "MVC, Nowy UI, Kompleksowy program";
                this.cardDesc3 = "Asystent oprogramowania";
                this.cardDesc4 = "Programowanie pulpitu";
                
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
    public String getMessageDialog1() {return MessageDialog1;}
    public String getMessageDialog2() {return MessageDialog2;}
    public String getMessageDialog3() {return MessageDialog3;}
    public String getMessageDialog4() {return MessageDialog4;}
    public String getMessageDialog5() {return MessageDialog5;}
    public String getMessageError1() {return MessageError1;}
    public String getMessageError2() {return MessageError2;}
    public String getMessageError3() {return MessageError3;}
    public String getMessageError4() {return MessageError4;}
    public String getMessageError5() {return MessageError5;}
    public String getMessageError6() {return MessageError6;}
    public String getMessageError7() {return MessageError7;}
    public String getMessageError8() {return MessageError8;}
    public String getMessageError9() {return MessageError9;}
    public String getMessageError10() {return MessageError10;}
    public String getInformation() {return Information;}
    public String getOther() {return Other;}
    public String getCardTitle1() {return cardTitle1;}
    public String getCardTitle2() {return cardTitle2;}
    public String getCardTitle3() {return cardTitle3;}
    public String getCardTitle4() {return cardTitle4;}
    public String getCardDesc1() {return cardDesc1;}
    public String getCardDesc2() {return cardDesc2;}
    public String getCardDesc3() {return cardDesc3;}
    public String getCardDesc4() {return cardDesc4;}
    
    
}
