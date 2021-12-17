package polo.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import polo.logica.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import polo.logica.Paquete;
import polo.logica.Servicio;
import polo.persistencia.exceptions.IllegalOrphanException;
import polo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Leo Martinez
 */
public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PaqueteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TPFinalv2PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) throws IllegalOrphanException {
        if (paquete.getPedidos() == null) {
            paquete.setPedidos(new ArrayList<Venta>());
        }
        if (paquete.getServicios() == null) {
            paquete.setServicios(new ArrayList<Servicio>());
        }
        List<String> illegalOrphanMessages = null;
        Venta pedidosVentaOrphanCheck = (Venta) paquete.getPedidos();
        if (pedidosVentaOrphanCheck != null) {
            Paquete oldPaqueteOfPedidosVenta = pedidosVentaOrphanCheck.getPaquete();
            if (oldPaqueteOfPedidosVenta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<>();
                }
                illegalOrphanMessages.add("The Venta " + pedidosVentaOrphanCheck + " already has an item of type Paquete whose pedidosVenta column cannot be null. Please make another selection for the pedidosVenta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedPedidos = new ArrayList<Venta>();
            for (Venta pedidosVentaToAttach : paquete.getPedidos()) {
                pedidosVentaToAttach = em.getReference(pedidosVentaToAttach.getClass(), pedidosVentaToAttach.getIdVenta());
                attachedPedidos.add(pedidosVentaToAttach);
            }
            paquete.setPedidos(attachedPedidos);
            List<Servicio> attachedServicios = new ArrayList<Servicio>();
            for (Servicio serviciosServicioToAttach : paquete.getServicios()) {
                serviciosServicioToAttach = em.getReference(serviciosServicioToAttach.getClass(), serviciosServicioToAttach.getIdServicio());
                attachedServicios.add(serviciosServicioToAttach);
            }
            paquete.setServicios(attachedServicios);
            em.persist(paquete);
            for (Venta pedidosVenta : paquete.getPedidos()) {
                pedidosVenta.setPaquete(paquete);
                pedidosVenta = em.merge(pedidosVenta);
            }
            for (Servicio serviciosServicio : paquete.getServicios()) {
                serviciosServicio.getPaquetes().add(paquete);
                serviciosServicio = em.merge(serviciosServicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getIdPaquete());
            List<Venta> pedidosOld = persistentPaquete.getPedidos();
            List<Venta> pedidosNew = paquete.getPedidos();
            List<Servicio> serviciosOld = persistentPaquete.getServicios();
            List<Servicio> serviciosNew = paquete.getServicios();
            List<Venta> attachedPedidosNew = new ArrayList<Venta>();
            for (Venta pedidosNewVentaToAttach : pedidosNew) {
                pedidosNewVentaToAttach = em.getReference(pedidosNewVentaToAttach.getClass(), pedidosNewVentaToAttach.getIdVenta());
                attachedPedidosNew.add(pedidosNewVentaToAttach);
            }
            pedidosNew = attachedPedidosNew;
            paquete.setPedidos(pedidosNew);
            List<Servicio> attachedServiciosNew = new ArrayList<Servicio>();
            for (Servicio serviciosNewServicioToAttach : serviciosNew) {
                serviciosNewServicioToAttach = em.getReference(serviciosNewServicioToAttach.getClass(), serviciosNewServicioToAttach.getIdServicio());
                attachedServiciosNew.add(serviciosNewServicioToAttach);
            }
            serviciosNew = attachedServiciosNew;
            paquete.setServicios(serviciosNew);
            paquete = em.merge(paquete);
            for (Venta pedidosOldVenta : pedidosOld) {
                if (!pedidosNew.contains(pedidosOldVenta)) {
                    pedidosOldVenta.setPaquete(null);
                    pedidosOldVenta = em.merge(pedidosOldVenta);
                }
            }
            for (Venta pedidosNewVenta : pedidosNew) {
                if (!pedidosOld.contains(pedidosNewVenta)) {
                    Paquete oldPaqueteOfPedidosNewVenta = pedidosNewVenta.getPaquete();
                    pedidosNewVenta.setPaquete(paquete);
                    pedidosNewVenta = em.merge(pedidosNewVenta);
                    if (oldPaqueteOfPedidosNewVenta != null && !oldPaqueteOfPedidosNewVenta.equals(paquete)) {
                        oldPaqueteOfPedidosNewVenta.getPedidos().remove(pedidosNewVenta);
                        oldPaqueteOfPedidosNewVenta = em.merge(oldPaqueteOfPedidosNewVenta);
                    }
                }
            }
            for (Servicio serviciosOldServicio : serviciosOld) {
                if (!serviciosNew.contains(serviciosOldServicio)) {
                    serviciosOldServicio.getPaquetes().remove(paquete);
                    serviciosOldServicio = em.merge(serviciosOldServicio);
                }
            }
            for (Servicio serviciosNewServicio : serviciosNew) {
                if (!serviciosOld.contains(serviciosNewServicio)) {
                    serviciosNewServicio.getPaquetes().add(paquete);
                    serviciosNewServicio = em.merge(serviciosNewServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getIdPaquete();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
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
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getIdPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            List<Venta> pedidos = paquete.getPedidos();
            for (Venta pedidosVenta : pedidos) {
                pedidosVenta.setPaquete(null);
                pedidosVenta = em.merge(pedidosVenta);
            }
            List<Servicio> servicios = paquete.getServicios();
            for (Servicio serviciosServicio : servicios) {
                serviciosServicio.getPaquetes().remove(paquete);
                serviciosServicio = em.merge(serviciosServicio);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
