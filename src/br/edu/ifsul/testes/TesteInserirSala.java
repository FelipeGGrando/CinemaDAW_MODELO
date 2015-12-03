package br.edu.ifsul.testes;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Sala;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirSala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("cinema_dawPU");
            em = emf.createEntityManager();
            Sala s = new Sala();
            s.setNome("Sala A");
            s.setDescricao("Cinema 3D, Tela 500'");
            s.setQuantidade(250);
            Funcionario obj = em.find(Funcionario.class,6);
            s.setFuncionario(obj);
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } finally{
            em.close();
            emf.close();
        }
    }

}
