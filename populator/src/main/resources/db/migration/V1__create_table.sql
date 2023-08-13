DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id UUID PRIMARY KEY,
    title VARCHAR (50) NOT NULL,
    description VARCHAR (255),
    genre integer,
    timestamp TIMESTAMP NOT NULL
);