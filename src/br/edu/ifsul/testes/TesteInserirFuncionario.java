package br.edu.ifsul.testes;
import br.edu.ifsul.modelo.Funcionario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("cinema_dawPU");
            em = emf.createEntityManager();
            Funcionario obj = new Funcionario();
            obj.setTelefone("5499141740");
            obj.setCpf("436.333.512-21");
            obj.setNascimento(Calendar.getInstance());
            obj.setNome("João Carlos Miguel");               
            em.getTransaction().begin();
            em.persist(obj); // inserir
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
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
