package com.example.campaignmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;

public class About {

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

}