package com.littlecorgi.suanfa.object2;

public class Address {
    String name;
    String telephone;
    String email;

    public Address(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "object1.Address{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Address a1 = new Address("1234", "123456789123", "1234@qq.com");
        Address a2 = new Address("2345", "213412512354", "5678@qq.com");
        Address a3 = new Address("3456", "534532142314", "1357@qq.com");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
    }
}

