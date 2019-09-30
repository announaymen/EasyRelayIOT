package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LivreurPageController {
    // private String root = "http://localhost/smart_box_api/api/findColis/";
    @FXML
    Label livreur_page_label1,
            livreur_page_label2,
            livreur_page_label;
    @FXML
    ComboBox<String> livreur_page_combobox;
    @FXML
    Button livreur_page_btn1, livreur_page_btn2,livreur_page_retour;
    public void back_btn(ActionEvent e) throws IOException {
        changeScene(e,"livreur_login.fxml");
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
    /* public void getBoxFromcolis(String commune, String colis) throws IOException {
         BufferedReader reader;
         String ligne;
         StringBuilder responseContent = new StringBuilder();
         URL url = new URL("https://www.aliexpress.com/item/32949519027.html?spm=a2g0o.productlist.0.0.4ab637a27ark4f&algo_pvid=9932b71f-5c19-4230-b4ac-398ed7cc4bfe&algo_expid=9932b71f-5c19-4230-b4ac-398ed7cc4bfe-0&btsid=ee5d05cb-847a-4f49-b054-ec976b11bf70&ws_ab_test=searchweb0_0%2Csearchweb201602_5%2Csearchweb201603_53");
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         {
             reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             while ((ligne = reader.readLine()) != null) {
                 responseContent.append(ligne).append("\n");
             }
         }
         System.out.println(responseContent.toString());
     }
     public void deposer_btn() throws IOException {
             String colisID=colisId.getText().trim().toString();
             String communeID="16";
             getBoxFromcolis(communeID,colisID);
     }*/
    @FXML
    public void initialize() {
        setLanguage();
        livreur_page_combobox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Francais")) {
                    Language.LANG = "FRENCH";
                } else {
                    Language.LANG = "ARABIC";
                }
                setLanguage();
            }

        });

    }
    private void setLanguage() {
        String LANG = Language.LANG;
        livreur_page_combobox.setPromptText(LANG);
        if (LANG.equals("FRENCH")) {
            livreur_page_combobox.setPromptText("Francais");
            System.out.println("changing to french");
            livreur_page_label1.setText("Sélectionner un colis a deposé");
            livreur_page_label2.setText("Sélectionner un colis a recuperé");
            livreur_page_label.setText("Déposer ou recupérer des colis");
            livreur_page_btn1.setText("Deposer le colis");
            livreur_page_btn2.setText("Recuperer les colis");
            livreur_page_retour.setText("Retour");
        } else {
            livreur_page_combobox.setPromptText("العربية");
            System.out.println("changing to arabic");
            livreur_page_label1.setText("إختر حزمة لإدخالها");
            livreur_page_label2.setText("إختر حزمة لإستلامها");
            livreur_page_btn1.setText("  إدخال الحزمة");
            livreur_page_btn2.setText(" إستخراج الحزمة");
            livreur_page_retour.setText(" الرجوع");
            livreur_page_label.setText("إدخال أو إستخراج حزمة");
        }
    }
}
