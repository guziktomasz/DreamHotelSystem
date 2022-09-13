package pl.sda.dreamhotelsystem.dto.users;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class UserHotelDto {

    private final String name;

    private final String surname;

    private final String telephone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate dateOfBirth;

    private final String access;

    public UserHotelDto(String name, String surname, String telephone, LocalDate dateOfBirth, String access) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.access = access;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAccess() {
        return access;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", access='" + access + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHotelDto)) return false;
        UserHotelDto userDto = (UserHotelDto) o;
        return Objects.equals(getName(), userDto.getName()) && Objects.equals(getSurname(), userDto.getSurname()) && Objects.equals(getTelephone(), userDto.getTelephone()) && Objects.equals(getDateOfBirth(), userDto.getDateOfBirth()) && Objects.equals(getAccess(), userDto.getAccess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getTelephone(), getDateOfBirth(), getAccess());
    }
}
