package com.example.campaignmanager;

import dbc.Classes.Note;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Date;

public class NoteModel {

    @FXML
    private Text note_body;

    @FXML
    private Text note_date;

    @FXML
    private VBox note_container;

    public void setNote_data(Note note){
        note_body.setText(note.getDescription());
        Date date = note.getDate();
        note_date.setText(date.toString());
        note_container.setStyle("-fx-background-color : "+ note.getColor());
    }

}