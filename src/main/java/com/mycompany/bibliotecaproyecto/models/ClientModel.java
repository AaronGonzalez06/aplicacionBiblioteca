package com.mycompany.bibliotecaproyecto.models;

public class ClientModel {
    
    private String name;
    private String surname;
    private String surnameTwo;
    private int age;
    private int phone;
    private String dni;
    private Boolean sanctioned;

    public ClientModel(String name, String surname, String surnameTwo, int age, int phone, String dni, Boolean sanctioned) {
        this.name = name;
        this.surname = surname;
        this.surnameTwo = surnameTwo;
        this.age = age;
        this.phone = phone;
        this.dni = dni;
        this.sanctioned = sanctioned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurnameTwo() {
        return surnameTwo;
    }

    public void setSurnameTwo(String surnameTwo) {
        this.surnameTwo = surnameTwo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getSanctioned() {
        return sanctioned;
    }

    public void setSanctioned(Boolean sanctioned) {
        this.sanctioned = sanctioned;
    }
    
    
    
}
