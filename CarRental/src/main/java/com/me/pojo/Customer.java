package com.me.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="customer_info")
@Table(appliesTo = "customer_info")
public class Customer {
	
	
	 public Customer() {
		
	}
	 @Id 
	 @GeneratedValue (strategy = GenerationType.AUTO)
	 private int Cid;

	private String Cfname;

	private String Clname;
	
	    private Date Cdob;
	    private String Cgender;

	    private String Cstreet;
	  
	    private String Ccity;

	    private String Cstate;
	    
	    
	    private String Czip;
	    private String Ccontact;
	    private String Clicense;
	    @Column(name="Cemail")
	   
	    private String cemail;
	  
	    private String username;
	
	   private String password;
	   @Transient
	   private String role;
	   
	   
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

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	   
	    public String getCemail() {
	        return cemail;
	    }

	    public void setCemail(String cemail) {
	        this.cemail = cemail;
	    }

	     
	    public Date getCdob() {
	        return Cdob;
	    }

	    public void setCdob(Date Cdob) {
	        this.Cdob = Cdob;
	    }
	 

	    public String getCfname() {
	        return Cfname;
	    }

	    public void setCfname(String Cfname) {
	        this.Cfname = Cfname;
	    }

	    public String getCstreet() {
	        return Cstreet;
	    }

	    public void setCstreet(String Cstreet) {
	        this.Cstreet = Cstreet;
	    }

	    public String getCcity() {
	        return Ccity;
	    }

	    public void setCcity(String Ccity) {
	        this.Ccity = Ccity;
	    }

	    public String getCstate() {
	        return Cstate;
	    }

	    public void setCstate(String Cstate) {
	        this.Cstate = Cstate;
	    }

	    public String getCzip() {
	        return Czip;
	    }

	    public void setCzip(String Czip) {
	        this.Czip = Czip;
	    }

	    public String getCcontact() {
	        return Ccontact;
	    }

	    public void setCcontact(String Ccontact) {
	        this.Ccontact = Ccontact;
	    }

	    public String getClicense() {
	        return Clicense;
	    }

	    public void setClicense(String Clicense) {
	        this.Clicense = Clicense;
	    }

		public String getClname() {
			return Clname;
		}

		public void setClname(String clname) {
			Clname = clname;
		}

		public String getCgender() {
			return Cgender;
		}

		public void setCgender(String cgender) {
			Cgender = cgender;
		}

		public int getCid() {
			return Cid;
		}

		public void setCid(int cid) {
			Cid = cid;
		}

	

}
