package ml.bondarev.iis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "study_group_academic_subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupAcademicSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_study_group")
    private int studyGroupId;

    @Column(name = "id_academic_subject")
    private int academicSubjectId;

    @Column(name = "number_hours")
    private int number_hours;

}
