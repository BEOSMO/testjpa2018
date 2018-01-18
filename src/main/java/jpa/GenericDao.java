package jpa;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {

	T create(T t);

	T read(PK id, Class c);

	T update(T t);

	void delete(T t);

}
