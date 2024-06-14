package com.example.keuanganmahasiswa.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.keuanganmahasiswa.DatabaseConnection;
import com.example.keuanganmahasiswa.RuntimeConfiguration;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ReportController implements Initializable {
    DatabaseConnection db = new DatabaseConnection();
    Connection connection = db.getConnection();
    @FXML
    TextField masuk,keluar,total;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        count();
    }

    private void count() {
        String query = "select * from transaksi where user_id="+ RuntimeConfiguration.getLoginId();
        int masukCount = 0;
        int keluarCount = 0;
        try {
            Statement statement =  connection.createStatement();
            ResultSet output = statement.executeQuery(query);
            while (output.next()){
                if(output.getString("jenis_transaksi").equals("Masuk")){
                    masukCount += output.getInt("nominal");
                }else{
                    keluarCount += output.getInt("nominal");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        masuk.setText(String.valueOf(masukCount));
        keluar.setText(String.valueOf(keluarCount));
        total.setText(String.valueOf(masukCount-keluarCount));
    }


}
