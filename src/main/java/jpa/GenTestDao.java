package jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

public class GenTestDao implements GenericDao {

	private EntityManager entityManager;

	/**
	 *
	 * 
	 * 
	 * @param entityManager
	 * 
	 */
	public GenTestDao(EntityManager entityManager) {

		this.entityManager = entityManager;

	}

	/**
	 * 
	 * @param o
	 * 
	 * @return
	 * 
	 */

	public Object create(Object o) {

		this.entityManager.persist(o);

		return o;

	}

	/**
	 * 
	 * @param id
	 * 
	 * @param c
	 * 
	 * @return
	 * 
	 */

	public Object read(Serializable id, Class c) {

		return this.entityManager.find(c, id);

	}

	/**
	 * 
	 * @param o
	 * 
	 * @return
	 * 
	 */

	public Object update(Object o) {

		return this.entityManager.merge(o);

	}

	/**
	 * 
	 * @param o
	 * 
	 */

	public void delete(Object o) {

		this.entityManager.remove(o);

	}

}