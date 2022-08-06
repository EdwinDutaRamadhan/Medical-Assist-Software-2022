/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import Connection.userConnection;
import Model.userModel;
import controller.userInterface;
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
            PreparedStatement ps = koneksi.prepareStatement("INSERT INTO tbl_mahasiswa"
            + " VALUES (?,?,?,?,?,?,?)");
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
    
}
