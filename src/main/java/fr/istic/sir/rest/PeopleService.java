package fr.istic.sir.rest;

import domain.Person;
import jpa.PersonDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/people")
public class PeopleService {
  public PersonDao personDao =new PersonDao();

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<Person> allPeople() {
    return this.personDao.readAll();
  }

  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Person getById(@PathParam("id") int id){
    return this.personDao.read(id);
  }


}
