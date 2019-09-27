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

public class LivreurLoginController {

    @FXML
    ComboBox<String> livreur_combo_box;
    @FXML
    Label livreur_label;
    @FXML
    TextField livreur_email;
    @FXML
    PasswordField livreur_password;
    @FXML
    Button livreur_connecter,
            livreur_retour;

    public void back_btn(ActionEvent e) throws IOException {
        changeScene(e,"client.fxml");
    }
    public void login_btn(ActionEvent e) throws IOException {
        changeScene(e,"livreur_Page.fxml");
    }
    public void changeScene(ActionEvent e, String fxml) throws IOException {

        Parent home_page_parent =   FXMLLoader.load(getClass().getResource(fxml));
        Scene home_page_scene = new Scene(home_page_parent);
        System.out.println("going to "+ fxml);
        Stage app_stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void initialize() {
        switch (Language.LANG){
            case "FRENCH":   livreur_combo_box.setValue("Francais");
            break;
            case "ARABIC": livreur_combo_box.setValue("العربية");break;
        }


        livreur_combo_box.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Francais")) {
                    Language.LANG = "FRENCH";
                } else {
                    Language.LANG = "ARABIC";
                }
            }
        });
        setLanguage();
    }
    public void setLanguage() {

        String LANG = Language.LANG;
        if (LANG.equals("FRENCH")) {
            System.out.println("changing to french");
            livreur_label.setText("Connecter a votre compte");
            livreur_retour.setText("Retour");
            livreur_email.setPromptText("Entrer votre email");
            livreur_password.setPromptText("Entrer le mot de passe");
            livreur_connecter.setText("Connecter");

        } else {





            System.out.println("changing to arabic");
            livreur_label.setText("تسجيل الدخول");
            livreur_retour.setText(" الرجوع");
            livreur_email.setPromptText(" أدخل بريدك الإلكتروني");
            livreur_password.setPromptText(" أدخل كلمة السر");
            livreur_connecter.setText("تسجيل الدخول");

        }
    }
}
