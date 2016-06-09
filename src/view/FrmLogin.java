package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import controller.SistemaTiempos;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class FrmLogin {
    @FXML
    private TextField txtUsername, txtPassword;
    @FXML
    private Button btnLogin;

    private SistemaTiempos sistema;

    public void initialize() {
        sistema = SistemaTiempos.getInstancia();
    }

    @FXML
    private void btnLoginOnClick(ActionEvent event) {
        if (sistema.login(txtUsername.getText(), txtPassword.getText())) {
            loadFrmMovimientos(event);
        }
        else {

        }
    }

    private void loadFrmMovimientos(ActionEvent event) {
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("FrmMovimientos.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Movimientos");
            stage.setScene(new Scene(parent, 900, 400));
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
