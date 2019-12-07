CREATE DATABASE IF NOT EXISTS efka CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE efka;

drop table if exists users;
create table users(
	user_id int unsigned not null,
    username varchar(50) not null,
    user_password varchar(50) not null,
    user_type varchar(1) not null,
    primary key(user_id)
)engine = InnoDB default charset = utf8mb4;

drop table if exists citizens;
create table citizens(
	amka varchar(11) not null,
    citizen_name varchar(50) not null,
    citizen_surname varchar(50) not null,
    citizen_email varchar(50) not null,
    citizen_phone varchar(50) not null,
    user_id int unsigned not null,
    primary key(amka),
    constraint fk_citizens_users foreign key(user_id) references users(user_id)
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
    specialty_id int unsigned not null,
    user_id int unsigned not null,
    primary key (doctor_id),
    constraint fk_doctors_specialty foreign key(specialty_id) references specialties(specialty_id),
    constraint fk_doctors_users foreign key(user_id) references users(user_id)
)engine = InnoDB default charset = utf8mb4;

drop table if exists appointments;
create table appointments(
	appointment_id int unsigned not null,
    appointment_date date,
	appointment_time time,
    appointment_description varchar(50) not null,
    appointment_comments varchar(50) not null,
    doctor_id int unsigned not null,
    amka varchar(11) not null,
    primary key(appointment_id),
    constraint fk_appointments_doctors foreign key(doctor_id) references doctors(doctor_id),
    constraint fk_appointments_citizens foreign key(amka) references citizens(amka)
)engine = InnoDB default charset = utf8mb4;