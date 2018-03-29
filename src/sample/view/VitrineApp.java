package sample.view;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controller.Carrinho;
import sample.controller.Produto;
import sample.controller.Vitrine;

public class VitrineApp extends Application {

    private AnchorPane pane;
    private TextField txtPesquisa;
    private TableView<ItensProperty> tblVitrine;
    private TableColumn<ItensProperty, String> clmProduto;
    private TableColumn<ItensProperty, Double> clmPreco;
    private static ObservableList<ItensProperty> listItems = FXCollections.observableArrayList();
    private static Carrinho carrinho;

    @Override
    public void start(Stage stage) throws Exception {

        initComponents();
        initListeners();
        initItems();
        tblVitrine.setItems(listItems);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);  //Remove a opção de maximizar a tela
        stage.setTitle("Vitrine - GolFX");    //Dá um título para a tela
        stage.show();

        initLayout();
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%)");

        txtPesquisa = new TextField();
        txtPesquisa.setPromptText("Pesquisar item");

        tblVitrine = new TableView<ItensProperty>();
        tblVitrine.setPrefSize(780, 550);


        clmProduto = new TableColumn<ItensProperty, String>();
        clmProduto.setText("Produto");
        clmProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));

        clmPreco = new TableColumn<ItensProperty, Double>();
        clmPreco.setText("Preço");
        clmPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));

        tblVitrine.getColumns().addAll(clmProduto, clmPreco);

        pane.getChildren().addAll(txtPesquisa, tblVitrine);

        carrinho = new Carrinho();

    }

    private void initLayout(){
        txtPesquisa.setLayoutX(645);
        txtPesquisa.setLayoutY(10);

        tblVitrine.setLayoutX(15);
        tblVitrine.setLayoutY(40);
    }


    private void initListeners(){
        txtPesquisa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txtPesquisa.getText().equals("")){
                    tblVitrine.setItems(findItems());
                } else {
                    tblVitrine.setItems(findItems());
                }
            }
        });
    }

    private void initItems(){
        Vitrine vitrine = new Vitrine();
        vitrine.addProdutos(new Produto("Bola Topper", 15.00), new Produto("Luvas Umbro", 9.00), new Produto("Chuteira Nike Mercurial", 199.00), new Produto("Caneleira Topper", 10.00));

        for (Produto p : vitrine.getProdutos()) {
            listItems.add(new ItensProperty(p.getProduto(), p.getPreco()));
        }
    }

    private ObservableList<ItensProperty> findItems(){
        ObservableList<ItensProperty> itemsEncontrados = FXCollections.observableArrayList();

        for (ItensProperty itens : listItems) {
            if (itens.getProduto().contains(txtPesquisa.getText())){
                itemsEncontrados.add(itens);
            }
        }

        return itemsEncontrados;
    }

    public class ItensProperty {
        private SimpleStringProperty produto;
        private SimpleDoubleProperty preco;

        public ItensProperty(String produto, double preco) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
        }

        public String getProduto() {
            return produto.get();
        }

        public SimpleStringProperty produtoProperty() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto.set(produto);
        }

        public double getPreco() {
            return preco.get();
        }

        public SimpleDoubleProperty precoProperty() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco.set(preco);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
