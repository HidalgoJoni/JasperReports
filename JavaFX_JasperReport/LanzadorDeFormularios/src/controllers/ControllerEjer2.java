package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ControllerEjer2 {

	@FXML
	private Button btnAceptar;

	@FXML
	private Button btnCancelar;

	@FXML
	private RadioButton btnPersonaCalculo;

	@FXML
	private RadioButton btnPersonas;

	@FXML
	private RadioButton btnSubinformes;

	@FXML
	void initialize() {
		ToggleGroup toggleGroup = new ToggleGroup();

		btnPersonaCalculo.setToggleGroup(toggleGroup);
		btnPersonas.setToggleGroup(toggleGroup);
		btnSubinformes.setToggleGroup(toggleGroup);

		toggleGroup.getSelectedToggle();
	}

	@FXML
	void aceptarPulsado(ActionEvent event) {
		Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/agenda";
			String user = "admin";
			String password = "dm2";

			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String ruta = "";
		if (btnPersonaCalculo.isSelected()) {
			ruta = "PersonaCalculo.jasper";
		}
		if (btnPersonas.isSelected()) {
			ruta = "Agenda.jasper";
		}
		if (btnSubinformes.isSelected()) {
			ruta = "agenda_subinformes.jasper";
		}

		try {
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/" + ruta));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, connection);
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error: " + e.getMessage());
			alert.showAndWait();
			e.printStackTrace();
		}
	}

	@FXML
	void cancelarPulsado(ActionEvent event) {
		if (!btnPersonaCalculo.isSelected() && !btnPersonas.isSelected() && !btnSubinformes.isSelected()) {
			
		} else {
			btnPersonaCalculo.setSelected(false);
			btnPersonas.setSelected(false);
			btnSubinformes.setSelected(false);
		}
	}
}
