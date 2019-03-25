package es.uv.prnr.p3.dao;

import java.util.List;

public interface DAO<K, T> {

	public T getById(K id);

	public List<T> findAll();

	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);

	// Añadir declaración de métodos deleteByID y findByCriteria

	public boolean deleteById(K id);

	public List<T> findByCriteria(String fieldName, String value);

}
