/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anderson
 */
public class OS {

    private int numero;
    private String cidadeDestino;
    private String nomeEmissor;
    private String descricaoServico;
    private double valor;
    private String formaPagamento;
    private String produto;

    public OS() {
    }

    public OS(int numero, String cidadeDestino, String nomeEmissor, String descricaoServico, double valor, String formaPagamento, String produto) {
        this.numero = numero;
        this.cidadeDestino = cidadeDestino;
        this.nomeEmissor = nomeEmissor;
        this.descricaoServico = descricaoServico;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.produto = produto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public String getNomeEmissor() {
        return nomeEmissor;
    }

    public void setNomeEmissor(String nomeEmissor) {
        this.nomeEmissor = nomeEmissor;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
}
