/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ClienteModel;
import Model.ContatoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author maury
 */
public class ContatoDao {
    // Fabrica de conexão, CRIA CONECXAO COM O BANCO DE DADOS (HIBERNATE)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PusadaSerenidade");
    
      // EntityManager RESPONSAVEL POR INSERT,SELECT,UPDATE,DELETE
  private EntityManager em = emf.createEntityManager();
    //inicio do metodo salvar no banco de dados 
   

    public boolean salvar(ContatoModel contato){

        try{

            em.getTransaction().begin();

            if(contato.getIdContato() == 0){
                em.persist(contato);
            }else{
                em.merge(contato);
            }

            em.getTransaction().commit();

            return true;

        }catch(Exception e){

            em.getTransaction().rollback();

            System.out.println(e.getMessage());

            return false;
        }
    }
} //fim do metodo salvar
    


