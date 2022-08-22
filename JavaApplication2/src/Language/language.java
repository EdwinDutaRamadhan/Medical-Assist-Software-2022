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
    private String MessageDialog1, MessageDialog2,MessageDialog3,MessageDialog4,MessageDialog5;
    private String NIM , NAMA, BOOSTER, VAKSIN, VAKSIN1, VAKSIN2, VAKSIN3, VAKSIN4, VAKSIN5,Search,Mahasiswa,Dashboard,Data,Information,Other;
    private String ButtonSimpan,ButtonHapus,ButtonGanti,ButtonTambah,ButtonSearch,ButtonBrowse,ButtonExport;
    private String MessageError1,MessageError2,MessageError3,MessageError4,MessageError5,MessageError6,MessageError7,MessageError8,MessageError9,MessageError10;
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
    
    
}
