package br.edu.ifsul.dao;
import br.edu.ifsul.modelo.Sessao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessaoDAO implements Serializable {
    
    private List<Sessao> listarTodos;
    
    public SessaoDAO(){
        
    }
    
    public void persist(Sessao objeto) throws Exception{
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
    
    public void merge(Sessao objeto) throws Exception{
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
            Sessao objeto = em.find(Sessao.class, id);
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
    
    public Sessao getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            Sessao obj = em.find(Sessao.class, id);
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

    public List<Sessao> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Sessao order by data_sessao").getResultList();
        } catch(Exception e){
            throw new Exception("Erro na operação de persistência: "+e.getMessage());
        } finally {
            em.close();
            emf.close();
        }    
    }

    public void setListarTodos(List<Sessao> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
