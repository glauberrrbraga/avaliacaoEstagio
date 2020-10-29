create database dbinfo;
use dbinfo;

create table tbusuarios(
id int primary key auto_increment,
usuario varchar(50) not null,
telefone varchar(15) not null,
login varchar(15) not null unique,
senha varchar(15) not null,
cpf varchar(11) not null unique,
endereco varchar(50) not null,
perfil varchar(50) not null
);

create table pescado(
id int primary key auto_increment,
nome varchar(50) not null,
massa int not null,
tamano int not null,
id_usuario int not null,
foreign key(id_usuario) references tbusuarios(id)
);

create table pescaria(
id int primary key auto_increment,
dataP timestamp default current_timestamp,
localizacao varchar(50) not null,
id_usuario int not null,
datapescaria varchar(50) not null,
foreign key(id_usuario) references tbusuarios(id)
);


insert into tbusuarios(usuario,telefone,login,senha,cpf,endereco, perfil)
values('Administrador', '0', 'admin', 'admin', 123456789, 'admin', 'admin');
insert into tbusuarios(usuario,telefone,login,senha,cpf,endereco, perfil)
values('Glauber Braga', '8299111-7885', 'glauber', 'senha', 11111111111, 'Casa', 'admin');


