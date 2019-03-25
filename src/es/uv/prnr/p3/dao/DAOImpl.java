package es.uv.prnr.p3.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class DAOImpl<K, T> implements DAO<K, T> {

	protected EntityManager em;
	protected Class<T> entityClass;

	protected DAOImpl(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}

	public List<T> findAll() {
		Query q = em.createQuery("from " + this.entityClass.getName());
		return q.getResultList();
	}

	public T getById(K id) {
		return em.find(entityClass, id);
	}

	public void create(T entity) {
		this.em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void update(T entity) {
		this.em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public void delete(T entity) {
		this.em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	// Recibe un identificador de una entidad concreta y lo borra devolviendo
	// true o devuelve false
	
	public boolean deleteById(K id) {
		T entity = this.em.find(entityClass, id);
		if (entity != null) {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
		}
		return !this.em.contains(entity);
	}

	// Recibe una condici�n para la cl�usula WHERE con formato JPQL (criteria)
	// y retorna las entidades que la cumplen
	
	public List<T> findByCriteria(String fieldName, String value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> data = cq.from(entityClass);
		Predicate namePredicate = cb.equal(data.get(fieldName), value);
		cq.where(namePredicate);
		TypedQuery<T> query = em.createQuery(cq);
		return query.getResultList();
	}

}
