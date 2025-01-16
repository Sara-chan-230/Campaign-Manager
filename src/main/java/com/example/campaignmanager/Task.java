package com.example.campaignmanager;

import dbc.Classes.ToDoList;
import dbc.Data_base_function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Task implements Initializable {

    @FXML
    private ColorPicker task_color;

    @FXML
    private VBox completed_tasks;

    @FXML
    private VBox inProgress_task;

    @FXML
    private TextField task_text;

    @FXML
    private Button task_title;


    @FXML
    void add_new_task(ActionEvent event) {

    }

    ObservableList<ToDoList> task_list = FXCollections.observableArrayList(Data_base_function.fetch_In_prgress_task(1,2));
    ObservableList<ToDoList> c_task_list = FXCollections.observableArrayList(Data_base_function.fetch_campleted_task(1,2));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for (ToDoList task : task_list) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Models\\task-m.fxml"));
                if (fxmlLoader.getLocation() == null) {
                    System.err.println("FXML file not found: Campaign.fxml");
                    return;
                }
                AnchorPane task_box = fxmlLoader.load();
                TaskModel tm = fxmlLoader.getController();
                tm.setTask_Data(task);
                inProgress_task.getChildren().add(task_box);
                inProgress_task.requestLayout();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            for (ToDoList task : c_task_list) {
                System.out.println(c_task_list);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Models\\task-mc.fxml"));
                AnchorPane task_box = fxmlLoader.load();
                TaskModel tm = fxmlLoader.getController();
                tm.setTask_Data(task);

                completed_tasks.getChildren().add(task_box);
                completed_tasks.requestLayout();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
