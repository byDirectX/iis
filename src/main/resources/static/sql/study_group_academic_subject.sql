create table iis.study_group_academic_subject(
  id INT(2) not null primary key auto_increment,
  id_study_group INT(2),
  id_academic_subject(2),
  number_hours INT(11),
  foreign key (id_study_group) references study_group (id) on delete cascade on update cascade,
  foreign key (id_academic_subject) references academicsubject (id) on delete cascade on update cascade
) engine = InnoDB;