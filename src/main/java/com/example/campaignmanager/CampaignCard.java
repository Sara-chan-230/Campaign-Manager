package com.example.campaignmanager;

import dbc.Classes.Campaign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


import java.io.ByteArrayInputStream;
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
            // Load the FXML file for the campaign details screen
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Campaign-Management.fxml"));

            // Load the root of the new scene
            Parent root = fxmlLoader.load();

            // Assuming you have access to the BorderPane and want to update the center
            BorderPane mainLayout = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
            mainLayout.setCenter(root); // Set the new FXML content into the center of the BorderPane
            CampaignManagement controller = fxmlLoader.getController();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void setCampaign_Data(Campaign campaign) {
        System.out.println("Setting data for campaign: " + campaign.getCampaign_name());
        campaign_title.setText(campaign.getCampaign_name());
        int percentage = (int) ((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet() * 100);
        rized_porcentage.setText(percentage + "%");
        goal.setText(campaign.getNeeded_budjet() + "");
        raised.setText(campaign.getRaised_budjet() + "");
        left.setText((campaign.getNeeded_budjet() - campaign.getRaised_budjet()) + "");
        progress.setProgress((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet());

        // Check if campaign image is set correctly
        byte[] imageBytes = campaign.getCampaign_image();
        if (imageBytes != null) {
            // Convert byte array to InputStream
            InputStream inputStream = new ByteArrayInputStream(imageBytes);
            Image image = new Image(inputStream);

            // Create an ImageView for the background image
            ImageView backgroundImageView = new ImageView(image);

            // Set the fit width and height to make the image cover the entire Pane
            backgroundImageView.setFitWidth(cam_image.getWidth());
            backgroundImageView.setFitHeight(cam_image.getHeight());
            backgroundImageView.setPreserveRatio(false);  // Don't preserve ratio to fill the entire Pane

            // Apply the rounded corners (clip the image view using Rectangle with radius)
            Rectangle clip = new Rectangle(cam_image.getWidth(), cam_image.getHeight());
            clip.setArcWidth(10);  // Set the horizontal corner radius
            clip.setArcHeight(10); // Set the vertical corner radius
            backgroundImageView.setClip(clip);

            // Add the ImageView as the first child (so it stays behind the other elements)
            cam_image.getChildren().add(0, backgroundImageView);

            // Ensure the image resizes when the Pane resizes
            cam_image.widthProperty().addListener((obs, oldVal, newVal) -> {
                backgroundImageView.setFitWidth(newVal.doubleValue());
                clip.setWidth(newVal.doubleValue());
            });

            cam_image.heightProperty().addListener((obs, oldVal, newVal) -> {
                backgroundImageView.setFitHeight(newVal.doubleValue());
                clip.setHeight(newVal.doubleValue());
            });
        } else {
            System.out.println("No image available for campaign: " + campaign.getCampaign_name());
        }

    }




}
