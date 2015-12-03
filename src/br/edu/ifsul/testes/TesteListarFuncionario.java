package br.edu.ifsul.testes;
import br.edu.ifsul.modelo.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListarFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        String jpql = "from Funcionario";
        List<Funcionario> lista = em.createQuery(jpql).getResultList();
        for (Funcionario c : lista){
            System.out.println("ID: "+c.getId()+" Nome: "+c.getNome());
        }
        em.close();
        emf.close();
        
    }

}
