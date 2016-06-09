package view;

import controller.SistemaTiempos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Empresa;
import model.Lugar;
import model.Movimiento;
import model.Tarea;

import java.sql.Date;
import java.util.Calendar;

public class FrmMovimientos {
    @FXML
    private Label lblUsuario;
    @FXML
    private DatePicker dtpFecha;
    @FXML
    private ComboBox<Empresa> cboEmpresa;
    @FXML
    private ComboBox<Lugar> cboLugar;
    @FXML
    private ComboBox<Tarea> cboTarea;
    @FXML
    private TextField txtDetalle, txtComentario, txtHoras;
    @FXML
    private TableView<Movimiento> tblMovimientos;
    @FXML
    private TableColumn<Movimiento, Integer> colIdMovimiento;
    @FXML
    private TableColumn<Movimiento, Date> colFecha;
    @FXML
    private TableColumn<Movimiento, Empresa> colEmpresa;
    @FXML
    private TableColumn<Movimiento, Lugar> colLugar;
    @FXML
    private TableColumn<Movimiento, Tarea> colTarea;
    @FXML
    private TableColumn<Movimiento, String> colDetalle;
    @FXML
    private TableColumn<Movimiento, String> colComentario;
    @FXML
    private TableColumn<Movimiento, Double> colHoras;

    private SistemaTiempos sistema;
    private ObservableList<Movimiento> movimientos;

    public void initialize() {
        sistema = SistemaTiempos.getInstancia();

        movimientos = FXCollections.observableArrayList();

        lblUsuario.setText(sistema.getUsuarioLogueado().getUsername());

        cboEmpresa.getItems().addAll(sistema.getEmpresas());
        cboLugar.getItems().addAll(sistema.getLugares());
        cboTarea.getItems().addAll(sistema.getTareas());

        configurarTableViewMovimientos();
        cargarMovimientos();
    }

    private void configurarTableViewMovimientos() {
        colIdMovimiento.setCellValueFactory(new PropertyValueFactory<>("idMovimiento"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colTarea.setCellValueFactory(new PropertyValueFactory<>("tarea"));
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        colComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));
        colHoras.setCellValueFactory(new PropertyValueFactory<>("horas"));

        tblMovimientos.setItems(movimientos);
    }

    private void cargarMovimientos() {
        movimientos.addAll(sistema.getUsuarioLogueado().getMovimientos());
    }
}
