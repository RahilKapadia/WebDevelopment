package com.me.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="owner_info")
@Table(appliesTo = "owner_info")
public class Owner {
	
	public Owner() {
		
		
	}
	@Id 
	 @GeneratedValue (strategy = GenerationType.AUTO)
	private int Oid;
	 private String username;
	   private String password;
	private String Ofname;
	private String Olname;
	
	    private Date Odob;
	    private String Ogender;
	    private String Ostreet;
	    private String Ocity;
	    private String Ostate;
	    private String Ozip;
	    private String Ocontact;
	    private String Olicense;
	    private String Oemail;
	  
	    
	    public int getOid() {
			return Oid;
		}
		public void setOid(int oid) {
			Oid = oid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getOfname() {
			return Ofname;
		}
		public void setOfname(String ofname) {
			Ofname = ofname;
		}
		public String getOlname() {
			return Olname;
		}
		public void setOlname(String olname) {
			Olname = olname;
		}
		public Date getOdob() {
			return Odob;
		}
		public void setOdob(Date odob) {
			Odob = odob;
		}
		public String getOgender() {
			return Ogender;
		}
		public void setOgender(String ogender) {
			Ogender = ogender;
		}
		public String getOstreet() {
			return Ostreet;
		}
		public void setOstreet(String ostreet) {
			Ostreet = ostreet;
		}
		public String getOcity() {
			return Ocity;
		}
		public void setOcity(String ocity) {
			Ocity = ocity;
		}
		public String getOstate() {
			return Ostate;
		}
		public void setOstate(String ostate) {
			Ostate = ostate;
		}
		public String getOzip() {
			return Ozip;
		}
		public void setOzip(String ozip) {
			Ozip = ozip;
		}
		public String getOcontact() {
			return Ocontact;
		}
		public void setOcontact(String ocontact) {
			Ocontact = ocontact;
		}
		public String getOlicense() {
			return Olicense;
		}
		public void setOlicense(String olicense) {
			Olicense = olicense;
		}
		public String getOemail() {
			return Oemail;
		}
		public void setOemail(String oemail) {
			Oemail = oemail;
		}

		
	   
}
