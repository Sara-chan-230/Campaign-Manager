package com.example.campaignmanager;
import dbc.DBConnection;
import dbc.Data_base_function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class Note implements Initializable {

    @FXML
    private ColorPicker color_note;

    @FXML
    private TextField note_text;

    @FXML
    private FlowPane note_container;

    @FXML
    private Text note_body;

    @FXML
    private Text note_date;

    @FXML
    void add_new_note(ActionEvent event) {

    }


    ObservableList<dbc.Classes.Note> list_note = FXCollections.observableArrayList(Data_base_function.fetch_notes(1, 2));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
        for(dbc.Classes.Note n : list_note) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Models\\note-m.fxml"));
            if (fxmlLoader.getLocation() == null) {
                System.err.println("FXML file not found: Campaign.fxml");
                return;
            }
            AnchorPane note_Box = fxmlLoader.load();
            NoteModel nm = fxmlLoader.getController();
            nm.setNote_data(n);

            note_container.getChildren().add(note_Box);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
