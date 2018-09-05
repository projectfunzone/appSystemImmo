package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements IGenericDao<T, PK> {

	@PersistenceContext(unitName = "AppSystemImmo")
	private EntityManager em;

	private Class<T> type;

	@Override
	public T create(T addInstance) {
		em.persist(addInstance);
		return (T) addInstance;
	}

	@Override
	public T read(Serializable id) {
		return em.find(type, id);
	}

	@Override
	public int update(T updInstance) {
		return (int) em.merge(updInstance);
	}

	@Override
	public void delete(T delInstance) {
		em.remove(delInstance);
	}

	@Override
	public List<T> Liste() {
		// TODO Auto-generated method stub
		return null;
	}

}