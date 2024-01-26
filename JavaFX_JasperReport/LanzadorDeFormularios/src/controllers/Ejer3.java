package controllers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ejer3 {



	@FXML
    private Button btnG;

    @FXML
    private Button btnP;

    @FXML
    private Button btnS;

    @FXML
    private Button btnT;

    @FXML
    private Tab pestaniaG;

    @FXML
    private Tab pestaniaP;

    @FXML
    private Tab pestaniaS;

    @FXML
    private Tab pestaniaT;

    
    @FXML
	void initialize() {
    	
	}
    @FXML
    void pestania1(ActionEvent event) {
    	
    	Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/supermercado";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Ejer3_3.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void pestania2(ActionEvent event) {
    	
    	Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/supermercado";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Ejer3_2.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void pestania3(ActionEvent event) {
    	
    	Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/supermercado";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Ejer3_1.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void pestania4(ActionEvent event) throws SQLException {
    	
    	Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/supermercado";
			String user = "javauser";
			String password = "Javajava0";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Ejer3_4.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error");
			alert.showAndWait();
			e.printStackTrace();
		}
		 connection.close();
    }

   
	
	void salir(ActionEvent event) {
		((Stage)((Node)event.getSource()).getScene().getWindow()).close();
	}
}

