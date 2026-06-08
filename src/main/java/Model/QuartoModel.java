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

@Entity /* marca uma classe como uma entidade persistente, mapeando-a automaticamente para uma tabela em um banco de dados relacional*/
@Table (name="Quarto")
public class QuartoModel {
    
    @Override
public String toString() {
    return "Quarto " + numero;
}
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "id_Quarto")
    private int idQuarto;
    private int numero;
    // chave estrangeira para fazer o relacionamento entre as tabelas de acordo do banco 
  @ManyToOne
@JoinColumn(name="FK_categoria")
private CategoriaQuartoModel categoria;
 


    public CategoriaQuartoModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaQuartoModel categoria) {
        this.categoria = categoria;
    }
    
    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
   
    
}
