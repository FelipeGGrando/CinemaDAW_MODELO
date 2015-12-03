package br.edu.ifsul.dao;
import br.edu.ifsul.modelo.MeioIngresso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MeioIngressoDAO implements Serializable {
    
    private List<MeioIngresso> listarTodos;
    
    public MeioIngressoDAO(){
        
    }
    
    public void persist(MeioIngresso objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
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
    
    public void merge(MeioIngresso objeto) throws Exception{
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
            MeioIngresso objeto = em.find(MeioIngresso.class, id);
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
    
    public MeioIngresso getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            MeioIngresso obj = em.find(MeioIngresso.class, id);
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

    public List<MeioIngresso> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from MeioIngresso").getResultList();
        } catch(Exception e){
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }    
    }

    public void setListarTodos(List<MeioIngresso> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
