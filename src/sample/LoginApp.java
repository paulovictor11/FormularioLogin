package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(400, 300);

        TextField txtLogin = new TextField();
        txtLogin.setPromptText("Digite aqui seu login");

        PasswordField txtSenha = new PasswordField();
        txtSenha.setPromptText("Digite aqui sua senha");

        Button btnEntrar = new Button("Entrar");
        Button btnSair = new Button("Sair");

        pane.getChildren().addAll(txtLogin, txtSenha, btnEntrar, btnSair);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%)");

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Formulário Login");
        primaryStage.setScene(scene);
        primaryStage.show();

        txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
        txtLogin.setLayoutY(50);

        txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
        txtSenha.setLayoutY(100);

        btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
        btnEntrar.setLayoutY(150);

        btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth()) / 2);
        btnSair.setLayoutY(200);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
