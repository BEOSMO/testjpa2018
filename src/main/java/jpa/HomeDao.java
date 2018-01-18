package jpa;

import domain.Home;
import domain.Person;

import java.util.List;

public class HomeDao implements GenericDao<Home, Integer> {
    public Home create(Home home) {
        return null;
    }

    public Home read(Integer id, Class c) {
        return null;
    }

    public Person read(){
        return (Person) EntityManagerHelper.getEntityManager().createQuery("select p from Home as p").getResultList();

    }


    public Home update(Home home) {
        return null;
    }

    public void delete(Home home) {

    }
}
