package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity
	public class Heater {
		
		
	    private int id;
	    private Home home;
	    
	    
	    
	    public Heater(Home home) {
	        this.home = home;
	    }
	    
	    public Heater() {
	      
	    }
	    @Id
	    @GeneratedValue
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	   
	    
	    @ManyToOne
		public Home getHome() {
			return home;
		}
	    
		public void setHome(Home home) {
			this.home = home;
		}
	    
	    
	    
	    
}
