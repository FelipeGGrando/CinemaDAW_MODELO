package br.edu.ifsul.testes;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class TesteInserirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("cinema_dawPU");
            em = emf.createEntityManager();
            Usuario obj = new Usuario();
            obj.setApelido("root");
            obj.setSenha("root");
            obj.setAdministrador(true);
            obj.setAtivo(true);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            if (em.getTransaction().isActive() == false){
                em.getTransaction().commit();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
