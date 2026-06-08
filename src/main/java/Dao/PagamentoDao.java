/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ClienteModel;
import Model.PagamentoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author maury
 */
public class PagamentoDao {
     
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PusadaSerenidade");

     // EntityManager RESPONSAVEL POR INSERT,SELECT,UPDATE,DELETE
  private EntityManager em = emf.createEntityManager();
     
  //inicio do metodo salvar no banco de dados 
     public boolean salvar(PagamentoModel c) {

        try {

            em.getTransaction().begin();

            if (c.getIdPagamento() == 0) { //get id da tabela

                em.persist(c);

            } else {

                em.merge(c);
            }

            em.getTransaction().commit();
            System.out.println("DADOS SALVO COM SUCESSO!");
             return true;

        } catch (Exception e) {

            em.getTransaction().rollback();

            System.out.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    } //fim do metodo salvar
    
}
