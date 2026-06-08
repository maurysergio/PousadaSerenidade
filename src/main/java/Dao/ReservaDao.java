
package Dao;

import Model.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class ReservaDao {
    
    // Fábrica de conexão com o banco de dados (Unidade de Persistência)
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PusadaSerenidade");

    /**
     * CORREÇÃO: Removido o EntityManager global que travava conexões.
     * Agora cada método gerencia seu próprio ciclo de abertura e fechamento.
     */
    public boolean salvar(Reserva r) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            if (r.getIdReserva() == 0) { // Se o ID for 0, insere novo registro
                em.persist(r);
            } else { // Se o ID já existir, atualiza os dados
                em.merge(r);
            }

            em.getTransaction().commit();
            System.out.println("DADOS SALVOS COM SUCESSO!");
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar reserva: " + e.getMessage());
            return false;
        } finally {
            em.close(); // Garante o fechamento da conexão com o MySQL
        }
    }

    //Valida se um determinado quarto possui conflito de reservas no período escolhido
     
    public boolean isQuartoOcupado(int idQuarto, Date entrada, Date saida) {
        EntityManager em = emf.createEntityManager();
        try {
            // JPQL que verifica sobreposição de datas ignorando check-outs finalizados
            String jpql = "SELECT COUNT(r) FROM Reserva r WHERE r.quarto.idQuarto = :idQuarto "
                        + "AND r.status <> 'FINALIZADO' "
                        + "AND (:entrada < r.datasaida AND :saida > r.dataentrada)";
            
            Long resultado = em.createQuery(jpql, Long.class)
                    .setParameter("idQuarto", idQuarto)
                    .setParameter("entrada", entrada)
                    .setParameter("saida", saida)
                    .getSingleResult();
            
            return resultado > 0; // Retorna true se houver qualquer conflito de data
        } catch (Exception e) {
            System.err.println("Erro ao validar disponibilidade: " + e.getMessage());
            return true; // Bloqueia o agendamento por segurança em caso de falha na query
        } finally {
            em.close();
        }
    }

    
      //Atualiza dinamicamente o status de uma reserva (Ex: Mudar de 'RESERVADA' para 'FINALIZADO')
     
    public void atualizarStatus(int idReserva, String novoStatus) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Reserva r = em.find(Reserva.class, idReserva);
            if (r != null) {
                r.setStatus(novoStatus);
                em.merge(r);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao atualizar status da reserva: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Reserva> listar() {
        EntityManager em = emf.createEntityManager();
        List<Reserva> reserva = null;
        try {
            reserva = em.createQuery("FROM Reserva", Reserva.class).getResultList();
            System.out.println("Reservas encontradas: " + (reserva != null ? reserva.size() : 0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return reserva;
    }

    public Reserva buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public List<Reserva> buscarPorCliente(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                "SELECT r FROM Reserva r "
              + "WHERE LOWER(r.cliente.nome) "
              + "LIKE LOWER(:nome)",
                Reserva.class
            )
            .setParameter("nome", "%" + nome + "%")
            .getResultList();
        } finally {
            em.close();
        }
    }
}
