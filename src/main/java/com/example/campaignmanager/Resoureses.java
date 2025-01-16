package com.example.campaignmanager;

import dbc.Classes.Ressourses;
import dbc.Data_base_function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Resoureses implements Initializable {

    @FXML
    private TextField budget;

    @FXML
    private TableColumn<Ressourses, Void> actions;

    @FXML
    private Text need_budget;

    @FXML
    private TableColumn<Ressourses, Integer> need_number;

    @FXML
    private Spinner<Integer> number_r;

    @FXML
    private TableColumn<Ressourses,String> resource;

    @FXML
    private TableColumn<Ressourses, Float> resource_budget;

    @FXML
    private TextField resource_t;

    @FXML
    private TableView<Ressourses> table_r;

    @FXML
    private Text total_resources;

    @FXML
    void add_new_reource(ActionEvent event) {

    }

    private void handleDelete(Ressourses resource) {

    }

    private void handleUpdate(Ressourses resource) {

    }

    ObservableList list_resous = FXCollections.observableArrayList(Data_base_function.fetch_ressourses(1,2));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resource_t.getStyleClass().add("table-view");
        number_r.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
        total_resources.setText(Data_base_function.total_resourses(1,2)+"");
        resource.setCellValueFactory(new PropertyValueFactory<>("name"));
        resource_budget.setCellValueFactory(new PropertyValueFactory<>("price"));
        need_number.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        addButtonToTable();
        table_r.setItems(list_resous);
    }

    private void addButtonToTable() {
        actions.setCellFactory(param -> new TableCell<Ressourses, Void>() {
            private final Button updateButton = new Button();
            private final Button deleteButton = new Button();
            private final HBox hBox = new HBox(updateButton, deleteButton);

            {
                hBox.setSpacing(10);

                ImageView updateIcon = new ImageView(new Image("file:src/main/resources/com/example/campaignmanager/Images/Icon/update.png"));
                updateIcon.setFitWidth(20);
                updateIcon.setFitHeight(20);
                updateButton.setGraphic(updateIcon);
                updateButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

                ImageView deleteIcon = new ImageView(new Image("file:src/main/resources/com/example/campaignmanager/Images/Icon/delete.png"));
                deleteIcon.setFitWidth(20);
                deleteIcon.setFitHeight(20);
                deleteButton.setGraphic(deleteIcon);
                deleteButton.setStyle("-fx-background-color: transparent; -fx-cursor: hand");

                updateButton.setOnAction(event -> {
                    Ressourses resource = getTableRow().getItem();
                    if (resource != null) {
                        handleUpdate(resource);
                    }
                });

                deleteButton.setOnAction(event -> {
                    Ressourses resource = getTableRow().getItem();
                    if (resource != null) {
                        handleDelete(resource);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(hBox);
                }
            }
        });

    }




}