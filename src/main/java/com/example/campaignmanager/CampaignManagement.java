package com.example.campaignmanager;

import dbc.Classes.Campaign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class CampaignManagement {

    @FXML
    private Text c_date;

    @FXML
    private Text c_descreption;

    @FXML
    private Rectangle c_image;

    @FXML
    private Text c_title;

    @FXML
    private Text goal;

    @FXML
    private Text left;

    @FXML
    private Text raised;
    @FXML
    private AnchorPane change_container;
    @FXML
    private Button resource;
    @FXML
    private Button task;
    @FXML
    private Button note;


    @FXML
    void fetch_note(ActionEvent event) throws Exception {
        fetch("note.fxml");
    }

    @FXML
    void fetch_resourses(ActionEvent event) throws Exception {
        fetch("resourse.fxml");
    }

    @FXML
    void fetch_todo(ActionEvent event)  throws Exception {
        fetch("task.fxml");
    }
    public void fetch(String fxmlFile) throws Exception {
        ScrollPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/campaignmanager/Models/"+fxmlFile)));
        change_container.getChildren().setAll(content);
    }

    public void set_data(Campaign campaign){
        c_date.setText(campaign.getCampaign_date()+"");
        c_descreption.setText(campaign.getCampaign_description());
        c_title.setText(campaign.getCampaign_name());
        goal.setText((int)(campaign.getNeeded_budjet()/1000)+"K");
        raised.setText((int)(campaign.getRaised_budjet()/1000)+"K");
        left.setText((int)((campaign.getNeeded_budjet()-campaign.getRaised_budjet())/1000)+"K");
        byte[] imageBytes = campaign.getCampaign_image();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
        Image image = new Image(byteArrayInputStream);
        ImagePattern imagePattern = new ImagePattern(image);
        c_image.setFill(imagePattern);
    }

}
