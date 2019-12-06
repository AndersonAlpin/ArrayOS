/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.OS;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
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
    private JFXTextField tfNumeroOS;
    @FXML
    private JFXTextField tfCidadeDestino;
    @FXML
    private JFXTextField tfNomeEmissor;
    @FXML
    private JFXTextField tfDescricaoServico;
    @FXML
    private JFXTextField tfValor;
    @FXML
    private JFXTextField tfFormaPagamento;
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
    private Button a0;
    @FXML
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;
    @FXML
    private Button a5;
    @FXML
    private Button a6;
    @FXML
    private Button a7;
    @FXML
    private Button a8;
    @FXML
    private Button a9;
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
    private Text tituloArray;
    @FXML
    private Label lbFormaPagamento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    int x = 0;
    int y = 0;
    int p = 0;

    OS os[];

    @FXML
    private void criarArray(ActionEvent event) {       
        if (tfTamanhoArray.getText().length() > 0) {
            x = Integer.parseInt(tfTamanhoArray.getText());
        }

        if (x > 0 && x <= 10) {
            os = new OS[x];
            exibirArrayGrafico();
            paneOS.setVisible(true);
            paneArray.setVisible(false);
        } else {
            esconderArrayGrafico();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Número inválido");
            alert.setContentText("Digite um número entre 1 e 10.");
            alert.show();
        }
    }

    @FXML
    private void adicionarOS(ActionEvent event) {
        if (y < os.length) {
            int numOS = Integer.parseInt(tfNumeroOS.getText());
            String cidadeD = tfCidadeDestino.getText();
            String nomeE = tfNomeEmissor.getText();
            String descricaoS = tfDescricaoServico.getText();
            double valor = Double.parseDouble(tfValor.getText());
            String formaP = tfFormaPagamento.getText();
            String produto = tfProduto.getText();

            os[y] = new OS(numOS, cidadeD, nomeE, descricaoS, valor, formaP, produto);
            preencherArrayGrafico();
            limparTextFilds();
            y++;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Array completo");
            alert.setContentText("Não existe mais espaço no array.");
            alert.show();
        }
    }

    @FXML
    private void novoArray(ActionEvent event) {
        y = 0;
        paneOS.setVisible(false);
        paneArray.setVisible(true);
        esconderArrayGrafico();
        limparArrayGrafico();
        limparTextFilds();
    }

    @FXML
    private void buscarArray(ActionEvent event) {
        int p = 0;
        if (tfBuscar.getText().length() > 0) {
            p = Integer.parseInt(tfBuscar.getText());
        }

        if (os[p] != null) {
            lbNumeroOS.setText(os[p].getNumero() + "");
            lbCidadeDestino.setText(os[p].getCidadeDestino() + "");
            lbNomeEmissor.setText(os[p].getNomeEmissor() + "");
            lbDescricao.setText(os[p].getDescricaoServico() + "");
            lbValor.setText(os[p].getValor() + "");
            lbProduto.setText(os[p].getProduto() + "");
            lbFormaPagamento.setText(os[p].getFormaPagamento() + "");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Posição vazia!");
            alert.setContentText("Não existe dados nesta posição do array.");
            alert.show();
        }
        tfBuscar.setText("");
        tfBuscar.setPromptText("");
    }

    private void exibirArrayGrafico() {
        switch (x) {
            case 1:
                esconderArrayGrafico();
                array0.setVisible(true);
                a0.setVisible(true);
                buttonNovoArray.setVisible(true);
                tituloArray.setVisible(true);
                break;
            case 2:
                esconderArrayGrafico();
                array0.setVisible(true);
                array1.setVisible(true);
                a0.setVisible(true);
                a1.setVisible(true);
                buttonNovoArray.setVisible(true);
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
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
                tituloArray.setVisible(true);
                break;
        }
    }

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
        tituloArray.setVisible(false);
    }

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
        tfNumeroOS.setText("");
        tfCidadeDestino.setText("");
        tfNomeEmissor.setText("");
        tfDescricaoServico.setText("");
        tfValor.setText("");
        tfFormaPagamento.setText("");
        tfProduto.setText("");
    }
    
    private void exibirPosicaoArray() {
        if (os[p] != null) {
            lbNumeroOS.setText(os[p].getNumero() + "");
            lbCidadeDestino.setText(os[p].getCidadeDestino() + "");
            lbNomeEmissor.setText(os[p].getNomeEmissor() + "");
            lbDescricao.setText(os[p].getDescricaoServico() + "");
            lbValor.setText(os[p].getValor() + "");
            lbProduto.setText(os[p].getProduto() + "");
            lbFormaPagamento.setText(os[p].getFormaPagamento() + "");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ArrayOS");
            alert.setHeaderText("Posição vazia!");
            alert.setContentText("Não existe dados nesta posição do array.");
            alert.show();
        }
    }

    @FXML
    private void posicao0(ActionEvent event) {
        p = 0;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao1(ActionEvent event) {
        p = 1;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao2(ActionEvent event) {
        p = 2;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao3(ActionEvent event) {
        p = 3;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao4(ActionEvent event) {
        p = 4;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao5(ActionEvent event) {
        p = 5;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao6(ActionEvent event) {
        p = 6;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao7(ActionEvent event) {
        p = 7;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao8(ActionEvent event) {
        p = 8;
        exibirPosicaoArray();
    }

    @FXML
    private void posicao9(ActionEvent event) {
        p = 9;
        exibirPosicaoArray();
    }

}
