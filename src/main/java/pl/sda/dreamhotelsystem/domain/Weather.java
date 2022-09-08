package pl.sda.dreamhotelsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weather {

    private float temperatureValue;
    private String unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Float.compare(weather.temperatureValue, temperatureValue) == 0 && Objects.equals(unit, weather.unit);
    }
    @Override
    public int hashCode() {
        return Objects.hash(temperatureValue, unit);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperatureValue=" + temperatureValue +
                ", unit='" + unit + '\'' +
                '}';
    }
}
