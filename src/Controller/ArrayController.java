/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.OS;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Anderson
 */
public class ArrayController implements Initializable {

    @FXML
    private Pane paneArray;
    @FXML
    private JFXTextField tfTamanhoArray;
    @FXML
    private JFXButton buttonCriarArray;
    @FXML
    private Pane paneOS;
    @FXML
    private JFXTextField tfCidadeDestino;
    @FXML
    private JFXTextField tfNomeEmissor;
    @FXML
    private JFXTextField tfDescricaoServico;
    @FXML
    private JFXTextField tfValor;
    @FXML
    private JFXTextField tfProduto;
    @FXML
    private JFXButton buttonAdicionarOS;
    @FXML
    private JFXButton array0;
    @FXML
    private JFXButton array1;
    @FXML
    private JFXButton array2;
    @FXML
    private JFXButton array3;
    @FXML
    private JFXButton array4;
    @FXML
    private JFXButton array5;
    @FXML
    private JFXButton array6;
    @FXML
    private JFXButton array7;
    @FXML
    private JFXButton array8;
    @FXML
    private JFXButton array9;
    @FXML
    private Label a0;
    @FXML
    private Label a1;
    @FXML
    private Label a2;
    @FXML
    private Label a3;
    @FXML
    private Label a4;
    @FXML
    private Label a5;
    @FXML
    private Label a6;
    @FXML
    private Label a7;
    @FXML
    private Label a8;
    @FXML
    private Label a9;
    @FXML
    private Label lbNumeroOS;
    @FXML
    private Label lbCidadeDestino;
    @FXML
    private Label lbNomeEmissor;
    @FXML
    private Label lbDescricao;
    @FXML
    private Label lbValor;
    @FXML
    private Label lbProduto;
    @FXML
    private JFXButton buttonNovoArray;
    @FXML
    private JFXTextField tfBuscar;
    @FXML
    private JFXButton btBuscar;
    @FXML
    private Label lbFormaPagamento;
    @FXML
    private JFXComboBox<?> cbFormaPagamento;
    @FXML
    private Label lbArrayLenght;
    @FXML
    private Label lbLastIndex;
    @FXML
    private Pane paneInfoArray;
    @FXML
    private TableView<OS> tableArray;
    @FXML
    private TableColumn<OS, Integer> clmNumeroOS;
    @FXML
    private TableColumn<OS, String> clmCidadeDestino;
    @FXML
    private TableColumn<OS, String> clmNomeEmissor;
    @FXML
    private TableColumn<OS, String> clmProduto;
    @FXML
    private TableColumn<OS, String> clmDescricaoServico;
    @FXML
    private TableColumn<OS, Double> clmValor;
    @FXML
    private TableColumn<OS, String> clmFormaPagamento;
    @FXML
    private JFXButton buttonArrayOuTabela;
    @FXML
    private JFXButton buttonImprimir;
    @FXML
    private Text titulo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherCombobox();

        tableArray.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                osSelecionado = (OS) newValue;

                if (!osSelecionado.equals("")) {
                    detalhesOSSelecionado();
                }
            }
        });
    }

    private void detalhesOSSelecionado() {
        int i = tableArray.getSelectionModel().getSelectedIndex();
        
        lbNumeroOS.setText(os[i].getNumero() + "");
        lbCidadeDestino.setText(os[i].getCidadeDestino() + "");
        lbNomeEmissor.setText(os[i].getNomeEmissor() + "");
        lbDescricao.setText(os[i].getDescricaoServico() + "");
        lbValor.setText(os[i].getValor() + "");
        lbProduto.setText(os[i].getProduto() + "");
        lbFormaPagamento.setText(os[i].getFormaPagamento() + "");
    }

    OS osSelecionado; //Selecionar um índice da tabela
    int x = 0; //Variável que recebe o tamanho do array
    int y = 0; //Variável inicial de inserção no array
    int p = 0; //Variável que armazena o índice a ser pesquisado

    OS os[]; //Declarando o array

    /**
     * Método para criar o array
     *
     * @param event
     */
    @FXML
    private void criarArray(ActionEvent event) {
        if (tfTamanhoArray.getText().length() > 0) {
            x = Integer.parseInt(tfTamanhoArray.getText());
        }

        if (x > 0 && x <= 10) {
            os = new OS[x];
            lbArrayLenght.setText(os.length + "");
            lbLastIndex.setText(os.length - 1 + "");
            exibirArrayGrafico();
            paneOS.setVisible(true);
            paneArray.setVisible(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Número inválido.");
            alert.setContentText("Digite um número entre 1 e 10.");
            alert.show();
        }
        tfTamanhoArray.setText("");
    }

    /**
     * Método para adicionar um objeto no array
     *
     * @param event
     */
    @FXML
    private void adicionarOS(ActionEvent event) {
        int teste = 0;
        Random numOS = new Random();

        //Verifica se os campos estão vázios
        if (tfCidadeDestino.getText().equals("")
                || tfNomeEmissor.getText().equals("")
                || tfDescricaoServico.getText().equals("")
                || tfValor.getText().equals("")
                || tfProduto.getText().equals("")
                || cbFormaPagamento.getSelectionModel().isEmpty()) {
            teste++;
        }

        if (teste == 0) {
            if (y < os.length) {

                String cidadeD = tfCidadeDestino.getText();
                String nomeE = tfNomeEmissor.getText();
                String descricaoS = tfDescricaoServico.getText();
                double valor = Double.parseDouble(tfValor.getText());
                String formaP = cbFormaPagamento.getValue().toString();
                String produto = tfProduto.getText();

                os[y] = new OS(numOS.nextInt(999), cidadeD, nomeE, descricaoS, valor, formaP, produto);
                preencherArrayGrafico();
                limparTextFilds();
                y++;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ArrayOS");
                alert.setHeaderText("Array completo.");
                alert.setContentText("Não existe mais espaço no array.");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Formulário imcompleto.");
            alert.setContentText("Preencha todos os campos.");
            alert.show();
        }
    }

    /**
     * Método para criar um novo array
     *
     * @param event
     */
    @FXML
    private void novoArray(ActionEvent event) {
        y = 0;
        paneOS.setVisible(false);
        paneArray.setVisible(true);
        esconderArrayGrafico();
        limparArrayGrafico();
        limparTextFilds();
        tableArray.getItems().clear();
    }

    /**
     * Método para buscar e exibir um objeto pelo índice do array
     *
     * @param event
     */
    @FXML
    private void buscarArray(ActionEvent event) {
        int p = 0;

        //verifica se algum número foi digitado
        if (tfBuscar.getText().length() > 0) {
            p = Integer.parseInt(tfBuscar.getText());

            //Verifica se o número digitado é menor que o último índice do array
            if (p <= os.length - 1) {

                //Verifica se o índice do array é diferente de nulo
                if (!os[p].equals("")) {
                    lbNumeroOS.setText(os[p].getNumero() + "");
                    lbCidadeDestino.setText(os[p].getCidadeDestino() + "");
                    lbNomeEmissor.setText(os[p].getNomeEmissor() + "");
                    lbDescricao.setText(os[p].getDescricaoServico() + "");
                    lbValor.setText(os[p].getValor() + "");
                    lbProduto.setText(os[p].getProduto() + "");
                    lbFormaPagamento.setText(os[p].getFormaPagamento() + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ArrayOS");
                    alert.setHeaderText("Posição vazia.");
                    alert.setContentText("Não existe dados nesta posição do array.");
                    alert.show();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ArrayOS");
                alert.setHeaderText("Posição inválida.");
                alert.setContentText("Digite um índice entre 0 e " + (os.length - 1 + "."));
                alert.show();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Nenhum número informado.");
            alert.setContentText("Informe um número e tente novamente.");
            alert.show();
        }

        tfBuscar.setText("");
        tfBuscar.setPromptText("");
    }

    private void preencherCombobox() {
        List formaP = new ArrayList();
        formaP.add(0, "Cartão");
        formaP.add(1, "Depósito");
        formaP.add(2, "Dinheiro");
        formaP.add(3, "Transferência");
        cbFormaPagamento.setItems(FXCollections.observableArrayList(formaP));
    }

    //Preenche um dos arrays sempre que inserir um novo objeto
    private void preencherArrayGrafico() {
        switch (y) {
            case 0:
                array0.setText(os[y].getNumero() + "");
                break;
            case 1:
                array1.setText(os[y].getNumero() + "");
                break;
            case 2:
                array2.setText(os[y].getNumero() + "");
                break;
            case 3:
                array3.setText(os[y].getNumero() + "");
                break;
            case 4:
                array4.setText(os[y].getNumero() + "");
                break;
            case 5:
                array5.setText(os[y].getNumero() + "");
                break;
            case 6:
                array6.setText(os[y].getNumero() + "");
                break;
            case 7:
                array7.setText(os[y].getNumero() + "");
                break;
            case 8:
                array8.setText(os[y].getNumero() + "");
                break;
            case 9:
                array9.setText(os[y].getNumero() + "");
                break;
        }
    }

    private void limparArrayGrafico() {
        array0.setText("null");
        array1.setText("null");
        array2.setText("null");
        array3.setText("null");
        array4.setText("null");
        array5.setText("null");
        array6.setText("null");
        array7.setText("null");
        array8.setText("null");
        array9.setText("null");
    }

    private void limparTextFilds() {
        tfTamanhoArray.setText("");
        tfTamanhoArray.setPromptText("0");
        tfCidadeDestino.setText("");
        tfNomeEmissor.setText("");
        tfDescricaoServico.setText("");
        tfValor.setText("");
        tfProduto.setText("");
        cbFormaPagamento.getSelectionModel().clearSelection();
    }

    /**
     * Método para exibir o array gráfico ou a tabela
     *
     * @param event
     */
    @FXML
    private void arrayOuTabela(ActionEvent event) {
        if (buttonArrayOuTabela.getText().equals("Exibir tabela")) {
            tableArray.setVisible(true);
            buttonImprimir.setVisible(true);
            buttonArrayOuTabela.setText("Exibir array");
            titulo.setText("Tabela");
        } else {
            tableArray.setVisible(false);
            buttonImprimir.setVisible(false);
            buttonArrayOuTabela.setText("Exibir tabela");
            titulo.setText("Array");
        }
    }

    /**
     * Método para preencher a tabela com os dados do array
     *
     * @param event
     */
    @FXML
    private void imprimirArray(ActionEvent event) {
        //Informa caso a tabela esteja vazia
        if (os[0] != null) {
            clmNumeroOS.setCellValueFactory(new PropertyValueFactory<>("numero"));
            clmCidadeDestino.setCellValueFactory(new PropertyValueFactory<>("cidadeDestino"));
            clmNomeEmissor.setCellValueFactory(new PropertyValueFactory<>("nomeEmissor"));
            clmProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
            tableArray.setItems(listaOS());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Array vazio.");
            alert.setContentText("Não foi possível preencher a tabela.");
            alert.show();
        }
    }

    /**
     * Converte o array para ObservableList
     *
     * @return
     */
    private ObservableList<OS> listaOS() {
        return FXCollections.observableArrayList(os);
    }

    //Exibe o array gráfico de acordo com o seu tamanho
    private void exibirArrayGrafico() {
        switch (x) {
            case 1:
                esconderArrayGrafico();
                array0.setVisible(true);
                a0.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 2:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 3:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 4:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 5:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 6:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                array5.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                a5.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 7:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                array5.setVisible(true);
                array6.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                a5.setVisible(true);
                a6.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 8:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                array5.setVisible(true);
                array6.setVisible(true);
                array7.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                a5.setVisible(true);
                a6.setVisible(true);
                a7.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 9:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                array5.setVisible(true);
                array6.setVisible(true);
                array7.setVisible(true);
                array8.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                a5.setVisible(true);
                a6.setVisible(true);
                a7.setVisible(true);
                a8.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
            case 10:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                array2.setVisible(true);
                array3.setVisible(true);
                array4.setVisible(true);
                array5.setVisible(true);
                array6.setVisible(true);
                array7.setVisible(true);
                array8.setVisible(true);
                array9.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                a2.setVisible(true);
                a3.setVisible(true);
                a4.setVisible(true);
                a5.setVisible(true);
                a6.setVisible(true);
                a7.setVisible(true);
                a8.setVisible(true);
                a9.setVisible(true);
                buttonNovoArray.setVisible(true);
                titulo.setVisible(true);
                paneInfoArray.setVisible(true);
                break;
        }
    }

    //Esconde o arrray gráfico ao clicar em novo array
    private void esconderArrayGrafico() {
        array0.setVisible(false);
        array1.setVisible(false);
        array2.setVisible(false);
        array3.setVisible(false);
        array4.setVisible(false);
        array5.setVisible(false);
        array6.setVisible(false);
        array7.setVisible(false);
        array8.setVisible(false);
        array9.setVisible(false);
        a0.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        a5.setVisible(false);
        a6.setVisible(false);
        a7.setVisible(false);
        a8.setVisible(false);
        a9.setVisible(false);
        buttonNovoArray.setVisible(false);
        titulo.setVisible(false);
        paneInfoArray.setVisible(false);
    }

    //Detalhar um objeto do array pelo seu índice
    private void detalharIndiceArray() {
        if (os[p] != null) {
            lbNumeroOS.setText(os[p].getNumero() + "");
            lbCidadeDestino.setText(os[p].getCidadeDestino() + "");
            lbNomeEmissor.setText(os[p].getNomeEmissor() + "");
            lbDescricao.setText(os[p].getDescricaoServico() + "");
            lbValor.setText(os[p].getValor() + "");
            lbProduto.setText(os[p].getProduto() + "");
            lbFormaPagamento.setText(os[p].getFormaPagamento() + "");
        } else {
            lbNumeroOS.setText("null");
            lbCidadeDestino.setText("null");
            lbNomeEmissor.setText("null");
            lbDescricao.setText("null");
            lbValor.setText("null");
            lbProduto.setText("null");
            lbFormaPagamento.setText("null");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Posição vazia.");
            alert.setContentText("Não existe dados nesta posição do array.");
            alert.show();
        }
    }

    //Métodos abaixo salva o índice digitado e detalha o objeto
    @FXML
    private void indice0(ActionEvent event) {
        p = 0;
        detalharIndiceArray();
    }

    @FXML
    private void indice1(ActionEvent event) {
        p = 1;
        detalharIndiceArray();
    }

    @FXML
    private void indice2(ActionEvent event) {
        p = 2;
        detalharIndiceArray();
    }

    @FXML
    private void indice3(ActionEvent event) {
        p = 3;
        detalharIndiceArray();
    }

    @FXML
    private void indice4(ActionEvent event) {
        p = 4;
        detalharIndiceArray();
    }

    @FXML
    private void indice5(ActionEvent event) {
        p = 5;
        detalharIndiceArray();
    }

    @FXML
    private void indice6(ActionEvent event) {
        p = 6;
        detalharIndiceArray();
    }

    @FXML
    private void indice7(ActionEvent event) {
        p = 7;
        detalharIndiceArray();
    }

    @FXML
    private void indice8(ActionEvent event) {
        p = 8;
        detalharIndiceArray();
    }

    @FXML
    private void indice9(ActionEvent event) {
        p = 9;
        detalharIndiceArray();
    }

}
