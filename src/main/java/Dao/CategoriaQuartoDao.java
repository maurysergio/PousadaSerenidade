
package Dao;

import Model.CategoriaQuartoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author maury
 */
public class CategoriaQuartoDao {
    public static final EntityManagerFactory emf = // fabrica de conexao com o banco
            Persistence.createEntityManagerFactory("PusadaSerenidade");
    
    private EntityManager em = emf.createEntityManager(); //resposavel por manipular dados
    
     //inicio do metodo salvar no banco de dados 
     public boolean salvar(CategoriaQuartoModel c) {

        try {

            em.getTransaction().begin();

            if (c.getIdCategoria() == 0) { //get id da tabela

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

    
    public List<CategoriaQuartoModel> listar() {
         EntityManager em = emf.createEntityManager();
         List<CategoriaQuartoModel> lista= null;
         try{
             lista = em.createQuery("FROM CategoriaQuartoModel", CategoriaQuartoModel.class).getResultList();
             
         } finally{
         em.close();
         }
        return lista;
    }

   
    
}
