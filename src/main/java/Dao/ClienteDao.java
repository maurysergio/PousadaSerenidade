/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Model.ClienteModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


public class ClienteDao {
    // Fabrica de conexão, CRIA CONECXAO COM O BANCO DE DADOS (HIBERNATE)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PusadaSerenidade");
    
      // EntityManager RESPONSAVEL POR INSERT,SELECT,UPDATE,DELETE
  private EntityManager em = emf.createEntityManager();

  
  //inicio do metodo salvar no banco de dados 
     public boolean salvar(ClienteModel c) {

        try {

            em.getTransaction().begin();

            if (c.getIDCliente() == 0) { //get id da tabela

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
     
     //METODO LISTAR: RETORNA TODOS OS ITEMS
     
     public List<ClienteModel> listar() {
         EntityManager em = emf.createEntityManager();
         List<ClienteModel> cliente = null;
         try{
             cliente = em.createQuery("FROM ClienteModel", ClienteModel.class).getResultList();
             
         } finally{
         em.close();
         }
        return cliente;
    }
     
     public boolean Excluir(int IDCliente) {
    try {
        em.getTransaction().begin(); // Inicia uma transação com o banco de dados

        // Busca a categoria no banco pelo ID informado
        ClienteModel c = em.find(ClienteModel.class, IDCliente); 

        if (c != null) { // Verifica se a categoria realmente existe no banco
            em.remove(c); // Prepara a remoção do objeto
            em.getTransaction().commit(); // Salva as alterações definitivamente no banco
            return true; // Retorna VERDADEIRO indicando sucesso
        } else {
            em.getTransaction().rollback(); // Cancela se não encontrar o registro
            return false; // Retorna FALSO pois o registro não existia
        }

    } catch (Exception e) {
        // Se houver qualquer erro (como restrição de chave estrangeira), desfaz as alterações
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback(); 
        }
        System.out.println("Erro ao excluir: " + e.getMessage());
        return false; // Retorna FALSO indicando que houve um erro e não excluiu
    }
}
    
        }
    
    
    