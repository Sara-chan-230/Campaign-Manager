package com.example.campaignmanager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

import java.util.Objects;

public class ProgressCampaigns {
    @FXML
    private FlowPane container;

    @FXML
    void goToCampaign(ActionEvent event) throws Exception {
        fetch("Campaign-Mangement.fxml");
    }

    public void fetch(String fxmlFile) throws Exception {
        ScrollPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/campaignmanager/"+fxmlFile)));
        container.getChildren().setAll(content);
    }
}
