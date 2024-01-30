package controllers;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JREmptyDataSource;

public class Ejer4 {

	@FXML
	private Button btnGenerarInforme;

	@FXML
	private Button btnLimpiar;

	@FXML
	private Button btnSalir;

	@FXML
	private TextArea txtAreaTratamiento;

	@FXML
	private TextField txtCodigoMedico;

	@FXML
	private TextField txtDireccionPaciente;

	@FXML
	private TextField txtEspecialidadMedico;

	@FXML
	private TextField txtNombreMedico;

	@FXML
	private TextField txtNombrePaciente;

	@FXML
	private TextField txtNumeroPaciente;

	@FXML
	void lanzarInforme(ActionEvent event) {
	    try {
	        Map<String, Object> parametros = crearParametros();
	        InputStream jasper = Ejer4.class.getResourceAsStream("/Ejer4.jasper");
	        
	        if (jasper == null) {
	            throw new IllegalArgumentException("El archivo del reporte no se pudo cargar. Verifique la ruta del archivo.");
	        }

	        JasperReport report = (JasperReport) JRLoader.loadObject(jasper);
	        JasperPrint jprint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
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


	private Map<String, Object> crearParametros() {
		Map<String, Object> parametros = new HashMap<String, Object>(7);

		parametros.put("NOM_MEDICO", txtNombreMedico.getText().trim());
		parametros.put("TRATAMIENTO", txtAreaTratamiento.getText().trim());
		parametros.put("ESP_MEDICO", txtEspecialidadMedico.getText().trim());
		parametros.put("NOM_PACIENTE", txtNombrePaciente.getText().trim());
		parametros.put("DIR_PACIENTE", txtDireccionPaciente.getText().trim());

		try {
			parametros.put("COD_MEDICO", Integer.parseInt(txtCodigoMedico.getText()));
			parametros.put("NUM_PACIENTE", Integer.parseInt(txtNumeroPaciente.getText()));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Codigo del medico y numero del paciente tienen que ser numericos");
		}

		return parametros;
	}

	@FXML
	void limpiarCampos(ActionEvent event) {
		txtAreaTratamiento.clear();
		txtCodigoMedico.clear();
		txtDireccionPaciente.clear();
		txtEspecialidadMedico.clear();
		txtNombreMedico.clear();
		txtNombrePaciente.clear();
		txtNumeroPaciente.clear();
	}

	@FXML
	void cerrarVentana(ActionEvent event) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

}
