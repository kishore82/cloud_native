package com.project.oops.tutorial.aggregation;

public class Address {
	private String flat_no;
	private String street_name;
	private String locality;
	private String city;
	private String district;
	private String state;
	private int pincode;
	
	public Address(String flat_no, String street_name, String  city, String district, String state, int pincode) {
	    // parameterized constructor
	    // if no other constructors present, java will create a default empty constructor
		this.flat_no = flat_no; 
		this.state = state;
		this.city = city;
		this.district = district;
		this.pincode =  pincode;
		this.street_name = street_name;
	}
	
	public Address() {
	    // empty constructor
    	// if no other constructors present, java will create a default empty constructor
	} 

	// overrides default Object.java class's toString() method
    // All classes that we define will inherit Object.java class 
    @Override
    public String toString() {
        return  flat_no + " " + street_name + " " +   city + " " + district + " " + state + " " + pincode;
        
    }
    
    // getters and setters
	public String getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
