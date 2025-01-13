package com.example.campaignmanager;
import dbc.DBConnection;
import dbc.Data_base_function;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        try {
            String noteContent = note_text.getText();
            String noteColor = color_note.getValue().toString();

            if (noteContent.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champ vide");
                alert.setHeaderText("Aucune note saisie");
                alert.setContentText("Veuillez saisir une note avant de continuer.");
                alert.showAndWait();
                return;
            }

            Connection connection = DBConnection.getConnection();

            if (connection != null) {
                String query = "INSERT INTO notes (content, color) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, noteContent);
                statement.setString(2, noteColor);

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Note ajoutée");
                    successAlert.setHeaderText("Succès");
                    successAlert.setContentText("Votre note a été ajoutée avec succès !");
                    successAlert.showAndWait();
                }

                statement.close();
                connection.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Connexion échouée");
                alert.setContentText("Impossible de se connecter à la base de données.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erreur");
            errorAlert.setHeaderText("Une erreur est survenue");
            errorAlert.setContentText("Impossible d'ajouter la note. Veuillez réessayer.");
            errorAlert.showAndWait();
        }


    }


    ObservableList<dbc.Classes.Note> list_note = FXCollections.observableArrayList(Data_base_function.fetch_notes(2));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
        for(dbc.Classes.Note n : list_note) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("note-m.fxml"));
            NoteModel nm = fxmlLoader.getController();
            nm.setNote_data(n);
            VBox note_Box = fxmlLoader.load();
            note_container.getChildren().add(note_Box);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
