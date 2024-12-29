package com.example.campaignmanager;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.awt.*;
import java.net.URI;
import java.util.Objects;

public class MainProgramme{
    @FXML
    private BorderPane campaignManager;


    @FXML
    public void OpenLink(ActionEvent event) {
        try {
            String url = "https://github.com/Sara-chan-230/Anaroz";
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void goAbout(ActionEvent event) throws Exception {
        navigate("About.fxml");

    }

    @FXML
    public void goComplete(ActionEvent event) throws Exception {
        navigate("Completed-Campaigns.fxml");
    }

    @FXML
    public void goDarft(ActionEvent event) throws Exception {
        navigate("Draft-Campaigns.fxml");
    }

    @FXML
    public void goHome(ActionEvent event) throws Exception {
        navigate("Home.fxml");
    }

    @FXML
    public void goProgress(ActionEvent event) throws Exception {
        navigate("Campaign-Mangement.fxml");

    }
    @FXML
    void goToCampaign(ActionEvent event) throws Exception {
       navigate("Campaign-Mangement.fxml");
    }

    public void navigate(String fxmlFile) throws Exception {
            ScrollPane scrollPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/campaignmanager/"+fxmlFile)));
            campaignManager.setCenter(scrollPane);
    }
}
