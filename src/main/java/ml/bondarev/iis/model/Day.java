package ml.bondarev.iis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "day")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_time")
    private int timeId;

    @Temporal(TemporalType.DATE)
    @Column(name = "day_date", updatable = true, insertable = true, nullable = true)
    private Date date;

    @Column(name = "day_name")
    private String dayName;

    public Day(int timeId, Date date, String dayName) {
        this.timeId = timeId;
        this.date = date;
        this.dayName = dayName;
    }

    public Day() {

    }
}
