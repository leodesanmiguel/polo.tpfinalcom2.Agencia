/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import polo.logica.Empleado;
import polo.logica.Puesto;
import polo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author profl
 */
public class EmpleadoJpaController1 implements Serializable {

    public EmpleadoJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puesto suPuesto = empleado.getSuPuesto();
            if (suPuesto != null) {
                suPuesto = em.getReference(suPuesto.getClass(), suPuesto.getIdPuesto());
                empleado.setSuPuesto(suPuesto);
            }
            em.persist(empleado);
            if (suPuesto != null) {
                suPuesto.getListaEmpleados().add(empleado);
                suPuesto = em.merge(suPuesto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getIdEmpleado());
            Puesto suPuestoOld = persistentEmpleado.getSuPuesto();
            Puesto suPuestoNew = empleado.getSuPuesto();
            if (suPuestoNew != null) {
                suPuestoNew = em.getReference(suPuestoNew.getClass(), suPuestoNew.getIdPuesto());
                empleado.setSuPuesto(suPuestoNew);
            }
            empleado = em.merge(empleado);
            if (suPuestoOld != null && !suPuestoOld.equals(suPuestoNew)) {
                suPuestoOld.getListaEmpleados().remove(empleado);
                suPuestoOld = em.merge(suPuestoOld);
            }
            if (suPuestoNew != null && !suPuestoNew.equals(suPuestoOld)) {
                suPuestoNew.getListaEmpleados().add(empleado);
                suPuestoNew = em.merge(suPuestoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getIdEmpleado();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getIdEmpleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Puesto suPuesto = empleado.getSuPuesto();
            if (suPuesto != null) {
                suPuesto.getListaEmpleados().remove(empleado);
                suPuesto = em.merge(suPuesto);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
