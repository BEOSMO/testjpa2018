package domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author xxx
 *
 */
	@Entity
	public class Person {
	
	@Column(name="PERSON_NAME")
    private int id;
    private String firstName;
    private String name;
    private String mail;

    private List<Person> friends;
    private List<Home> home;

    
    
    
    
    public Person() {
	}
	public Person(String firstName, String name, String mail) {
		this.firstName = firstName;
		this.name = name;
		this.mail = mail;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
   
    
    

    
    @OneToMany
    public List<Home> getHome() {
        return home;
    }
    
    public void setHome(List<Home> home) {
		this.home = home;
	}
    
    @ManyToMany
    public List<Person> getFriends() {
        return friends;
    }
    public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

    @Override
    public String toString() {
    	
    	
        return "Person [id=" + id + ", name=" + name + "]";
    }
    

    

}
