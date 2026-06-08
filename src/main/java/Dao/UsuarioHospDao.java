package Dao;

import Model.UsuarioHospedagem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UsuarioHospDao {

    // Fabrica de conexão, CRIA CONECXAO COM O BANCO DE DADOS (HIBERNATE)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PusadaSerenidade");

    // EntityManager RESPONSAVEL POR INSERT,SELECT,UPDATE,DELETE
  private EntityManager em = emf.createEntityManager();
   
   //CRIANDO O  METODO PARA AUTENTICAR USUARIO,UsuarioHospedagem É O TIPO DO METODO 
     public  UsuarioHospedagem autenticar (String login, String senha){
         
     //TRY RESPONSAVEL PELA APLICAÇAO CASO DE ERRO NAO QUEBRE O PROGRAMA    
    try{
            //RESPOSAVEL PARA CRIAR CONSULTA NO HIBERNATE
            List< UsuarioHospedagem> lista  = em.createQuery(
                    
                    //AQUI O IDEAL E COLOCAR O NOME DA CLASSE
                    "SELECT u FROM UsuarioHospedagem u WHERE u.login = :login AND u.senha = :senha",UsuarioHospedagem.class)
                     
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getResultList();//RETORNA UMA LISTA COM 0 OU VARIOS RESULTADOS
                    
                    if(lista.isEmpty()) { //VERIFICAÇAO
                         return null;
                     }
                     return
                           lista.get(0);// PEGA O PRIMEIRO USUARIO ENCONTRADO
                     
                    }
        
                   finally{ 
                           em.close(); //EXECULTA MESMO SE DER ERRO
                   }
        }

    // Método salvar
    public boolean salvar(UsuarioHospedagem c) {

        try {

            em.getTransaction().begin();

            if (c.getId() == 0) {

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
    }

    // Método excluir
    public void excluir(int id) {

        try {

            em.getTransaction().begin();

            UsuarioHospedagem c = em.find(UsuarioHospedagem.class, id);

            if (c != null) {

                em.remove(c);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();

            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}
      
    

       
