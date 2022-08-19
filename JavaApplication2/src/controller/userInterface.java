/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Model.userModel;
import java.util.List;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface userInterface {

    public boolean simpanDataMahasiswa(userModel mahasiswa);
    public boolean hapusDataMahasiswa(userModel mahasiswa);
    public boolean gantiDataMahasiswa(userModel mahasiswa);
    public List<userModel> getAll();
    public List<userModel> showOnly(int value);
    public List<userModel> searchData(String input);
}
