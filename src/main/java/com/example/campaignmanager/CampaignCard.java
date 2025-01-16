package com.example.campaignmanager;

import dbc.Classes.Campaign;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CampaignCard   {

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
    private Button go;


    void oppent_new_scene(Campaign campaign) throws IOException {
        Stage stage = new Stage();

        Image icon = new Image("file:C:\\Users\\ADM\\IdeaProjects\\Campaign Manager\\src\\main\\java\\com\\example\\campaignmanager\\idea.png");
        if (icon.isError()) {
            System.out.println("Error loading icon!");
        } else {
            stage.getIcons().add(icon);
        }
        stage.setTitle("Campaign Management");
        FXMLLoader fx = new FXMLLoader(getClass().getResource("Campaign-Mangement.fxml"));
        Parent root = fx.load();
        CampaignManagement controller = fx.getController();
        controller.set_data(campaign);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setCampaign_Data(Campaign campaign) {
        System.out.println("Setting data for campaign: " + campaign.getCampaign_name());
        campaign_title.setText(campaign.getCampaign_name());
        int percentage = (int) ((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet() * 100);
        rized_porcentage.setText(percentage + "%");
        goal.setText(campaign.getNeeded_budjet() + "");
        raised.setText(campaign.getRaised_budjet() + "");
        left.setText((campaign.getNeeded_budjet() - campaign.getRaised_budjet()) + "");
        progress.setProgress((double) campaign.getRaised_budjet() / campaign.getNeeded_budjet());

        byte[] imageBytes = campaign.getCampaign_image();
        if (imageBytes != null) {
            InputStream inputStream = new ByteArrayInputStream(imageBytes);
            Image image = new Image(inputStream);
            ImageView backgroundImageView = new ImageView(image);
            backgroundImageView.setFitWidth(cam_image.getWidth());
            backgroundImageView.setFitHeight(cam_image.getHeight());
            backgroundImageView.setPreserveRatio(false);
            Rectangle clip = new Rectangle(cam_image.getWidth(), cam_image.getHeight());
            clip.setArcWidth(10);
            clip.setArcHeight(10);
            backgroundImageView.setClip(clip);
            cam_image.getChildren().add(0, backgroundImageView);
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

    public Button getGo() {
        return go;
    }
}
