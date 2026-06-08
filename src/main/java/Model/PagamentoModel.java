package Model;

import jakarta.persistence.*;


@Entity
@Table(name = "pagamento")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private int idPagamento;

    @Column(name = "valor_pago")
    private double valorPago;

    @Column(name = "metodo")
    private String metodo;

    // Relacionamento com a tabela Cliente (Chave Estrangeira FK_cliente)
    @ManyToOne
    @JoinColumn(name = "FK_cliente")
    private ClienteModel cliente;

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }


    // GETTERS E SETTERS
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

   

   
}
