/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import polo.logica.Cliente;
import polo.logica.Empleado;
import polo.logica.Pago;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import polo.logica.Venta;
import polo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author profl
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public VentaJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalv2PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getPagos() == null) {
            venta.setPagos(new ArrayList<Pago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente comprador = venta.getComprador();
            if (comprador != null) {
                comprador = em.getReference(comprador.getClass(), comprador.getIdCliente());
                venta.setComprador(comprador);
            }
            Empleado vendedor = venta.getVendedor();
            if (vendedor != null) {
                vendedor = em.getReference(vendedor.getClass(), vendedor.getIdEmpleado());
                venta.setVendedor(vendedor);
            }
            List<Pago> attachedPagos = new ArrayList<Pago>();
            for (Pago pagosPagoToAttach : venta.getPagos()) {
                pagosPagoToAttach = em.getReference(pagosPagoToAttach.getClass(), pagosPagoToAttach.getIdPago());
                attachedPagos.add(pagosPagoToAttach);
            }
            venta.setPagos(attachedPagos);
            em.persist(venta);
            if (comprador != null) {
                comprador.getCompras().add(venta);
                comprador = em.merge(comprador);
            }
            if (vendedor != null) {
                vendedor.getCompras().add(venta);
                vendedor = em.merge(vendedor);
            }
            for (Pago pagosPago : venta.getPagos()) {
                Venta oldVentaOfPagosPago = pagosPago.getVenta();
                pagosPago.setVenta(venta);
                pagosPago = em.merge(pagosPago);
                if (oldVentaOfPagosPago != null) {
                    oldVentaOfPagosPago.getPagos().remove(pagosPago);
                    oldVentaOfPagosPago = em.merge(oldVentaOfPagosPago);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVenta());
            Cliente compradorOld = persistentVenta.getComprador();
            Cliente compradorNew = venta.getComprador();
            Empleado vendedorOld = persistentVenta.getVendedor();
            Empleado vendedorNew = venta.getVendedor();
            List<Pago> pagosOld = persistentVenta.getPagos();
            List<Pago> pagosNew = venta.getPagos();
            if (compradorNew != null) {
                compradorNew = em.getReference(compradorNew.getClass(), compradorNew.getIdCliente());
                venta.setComprador(compradorNew);
            }
            if (vendedorNew != null) {
                vendedorNew = em.getReference(vendedorNew.getClass(), vendedorNew.getIdEmpleado());
                venta.setVendedor(vendedorNew);
            }
            List<Pago> attachedPagosNew = new ArrayList<Pago>();
            for (Pago pagosNewPagoToAttach : pagosNew) {
                pagosNewPagoToAttach = em.getReference(pagosNewPagoToAttach.getClass(), pagosNewPagoToAttach.getIdPago());
                attachedPagosNew.add(pagosNewPagoToAttach);
            }
            pagosNew = attachedPagosNew;
            venta.setPagos(pagosNew);
            venta = em.merge(venta);
            if (compradorOld != null && !compradorOld.equals(compradorNew)) {
                compradorOld.getCompras().remove(venta);
                compradorOld = em.merge(compradorOld);
            }
            if (compradorNew != null && !compradorNew.equals(compradorOld)) {
                compradorNew.getCompras().add(venta);
                compradorNew = em.merge(compradorNew);
            }
            if (vendedorOld != null && !vendedorOld.equals(vendedorNew)) {
                vendedorOld.getCompras().remove(venta);
                vendedorOld = em.merge(vendedorOld);
            }
            if (vendedorNew != null && !vendedorNew.equals(vendedorOld)) {
                vendedorNew.getCompras().add(venta);
                vendedorNew = em.merge(vendedorNew);
            }
            for (Pago pagosOldPago : pagosOld) {
                if (!pagosNew.contains(pagosOldPago)) {
                    pagosOldPago.setVenta(null);
                    pagosOldPago = em.merge(pagosOldPago);
                }
            }
            for (Pago pagosNewPago : pagosNew) {
                if (!pagosOld.contains(pagosNewPago)) {
                    Venta oldVentaOfPagosNewPago = pagosNewPago.getVenta();
                    pagosNewPago.setVenta(venta);
                    pagosNewPago = em.merge(pagosNewPago);
                    if (oldVentaOfPagosNewPago != null && !oldVentaOfPagosNewPago.equals(venta)) {
                        oldVentaOfPagosNewPago.getPagos().remove(pagosNewPago);
                        oldVentaOfPagosNewPago = em.merge(oldVentaOfPagosNewPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = venta.getIdVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente comprador = venta.getComprador();
            if (comprador != null) {
                comprador.getCompras().remove(venta);
                comprador = em.merge(comprador);
            }
            Empleado vendedor = venta.getVendedor();
            if (vendedor != null) {
                vendedor.getCompras().remove(venta);
                vendedor = em.merge(vendedor);
            }
            List<Pago> pagos = venta.getPagos();
            for (Pago pagosPago : pagos) {
                pagosPago.setVenta(null);
                pagosPago = em.merge(pagosPago);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
