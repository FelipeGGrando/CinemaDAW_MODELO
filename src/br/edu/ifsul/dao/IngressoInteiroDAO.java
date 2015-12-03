package br.edu.ifsul.dao;
import br.edu.ifsul.modelo.IngressoInteiro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IngressoInteiroDAO implements Serializable {
    
    private List<IngressoInteiro> listarTodos;
    
    public IngressoInteiroDAO(){
        
    }
    
    public void persist(IngressoInteiro objeto) throws Exception{
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
    
    public void merge(IngressoInteiro objeto) throws Exception{
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
            IngressoInteiro objeto = em.find(IngressoInteiro.class, id);
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
    
    public IngressoInteiro getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            IngressoInteiro obj = em.find(IngressoInteiro.class, id);
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

    public List<IngressoInteiro> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from IngressoInteiro").getResultList();
        } catch(Exception e){
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }    
    }

    public void setListarTodos(List<IngressoInteiro> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
