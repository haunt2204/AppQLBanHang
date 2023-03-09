/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nth.appqlbh;

import com.nth.pojo.LoaiSP;
import com.nth.services.CategoryService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXQLBanHangController implements Initializable {
    @FXML private ComboBox<LoaiSP> cbLoaiSP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CategoryService c = new CategoryService();
        try {
            cbLoaiSP.setItems(FXCollections.observableArrayList(c.getLoaiSP()));
        } catch (SQLException ex) {
            Logger.getLogger(FXQLBanHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
