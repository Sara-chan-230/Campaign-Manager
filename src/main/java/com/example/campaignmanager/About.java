package com.example.campaignmanager;

import dbc.Classes.Organization;
import dbc.Data_base_function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class About  implements Initializable {

    @FXML
    private Text Coming;

    @FXML
    private Text Completed;

    @FXML
    private Text Descreption_org;

    @FXML
    private Button Email_org;

    @FXML
    private Button Facebook_org;

    @FXML
    private Text InProgress;

    @FXML
    private Button Instagrame_org;

    @FXML
    private Text Name_Org;

    @FXML
    private Button Phone_org;

    @FXML
    private Button X_Organization;

    @FXML
    private Circle prof;

    @FXML
    void OpenLink(ActionEvent event) {
        try {
            String url = "https://github.com/Sara-chan-230/Anaroz";
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InProgress.setText(Data_base_function.count_in_progress_campaigns(1)+"");
        Coming.setText(Data_base_function.count_camming_campaign(1)+"");
        Completed.setText(Data_base_function.count_Completed_campaign(1)+"");
        Organization org = Data_base_function.fetch_organization(1);
        Email_org.setText(org.getEmail());
        Facebook_org.setText(org.getFacebook());
        Instagrame_org.setText(org.getInstagram());
        Phone_org.setText(org.getPhone());
        Descreption_org.setText(org.getDescreption());
        Name_Org.setText(org.getName_oganization());
        X_Organization.setText(org.getTwitter());
        byte[] imageBytes = org.getLogo();
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        javafx.scene.image.Image image = new Image(inputStream);
        ImagePattern imagePattern = new ImagePattern(image);
        prof.setFill(imagePattern);

    }
}