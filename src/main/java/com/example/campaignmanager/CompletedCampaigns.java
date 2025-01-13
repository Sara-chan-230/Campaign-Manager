package com.example.campaignmanager;
import dbc.Classes.Campaign;
import dbc.Data_base_function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CompletedCampaigns implements Initializable {
    @FXML
    private FlowPane container;

    ObservableList<Campaign> cam_list = FXCollections.observableArrayList(Data_base_function.fetch_completed_campaigns(3));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for(Campaign campaign : cam_list) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Campaign.fxml"));
                CampaignCard cam = fxmlLoader.getController();
                cam.setCampaign_Data(campaign);
                AnchorPane contain = fxmlLoader.load();
                container.getChildren().add(contain);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
