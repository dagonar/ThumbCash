package com.thumbcash.helpers;

/**
 *
 * @author Dagonar
 */
public class Contact {
    
    private String address;
    private String phone;
    private String state;
    private String city;
    
    public Contact(String address, String phone, String state, String city){
        this.address = address;
        this.phone = phone;
        this.state = state;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
