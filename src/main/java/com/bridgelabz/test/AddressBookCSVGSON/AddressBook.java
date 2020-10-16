package com.bridgelabz.test.AddressBookCSVGSON;


public class AddressBook {
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phone;
	private String email;
	
	public AddressBook() {
		
	}
	
	public AddressBook(String first_name, String last_name, String address, String city, String state, int zip, long phone, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone =phone;
		this.email = email;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true; 
        } 
       if (!(obj instanceof AddressBook)) { 
            return false; 
        } 
        AddressBook temp = (AddressBook) obj;
        if(first_name.equals(temp.first_name))
        	return true;
        else
        	return false;
    } 
	
	 public String toString() {  
	        return (first_name + " " + last_name + " " + address + " " + city + " " + state + " " + zip + " " + phone + " " + email); 
	    }  
}
