DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS periodes;
DROP TABLE IF EXISTS demande_conges;
 
CREATE TABLE employees (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE periodes (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  date_debut VARCHAR(20) NOT NULL,
  nb_jours INT NOT NULL
);

CREATE TABLE demande_conges (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    periode_id INT NOT NULL,
    date_demande TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (periode_id) REFERENCES periodes(id)
);

