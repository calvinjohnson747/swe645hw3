package com.example.hw3.survey;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String Fname;
    @Column(name="last_name")
    private String Lname;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private String zip;
    @Column(name="telephone")
    private String telephone;
    @Column(name="email")
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name="date_of_survey")
    private LocalDate Date = LocalDate.now();
    @ElementCollection
    @CollectionTable(name="options", joinColumns = @JoinColumn(name="id"))
    private Set<String> OptionValue;
    @Column(name="interest")
    private String RadioValue;
    @Column(name="recommendation")
    private String Recommendations;
    @Column(name="comments", columnDefinition = "TEXT")
    @Lob
    private String Comments;
    public Survey(){

    }

    public Survey(String fname, String lname, String address, String city, String state, String zip, String telephone, String email, Set<String> optionValue, String radioValue, String recommendations, String comments) {
        this.Fname = fname;
        this.Lname = lname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
        this.OptionValue = optionValue;
        this.RadioValue = radioValue;
        this.Recommendations = recommendations;
        this.Comments = comments;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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


    public Set<String> getOptionValue() {
        return OptionValue;
    }

    public void setOptionValue(Set<String> optionValue) {
        OptionValue = optionValue;
    }

    public String getRadioValue() {
        return RadioValue;
    }

    public void setRadioValue(String radioValue) {
        RadioValue = radioValue;
    }

    public String getRecommendations() {
        return Recommendations;
    }

    public void setRecommendations(String recommendations) {
        Recommendations = recommendations;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}

