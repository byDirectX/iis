package ml.bondarev.iis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "time")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "time_from")
    private String timeFrom;

    @Column(name = "time_to")
    private String timeTo;

    @Column(name = "type_day")
    private int typeDay;

    @Column(name = "number")
    private int number;

}
