package pl.sda.dreamhotelsystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class UserHotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String telephone;
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String access;

    public UserHotel() {
    }

    public UserHotel(int id, String name, String surname, String telephone, LocalDate dateOfBirth, String access) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.access = access;
    }

    public UserHotel(String name, String surname, String telephone, LocalDate dateOfBirth, String access) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAccess() {
        return access;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", access='" + access + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHotel user = (UserHotel) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(telephone, user.telephone) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(access, user.access);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, telephone, dateOfBirth, access);
    }
}
