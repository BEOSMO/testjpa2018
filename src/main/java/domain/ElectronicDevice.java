package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

    @Entity
	public class ElectronicDevice {
    	
    	@Id
		@GeneratedValue
		private long id;
    	@ManyToOne
		private Person p;
    	private long watts;
    	
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Person getP() {
			return p;
		}
		public void setP(Person p) {
			this.p = p;
		}
		public long getWatts() {
			return watts;
		}
		public void setWatts(long watts) {
			this.watts = watts;
		}
		public ElectronicDevice(long watts, Person p) {
			
			this.p = p;
			this.watts = watts;
		}
		public ElectronicDevice() {
			
		}
    	
		
    	
}
