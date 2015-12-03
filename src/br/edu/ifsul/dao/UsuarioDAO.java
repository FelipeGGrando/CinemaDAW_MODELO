package br.edu.ifsul.dao;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO implements Serializable {

    private List<Usuario> listarTodos;

    public UsuarioDAO() {

    }

    public void persist(Usuario objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void merge(Usuario objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void remove(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            Usuario objeto = em.find(Usuario.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public boolean login(String usuario, String senha) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Usuario where upper(apelido) = :usuario and "
                    + " upper(senha) = :senha and ativo = true");
            query.setParameter("usuario", usuario.toUpperCase());
            query.setParameter("senha", senha.toUpperCase());
            if (!query.getResultList().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }

    public Usuario getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            Usuario obj = em.find(Usuario.class, id);
            return obj;
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    public Usuario localizarPorNomeUsuario(String usuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Usuario where upper(apelido) = :usuario");
            query.setParameter("usuario",usuario.toUpperCase());
            Usuario obj = (Usuario) query.getSingleResult();
            obj.getAcessos().size();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Usuario> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema_dawPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Usuario order by apelido").getResultList();
        } catch (Exception e) {
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Usuario> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
