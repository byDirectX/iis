create table iis.department(
  id INT(2) not null primary key auto_increment,
  name VARCHAR(255),
  long_name VARCHAR(255)
) engine = InnoDB;