package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ejer3 {

    @FXML
    private Button btnG, btnP, btnS, btnT;

    @FXML
    private Tab pestaniaG, pestaniaP, pestaniaS, pestaniaT;

    @FXML
    void pestania1(ActionEvent event) {
        manejarReporte("/Ejer3_3.jasper");
    }

    @FXML
    void pestania2(ActionEvent event) {
        manejarReporte("/Ejer3_2.jasper");
    }

    @FXML
    void pestania3(ActionEvent event) {
        manejarReporte("/Ejer3_1.jasper");
    }

    @FXML
    void pestania4(ActionEvent event) {
        manejarReporte("/Ejer3_4.jasper");
    }

    private void manejarReporte(String reportPath) {
        try (Connection connection = obtenerConexion()) {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(reportPath));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            mostrarError();
            e.printStackTrace();
        }
    }

    private Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/supermercado";
        String user = "admin";
        String password = "dm2";
        return DriverManager.getConnection(url, user, password);
    }

    private void mostrarError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        alert.setContentText("Ha ocurrido un error");
        alert.showAndWait();
    }
}
