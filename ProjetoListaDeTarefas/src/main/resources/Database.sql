CREATE DATABASE listaTarefaDB;

use listaTarefaDB;

CREATE TABLE tarefa(
id int not null auto_increment,
titulo varchar(50),
descricao varchar(70),
primary key(id));

