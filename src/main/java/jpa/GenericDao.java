package jpa;

import java.io.Serializable;

public interface GenericDao<T> {

	void create(T t);

	T read(int id);

	void update(T t);

	void delete(T t);

}
