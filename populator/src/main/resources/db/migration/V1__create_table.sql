DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id integer PRIMARY KEY,
    title VARCHAR (50) NOT NULL,
    description VARCHAR (255),
    genre integer,
    timestamp TIMESTAMP NOT NULL
);

CREATE TABLE author (
    id integer PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    timestamp TIMESTAMP NOT NULL
);
