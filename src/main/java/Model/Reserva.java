/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity /* marca uma classe como uma entidade persistente, mapeando-a automaticamente para uma tabela em um banco de dados relacional*/
@Table (name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_Reserva") // chave primaria da tabela reserva 
     private int idReserva;
    
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public QuartoModel getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoModel quarto) {
        this.quarto = quarto;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    
    @ManyToOne
@JoinColumn(name="FK_quarto") // chave estrangeira da tabela quarto, a reserva pertece a um quarto.
private QuartoModel quarto;
    
    @ManyToOne// ANOTAÇAO PARA FAZER A RELAÇOA DE UMA TABELA PARA OUTRA NO BANCO
@JoinColumn(name="FK_cliente") // chave estrangeira da tabela cliente, a reservar pertence a um cliente.
private ClienteModel cliente;
    
@Column(name = "data_entrada")
    private Date dataentrada;
    
@Column(name = "data_saida")
    private Date datasaida;
    
}
