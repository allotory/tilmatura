create database budget;

create table sche (
	id integer primary key,
	scheType text,
	scheCategory integer,
	scheDate text,
	scheAmount real,
	scheDescription text
);

create table category (
	id integer primary key,
	cateName text
);