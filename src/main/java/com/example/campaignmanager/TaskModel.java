package com.example.campaignmanager;

import dbc.Classes.ToDoList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TaskModel {

    @FXML
    private Button task_title;

    @FXML
    void complete_task(ActionEvent event) {

    }

    @FXML
    void remove_task(ActionEvent event) {

    }

    public void setTask_Data(ToDoList task){
        task_title.setText(task.getContent());
        task_title.setStyle("-fx-background-color: "+task.getColor());
    }

}
