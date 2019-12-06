CREATE DATABASE IF NOT EXISTS efka CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE efka;

drop table if exists users;
create table users(
	user_id int unsigned not null,
    username varchar(50) not null,
    user_password varchar(50) not null,
    primary key(user_id)
)engine = InnoDB default charset = utf8mb4;

drop table if exists citizens;
create table citizens(
	amka int unsigned not null,
    citizen_name varchar(50) not null,
    citizen_surname varchar(50) not null,
    citizen_email varchar(50) not null,
    citizen_phone varchar(50) not null,
    primary key(amka)
)engine = InnoDB default charset = utf8mb4;

drop table if exists specialties;
create table specialties(
	specialty_id int unsigned not null,
    specialty_name varchar(50) not null,
    primary key(specialty_id)
)engine = InnoDB default charset = utf8mb4;

drop table if exists doctors;
create table doctors(
	doctor_id int unsigned not null,
    doctor_name varchar(50) not null,
    doctor_surname varchar(50) not null,
    doctor_email varchar(50) not null,
    doctor_phone varchar(50) not null,
    primary key(doctor_id),
    constraint fk_doctors_users foreign key(doctor_id) references users(user_id) on delete cascade on update cascade,
    constraint fk_doctors_specialties foreign key(doctor_id) references specialties(specialty_id) on delete cascade on update cascade
)engine = InnoDB default charset = utf8mb4;

drop table if exists appointments;
create table appointments(
	appointment_id int unsigned not null,
    appointment_date date,
	appointment_time time,
    appointment_description varchar(50) not null,
    appointment_comments varchar(50) not null,
    primary key(appointment_id),
    constraint fk_appointments_citizens foreign key(appointment_id) references citizens(amka) on delete cascade on update cascade,
    constraint fk_appointments_doctors foreign key(appointment_id) references doctors(doctor_id) on delete cascade on update cascade
)engine = InnoDB default charset = utf8mb4;


