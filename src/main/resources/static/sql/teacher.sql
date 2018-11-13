create table iis.teacher(
  id int(2) not null primary key auto_increment,
  first_name varchar(255),
  last_name varchar(255),
  patronymic varchar(255)
) engine = InnoDB;