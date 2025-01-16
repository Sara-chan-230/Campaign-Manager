package com.example.campaignmanager;

import dbc.Data_base_function;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SignIn {

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;

    @FXML
    void signin(MouseEvent event) throws Exception {
        String email = name.getText();
        String pass = password.getText();

        if (email.isEmpty() || pass.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champs manquants");
            alert.setHeaderText("Veuillez remplir tous les champs");
            alert.setContentText("L'email et le mot de passe sont requis.");
            alert.showAndWait();
            return;
        }

        // Vérifier les informations de connexion
        boolean isAuthenticated = Data_base_function.signIn(email,pass);

        // Si la connexion est réussie
        if (isAuthenticated) {
            // Charger la page principale (MainProgramme)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/campaignmanager/MainProgramme.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) submit.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            // Afficher une alerte d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connexion échouée");
            alert.setHeaderText("Email ou mot de passe incorrect");
            alert.setContentText("Veuillez vérifier vos informations.");
            alert.showAndWait();
 }
}
}

