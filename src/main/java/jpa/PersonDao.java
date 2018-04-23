package jpa;

import domain.Person;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class PersonDao implements GenericDao<Person> {

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
  private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
  private EntityTransaction transaction = this.entityManager.getTransaction();

  /**
   * Method to create several persons objects in the database.
   *
   * @param p person objects
   */
  public void create(Person p) {
    this.transaction.begin();
    this.entityManager.persist(p);
    this.transaction.commit();
  }

  /**
   * Read provides a way to return an object from the database.
   *
   * @param id person id in the database
   */
  public Person read(int id) {
    return this.entityManager.find(Person.class, id);
  }

  /**
   * Update enables us to update several objects of type person.
   *
   * @param p person objects
   */
  public void update(Person p) {
    this.transaction.begin();
    this.entityManager.merge(p);
    this.transaction.commit();
  }

  /**
   * This method deletes several person objects records from the database.d
   *
   * @param o person objects
   */
  public void delete(Person o) {
    this.transaction.begin();
    this.entityManager.remove(o);
    entityManager.flush();
    entityManager.clear();
    this.transaction.commit();
  }

  public List<Person> readAll() {
    return this.entityManager.createQuery("from Person", Person.class).getResultList();
  }

}
