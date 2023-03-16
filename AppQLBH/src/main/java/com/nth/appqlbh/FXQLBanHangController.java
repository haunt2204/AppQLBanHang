/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nth.appqlbh;

import com.nth.conf.Utils;
import com.nth.pojo.LoaiSP;
import com.nth.pojo.SanPham;
import com.nth.services.CategoryService;
import com.nth.services.ProductService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXQLBanHangController implements Initializable {
    @FXML private ComboBox<LoaiSP> cbLoaiSP;
    @FXML private TextField txtMaSP;
    @FXML private TextField txtTenSP;
    @FXML private TextField txtGiaBanSP;
    @FXML private TableView<SanPham> tbView;
    @FXML private TextField txtSearch;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtMaSP.setDisable(true);
        txtMaSP.setText(UUID.randomUUID().toString());
        CategoryService c = new CategoryService();
        setFormatTbView();
        
        try {
            cbLoaiSP.setItems(FXCollections.observableArrayList(c.getLoaiSP()));
            setDataTbView(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXQLBanHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtSearch.textProperty().addListener((evt)->{
            try {
                setDataTbView(txtSearch.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FXQLBanHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    public void themSanPham(){
        SanPham sp = new SanPham(txtMaSP.getText(), txtTenSP.getText(), cbLoaiSP.getSelectionModel().getSelectedItem().getId(), Float.parseFloat(txtGiaBanSP.getText()));
        ProductService p = new ProductService();
        try {
            p.themSanPham(sp);
            System.out.println(sp.getLoaiSP());
            Utils.getBox("Thêm sản phẩm thành công!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            Utils.getBox("Thêm sản phẩm thất bại!", Alert.AlertType.ERROR).show();
        }
    }
    
    public void setFormatTbView(){
//        this.tbView.getColumns().clear();//Cẩn thận
           TableColumn colTenSanPham = new TableColumn("Tên sản phẩm");
           colTenSanPham.setCellValueFactory(new PropertyValueFactory("tenSP"));
           colTenSanPham.setPrefWidth(400);
           
           TableColumn colLoaiSP = new TableColumn("Loại sản phẩm");
           colLoaiSP.setCellValueFactory(new PropertyValueFactory("loaiSP"));
           colLoaiSP.setPrefWidth(200);
           tbView.getColumns().addAll(colTenSanPham,colLoaiSP);
    }
    
    public void setDataTbView(String kw) throws SQLException{
        ProductService p = new ProductService();
        tbView.setItems(FXCollections.observableArrayList(p.getDSSanPham(kw)));
    }
}
