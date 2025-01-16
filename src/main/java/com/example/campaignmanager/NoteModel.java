package com.example.campaignmanager;

import dbc.Classes.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Date;
import java.util.Objects;

public class NoteModel {

    @FXML
    private Text note_body;

    @FXML
    private Text note_date;

    @FXML
    private AnchorPane note_container;

    @FXML
    private Rectangle color_change;

    @FXML
    private Button imag;


    public void setNote_data(Note note) {
        note_body.setText(note.getDescription());
        Date date = note.getDate();
        note_date.setText(date.toString());
        color_change.setFill(Color.valueOf(note.getColor()));
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/campaignmanager/Models/Icons/notes.png")));
        ImageView imv = new ImageView(img);
        imv.setFitHeight(45);
        imv.setFitWidth(45);
        imag.setGraphic(imv);

    }

}