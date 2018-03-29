package sample.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class LoginApp extends Application {

    private AnchorPane pane;
    private TextField txtLogin;
    private PasswordField txtSenha;
    private Button btnEntrar, btnSair;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{

        initComponents();
        initListeners();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);  //Remove a opção de maximizar a tela
        stage.setTitle("Login - GolFX");    //Dá um título para a tela
        stage.show();

        initLayout();

        LoginApp.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    private void initComponents (){
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%)");

        txtLogin = new TextField();
        txtLogin.setPromptText("Digite aqui seu login");

        txtSenha = new PasswordField();
        txtSenha.setPromptText("Digite aqui sua senha");

        btnEntrar = new Button("Entrar");
        btnSair = new Button("Sair");

        pane.getChildren().addAll(txtLogin, txtSenha, btnEntrar, btnSair);

    }

    private void initLayout(){
        txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
        txtLogin.setLayoutY(50);

        txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
        txtSenha.setLayoutY(100);

        btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
        btnEntrar.setLayoutY(150);

        btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth()) / 2);
        btnSair.setLayoutY(200);
    }

    private void initListeners(){
        btnSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fecharAplicacao();
            }
        });

        btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logar();
            }
        });
    }

    private void logar() {
        if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("12345")){
            try {
                new VitrineApp().start(new Stage());
                LoginApp.getStage().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou Senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fecharAplicacao() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
