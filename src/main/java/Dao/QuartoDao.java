
package Dao;
//CRIANDO A CLASE RESPENSAVEL PARA ACESSAR OD DADOS DA TABELA QURATO

import Model.CategoriaQuartoModel;
import Model.ClienteModel;
import Model.QuartoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;


// METODO PARA SALCAR QUARTOS NO BANCO DE DADOS
public class QuartoDao  {
 // Fabrica de conexão, CRIA CONECXAO COM O BANCO DE DADOS (HIBERNATE)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PusadaSerenidade");
    
      // EntityManager RESPONSAVEL POR INSERT,SELECT,UPDATE,DELETE
  private EntityManager em = emf.createEntityManager();

  
  //inicio do metodo salvar no banco de dados 
     public boolean salvar(QuartoModel q) {

        try {

            em.getTransaction().begin();

            if (q.getIdQuarto() == 0) { //get id da tabela

                em.persist(q);

            } else {

                em.merge(q);
            }

            em.getTransaction().commit();
            System.out.println("QUARTO SALVO COM SUCESSO!");
             return true;

        } catch (Exception e) {

            em.getTransaction().rollback();

            System.out.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    } 
     
      public List<QuartoModel> listar() {
         EntityManager em = emf.createEntityManager();
         List<QuartoModel> cliente = null;
         try{
             cliente = em.createQuery("FROM QuartoModel", QuartoModel.class).getResultList();
             
         } finally{
         em.close();
         }
        return cliente;
    }
      
          // Método excluir
    // Mudamos de 'void' para 'boolean' para que o método avise se deu certo ou errado
public boolean Excluir(int idCategoria) {
    try {
        em.getTransaction().begin(); // Inicia uma transação com o banco de dados

        // Busca a categoria no banco pelo ID informado
        CategoriaQuartoModel c = em.find(CategoriaQuartoModel.class, idCategoria); 

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
    
    
