create table iis.time(
  id int(2) not null primary key auto_increment,
  time_from time,
  time_to time
) engine = InnoDB;