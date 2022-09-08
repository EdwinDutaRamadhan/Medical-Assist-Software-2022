/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.UserModel;
import java.util.List;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface UserInterface {

    public boolean simpanDataMahasiswa(UserModel mahasiswa);
    public boolean hapusDataMahasiswa(UserModel mahasiswa);
    public boolean gantiDataMahasiswa(UserModel mahasiswa);
    public boolean simpanDataAdminAuth(UserModel mahasiswa);
    public List<UserModel> getAll();
    public List<UserModel> showOnly(int value);
    public List<UserModel> searchData(String input);
    public boolean validation(String username, String password);
    public boolean authAdmin(String username);
    public boolean saveDataAdmin(UserModel mahasiswa);
}
