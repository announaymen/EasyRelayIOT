package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {
    @FXML
    ComboBox<String> client_combo_box;
    @FXML
    Label client_label;
    @FXML
    TextField client_num_colis;
    @FXML
    PasswordField client_password;
    @FXML
    Button client_ok, client_livreur_btn;
    @FXML
    public void sendToActivityLivreur(ActionEvent e) throws IOException {
        changeScene(e, "livreur_login.fxml");
    }

    public void changeScene(ActionEvent e, String fxml) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource(fxml));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.close();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    public void setLanguage() {
        String LANG = Language.LANG;
        if (LANG.equals("FRENCH")) {
            System.out.println("changing to french");
            client_label.setText("Retirer ou deposer un colis");
            client_livreur_btn.setText("Êtes vous un livreur");
            client_num_colis.setPromptText("Entrer le numero de commande");
            client_password.setPromptText("Entrer le mot de passe");
            client_ok.setText("OK");
        } else {
            System.out.println("changing to arabic");
            client_label.setText(" إستلام أو إرجاع حزمة");
            client_livreur_btn.setText("  هل أنت موصل؟");
            client_num_colis.setPromptText(" أدخل رقم الحزمة");
            client_password.setPromptText("  أدخل كلمة السر");
            client_ok.setText("تم");
        }
    }
    @FXML
    public void initialize() {
        System.out.println(Language.LANG);
        client_combo_box.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Francais")) {
                    System.out.println(newValue);
                    Language.LANG = "FRENCH";
                } else {
                    System.out.println(newValue);
                    Language.LANG = "ARABIC";
                }
                setLanguage();
            }
        });
    }
}
