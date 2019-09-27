package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LivreurPageController {
    private String root = "http://localhost/smart_box_api/api/findColis/";
    private static HttpURLConnection connection;
    @FXML
    TextField colisId;
    public void getBoxFromcolis(String commune, String colis) throws IOException {
        BufferedReader reader;
        String ligne;
        StringBuilder responseContent = new StringBuilder();
        URL url = new URL("https://www.aliexpress.com/item/32949519027.html?spm=a2g0o.productlist.0.0.4ab637a27ark4f&algo_pvid=9932b71f-5c19-4230-b4ac-398ed7cc4bfe&algo_expid=9932b71f-5c19-4230-b4ac-398ed7cc4bfe-0&btsid=ee5d05cb-847a-4f49-b054-ec976b11bf70&ws_ab_test=searchweb0_0%2Csearchweb201602_5%2Csearchweb201603_53");
        connection = (HttpURLConnection) url.openConnection();
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
    }
}
