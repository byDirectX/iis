create table iis.user(
  id INT(2) not null primary key auto_increment,
  name VARCHAR(255),
  password VARCHAR(255),
  active BIT
) engine = InnoDB;