package net.fratech.frasys.infrastructure.daos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class GenericJPADAO <PersistentObject, IDType extends Serializable> implements DAO<PersistentObject, IDType> {

	private static final String PERSISTENCE_UNIT = "frasys";
	
	private Class<PersistentObject> persistentClass;
	private EntityManager em;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	
    public GenericJPADAO(Class<PersistentObject> clazz) {
        persistentClass = clazz;
    }
    
    protected EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (em != null && em.isOpen()) {
            return em;
        }
        return emf.createEntityManager();
    }
    
	public void close() {
		if (em != null && em.isOpen())
            em.close();
	}

	public PersistentObject find(IDType id) {
		em = getEntityManager();
		return em.find(persistentClass, id);
	}

	public PersistentObject getByNamedQuery(String queryName, Map<String, Object> params) {
		em = getEntityManager();
		Query query = em.createNamedQuery(queryName);
		
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		PersistentObject result;
		
		try{
			result = (PersistentObject) query.getSingleResult();
		}catch(NoResultException nre){
			try {
				return persistentClass.newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException("Error in named query: "+queryName + " - InstatiationException");
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Error in named query: "+queryName + " - IllegalAccessException");
			}
		}
		return result;
	}

	public List<PersistentObject> list() {
		em = getEntityManager();
		Query query = em.createQuery("SELECT obj FROM " + persistentClass.getSimpleName() + " obj");
		List<PersistentObject> list = query.getResultList();
		return list;
	}

	public List<PersistentObject> listByNamedQuery(String queryName, Map<String, Object> params) {
		em = getEntityManager();
		Query query = em.createNamedQuery(queryName);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				query.setParameter(key, params.get(key));
			}
		}
		List<PersistentObject> list = query.getResultList();
		return list;
	}

	public PersistentObject merge(PersistentObject obj) {
		em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		}catch(PersistenceException pe){
			tx.rollback();
			pe.printStackTrace();
		}
		return obj;
	}

	public PersistentObject persist(PersistentObject obj) {
		em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(obj);
			tx.commit();
			em.refresh(obj);
		}catch(PersistenceException pe){
			tx.rollback();
			pe.printStackTrace();
		}
		return obj;
	}

	public void remove(PersistentObject obj) {
		em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			obj = em.merge(obj);
			em.remove(obj);
			tx.commit();
		}catch(RuntimeException re){
			tx.rollback();
			re.printStackTrace();
			throw re;
		}
	}

}
