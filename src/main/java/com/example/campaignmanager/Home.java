package com.example.campaignmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.net.URI;

public class Home {
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
