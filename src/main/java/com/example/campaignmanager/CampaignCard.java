package com.example.campaignmanager;

import dbc.Classes.Campaign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CampaignCard {

    @FXML
    private Text campaign_title;

    @FXML
    private Text goal;

    @FXML
    private Text left;

    @FXML
    private ProgressBar progress;

    @FXML
    private Text raised;

    @FXML
    private Text rized_porcentage;

    @FXML
    private Pane cam_image;

    @FXML
    void goCampaign(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main-Programme.fxml"));
            MainProgramme main = fxmlLoader.load();
            Parent root = fxmlLoader.load();
            main.goToCampaign(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void setCampaign_Data(Campaign campaign){
        campaign_title.setText(campaign.getCampaign_name());
        int percentage = (int) ((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet() * 100);
        rized_porcentage.setText(percentage + "%");
        goal.setText(campaign.getNeeded_budjet()+"");
        raised.setText(campaign.getRaised_budjet()+"");
        left.setText((campaign.getNeeded_budjet()-campaign.getRaised_budjet())+"");
        progress.setProgress((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet());
        byte[] imageBytes = campaign.getCampaign_image();
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        Image image = new Image(inputStream);
        ImagePattern imagePattern = new ImagePattern(image);
        cam_image.setStyle("-fx-background-radius: 10px; -fx-background-image: " + imagePattern.toString());

    }

}
