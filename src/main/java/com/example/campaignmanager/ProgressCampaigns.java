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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgressCampaigns implements Initializable {
    @FXML
    private FlowPane container;

    ObservableList<Campaign> cam_list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("intializing ProgressCampaigns");
        try {

            cam_list.addAll(Data_base_function.fetch_in_progess_campaigns(1));


            for (Campaign campaign : cam_list) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Models\\Campaign.fxml"));
                if (fxmlLoader.getLocation() == null) {
                    System.err.println("FXML file not found: Campaign.fxml");
                    return;
                }
                AnchorPane contain = fxmlLoader.load();
                CampaignCard cam = fxmlLoader.getController();
                cam.setCampaign_Data(campaign);
                container.getChildren().add(contain);
            }
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
