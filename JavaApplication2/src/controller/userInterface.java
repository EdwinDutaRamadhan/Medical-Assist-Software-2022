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

    public boolean simpanDataMahasiswa(userModel player);
    public List<userModel> getAll();
}
