package ml.bondarev.iis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "daily_attendance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DailyAttendance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "id_day")
    private int dayId;

    @Column(name = "flag")
    private int flag;

    public DailyAttendance(String userName, int dayId, int flag) {
        this.userName = userName;
        this.dayId = dayId;
        this.flag = flag;
    }
}
