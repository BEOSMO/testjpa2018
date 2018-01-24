package domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Entity
	public class Home {

	private int id;

	private long surface;
	private int rooms;
	private Person proprio;

	private List<Heater> heaters;

		public Home() {
		}


		@Id
	@GeneratedValue
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Home(String rooms, String surface) {

	}



    public Home(long surface, int rooms, Person proprio) {
		super();
		this.surface = surface;
		this.rooms = rooms;
		this.proprio = proprio;

	}

		public Home(long surface, int rooms) {
			super();
			this.surface = surface;
			this.rooms = rooms;
			//this.proprio = proprio;

		}





	public long getSurface() {
		return surface;
	}



	public void setSurface(long surface) {
		this.surface = surface;
	}



	public int getRooms() {
		return rooms;
	}



	public void setRooms(int rooms) {
		this.rooms = rooms;
	}


	@OneToMany(mappedBy="home")
	public List<Heater> getHeaters() {
		return heaters;
	}

	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}



	@ManyToOne
	public Person getProprio() {
		return proprio;
	}



	public void setProprio(Person proprio) {
		this.proprio = proprio;
	}


        @GET
        @Path("/home")
        @Produces(MediaType.APPLICATION_JSON)
        public Home getHome() {
            Home h = new Home();
            h.setName("toto");
            Heater h1 = new Heater();
            h1.setPower("500w");
            Heater h2 = new Heater();
            h2.setPower("600w");
            h.addDevice(h1);
            h.addDevice(h2);
            return h;
        }




}




