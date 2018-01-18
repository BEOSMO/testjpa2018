package jpa;

import domain.Person;

import java.util.List;

public class PersonDao implements GenericDao<Person, Integer> {


    public Person create(Person person) {
        return null;
    }

    public Person read(Integer id, Class c) {
        return null;
    }
    public List<Person> readAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Person as p").getResultList();
    }

    public Person update(Person person) {
        return null;
    }

    public void delete(Person person) {

    }
}
