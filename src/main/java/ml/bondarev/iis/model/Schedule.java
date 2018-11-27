package ml.bondarev.iis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_group")
    private int groupId;

    @Column(name = "id_academic_subject")
    private int academicSubjectId;

    @Column(name = "id_first_teacher")
    private int firstTeacherId;

    @Column(name = "id_second_teacher")
    private int secondTeacherId;

    @Column(name = "id_time")
    private int timeId;

    @Column(name = "flag")
    private int flag;

    @Temporal(TemporalType.DATE)
    @Column(name = "schedule_date", nullable = true, insertable = true, updatable = true)
    private Date scheduleDate;

}
