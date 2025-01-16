package com.example.campaignmanager;

import dbc.Classes.ToDoList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TaskModel{

    @FXML
    private Rectangle task_color;

    @FXML
    private Button complete;

    @FXML
    private Button delete;

    @FXML
    private Text task_content;

    @FXML
    private ImageView done;

    @FXML
    private ImageView hand;

    @FXML
    private Button list;

    @FXML
    void complete_task(ActionEvent event) {

    }

    @FXML
    void remove_task(ActionEvent event) {

    }


    public void setTask_Data(ToDoList task) {
        task_content.setText(task.getContent());
        task_color.setFill(Color.valueOf(task.getColor()));
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/campaignmanager/Models/Icons/to-do-list.png")));
        ImageView imv = new ImageView(img);
        imv.setFitHeight(30);
        imv.setFitWidth(30);
        list.setGraphic(imv);

    }

}





