package org.kainos.ea.cli;

public class Customer {

    //put inn customer info eg customer iD

    private int CustomerId;
    private String name;
    private String address;
    private String phone;


    public Customer(int customerId, String name, String address, String phone) {
        setCustomerId(customerId);
        setName(name);
        setAddress(address);
        setPhone(phone);

    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
