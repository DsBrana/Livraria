create database livraria;

 use livraria;
 
 create table estoque (
 id integer not null,
 titulo varchar (50),
 autor varchar (50),
 preco decimal (5,2),
 quantidade integer
 );
  
 drop table estoque;
 
 select*from estoque;
 
 insert into estoque (titulo, autor, preço, quantidade) values ("O programador pragmático: De aprendiz a mestre", "Andrew Hunt, David Thomas", 125.50, 50);