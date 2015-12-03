package br.edu.ifsul.dao;
import br.edu.ifsul.modelo.Ator;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AtorDAO implements Serializable {
    
    private List<Ator> listarTodos;
    
    public AtorDAO(){
        
    }
    
    public void persist(Ator objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }        
    }
    
    public void merge(Ator objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }        
    }    
    
    public void remove(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            Ator objeto = em.find(Ator.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }        
    }   
    
    public Ator getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            Ator obj = em.find(Ator.class, id);
            return obj;
        } catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }        
    }     

    public List<Ator> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Ator order by nome").getResultList();
        } catch(Exception e){
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }    
    }

    public void setListarTodos(List<Ator> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
