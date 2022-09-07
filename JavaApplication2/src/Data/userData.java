/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import Connection.userConnection;
import Model.userModel;
import Controller.userInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class userData implements userInterface {
    userModel mahasiswa;
    
    private Connection koneksi = null;
    public userData(){
        this.koneksi = new userConnection().getConnection();
    }
    
    @Override
    public boolean simpanDataMahasiswa(userModel mahasiswa) {
        boolean result = false;
        try{
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO tbl_mahasiswa" + " VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, mahasiswa.getNIM());
            ps.setString(2, mahasiswa.getNama());
            ps.setString(3, mahasiswa.getVaksin1());
            ps.setString(4, mahasiswa.getVaksin2());
            ps.setString(5, mahasiswa.getVaksin3());
            ps.setString(6, mahasiswa.getVaksin4());
            ps.setString(7, mahasiswa.getVaksin5());
            ps.executeUpdate();
            result = true;
        }catch(SQLException e){
            System.out.println("Button Simpan Mahasiswa Error \n" +e.getMessage());
        }
        return result;
    }

    @Override
    public List<userModel> getAll() {
        List<userModel> ls = new ArrayList<>();
        
        try {
           PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM tbl_mahasiswa");
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new userModel();
                mahasiswa.setNIM(rs.getString(1));
                mahasiswa.setNama(rs.getString(2));
                mahasiswa.setVaksin1(rs.getString(3));
                mahasiswa.setVaksin2(rs.getString(4));
                mahasiswa.setVaksin3(rs.getString(5));
                mahasiswa.setVaksin4(rs.getString(6));
                mahasiswa.setVaksin5(rs.getString(7));
                ls.add(mahasiswa);
            }            
           
        } catch (Exception e) {
            System.out.println("SELECT tbl_mahasiswa eror");
        }
        
        return ls;
    }

    @Override
    public boolean hapusDataMahasiswa(userModel mahasiswa) {
        boolean result = false;
        try {
            PreparedStatement ps = koneksi.prepareStatement("DELETE FROM tbl_mahasiswa" + " WHERE NIM=?");
            ps.setString(1, mahasiswa.getNIM());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println("Delete Error\n" + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean gantiDataMahasiswa(userModel mahasiswa) {
        boolean result = false;
        String query = ("UPDATE tbl_mahasiswa SET Nama=?, Vaksin1=?, Vaksin2=?, Vaksin3=?, Vaksin4=?, Vaksin5=? WHERE NIM=?");
        try {
            PreparedStatement ps = koneksi.prepareStatement(query);
            ps.setString(7, mahasiswa.getNIM());
            ps.setString(1, mahasiswa.getNama());
            ps.setString(2, mahasiswa.getVaksin1());
            ps.setString(3, mahasiswa.getVaksin2());
            ps.setString(4, mahasiswa.getVaksin3());
            ps.setString(5, mahasiswa.getVaksin4());
            ps.setString(6, mahasiswa.getVaksin5());
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Update Error\n" + e.getMessage());
        }
        
        return result;
    }

    @Override
    public List<userModel> showOnly(int value) {
        List<userModel> ls = new ArrayList<>();
        
        try {
           PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM tbl_mahasiswa");
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new userModel();
                mahasiswa.setNIM(rs.getString(1));
                mahasiswa.setNama(rs.getString(2));
                mahasiswa.setVaksin1(rs.getString(3));
                mahasiswa.setVaksin2(rs.getString(4));
                mahasiswa.setVaksin3(rs.getString(5));
                mahasiswa.setVaksin4(rs.getString(6));
                mahasiswa.setVaksin5(rs.getString(7));
                if (rs.getString(3).equals("-")==false && value == 1) {
                    ls.add(mahasiswa);
                }else if (rs.getString(4).equals("-")==false && value == 2) {
                    ls.add(mahasiswa);
                }else if (rs.getString(5).equals("-")==false && value == 3) {
                    ls.add(mahasiswa);
                }else if (rs.getString(6).equals("-")==false && value == 4) {
                    ls.add(mahasiswa);
                }else if (rs.getString(7).equals("-")==false && value == 5) {
                    ls.add(mahasiswa);
                }
            }            
           
        } catch (Exception e) {
            System.out.println("showonly tbl_mahasiswa eror");
        }
        
        return ls;
    }

    @Override
    public List<userModel> searchData(String input) {
        List<userModel> ls = new ArrayList<>();
        
        try {
           PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM tbl_mahasiswa WHERE NIM LIKE '%"+input+"%' OR Nama LIKE '%"+input+"%' OR Vaksin1 LIKE '%"+input+"%' OR Vaksin2 LIKE '%"+input+"%' OR Vaksin3 LIKE '%"+input+"%' OR Vaksin4 LIKE '%"+input+"%' OR Vaksin5 LIKE '%"+input+"%'");
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new userModel();
                mahasiswa.setNIM(rs.getString(1));
                mahasiswa.setNama(rs.getString(2));
                mahasiswa.setVaksin1(rs.getString(3));
                mahasiswa.setVaksin2(rs.getString(4));
                mahasiswa.setVaksin3(rs.getString(5));
                mahasiswa.setVaksin4(rs.getString(6));
                mahasiswa.setVaksin5(rs.getString(7));
                ls.add(mahasiswa);
            }            
           
        } catch (Exception e) {
            System.out.println("Search eror");
        }
        
        return ls;
    }

    @Override
    public boolean validation(String username, String password) {
       boolean valid = false;
        try {
           PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM tbl_admin");
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new userModel();
                if (rs.getString(1).equals(username)&&(rs.getString(2).equals(password))) {
                    valid = true;
                }
                                
            }            
           
        } catch (Exception e) {
            System.out.println("Search eror");
        }
        return valid;
    }

    @Override
    public boolean simpanDataAdminAuth(userModel mahasiswa) {
        boolean result = false;
        try{
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO tbl_auth" + " VALUES (?,?)");
            ps.setString(1, mahasiswa.getUsername());
            ps.setString(2, mahasiswa.getPassword());
            ps.executeUpdate();
            result = true;
        }catch(SQLException e){
            System.out.println("Button Simpan admin Error \n" +e.getMessage());
        }
        return result;
    }

    @Override
    public boolean authAdmin(String username) {
        boolean valid = false;
        try {
           PreparedStatement ps = koneksi.prepareStatement("SELECT * FROM tbl_admin");
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mahasiswa = new userModel();
                if (rs.getString(1).equals(username)) {
                    mahasiswa.setUsernameAuth(rs.getString(1));
                    mahasiswa.setPasswordAuth(rs.getString(2));
                    valid = true;
                }
                                
            }            
           
        } catch (Exception e) {
            System.out.println("auth admin eror");
        }
        return valid;
    }

    @Override
    public boolean saveDataAdmin(userModel mahasiswa) {
         boolean result = false;
        try{
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO tbl_admin" + " VALUES (?,?)");
            ps.setString(1, mahasiswa.getUsername());
            ps.setString(2, mahasiswa.getPassword());
            ps.executeUpdate();
            result = true;
        }catch(SQLException e){
            System.out.println("save data admin error \n" +e.getMessage());
        }
        return result;
    }


}  
