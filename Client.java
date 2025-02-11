package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    // Constructors, getters, setters, toString()
    public Client() {}

    public Client(String name, String gender, int age, String location, String email, String mobileNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age +
               ", location=" + location + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
    }
}


