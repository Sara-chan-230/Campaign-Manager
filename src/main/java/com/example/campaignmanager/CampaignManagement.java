package com.example.campaignmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class CampaignManagement {

    @FXML
    private Text c_date;

    @FXML
    private Text c_descreption;

    @FXML
    private Pane c_image;

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
        AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/campaignmanager/Models/"+fxmlFile)));
        change_container.getChildren().setAll(content);
    }

}
