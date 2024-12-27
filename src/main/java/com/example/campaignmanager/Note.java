package com.example.campaignmanager;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Note {

    @FXML
    private ColorPicker color_note;

    @FXML
    private TextField note_text;

    @FXML
    private GridPane note_container;

    @FXML
    void add_new_note(ActionEvent event) {

    }
    @FXML
    private Text note_body;

    @FXML
    private Text note_date;

}
