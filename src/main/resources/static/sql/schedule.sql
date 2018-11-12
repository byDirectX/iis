create table iis.schedule(
  id int(2) not null primary key auto_increment,
  id_group int(2),
  id_academic_subject int(2),
  id_substitution_academic_subject int(2),
  id_first_teacher int(2),
  id_second_teacher int(2),
  id_time int(2),
  flag int(2),
  foreign key (id_group) references study_group (id) on delete cascade on update cascade,
  foreign key (id_academic_subject) references academic_subject (id) on delete cascade on update cascade,
  foreign key (id_substitution_academic_subject) references academic_subject (id) on delete cascade on update cascade,
  foreign key (id_first_teacher) references teacher (id) on delete cascade on update cascade,
  foreign key (id_second_teacher) references teacher (id) on delete cascade on update cascade,
  foreign key (id_time) references time (id) on delete cascade on update cascade
) engine = InnoDB;