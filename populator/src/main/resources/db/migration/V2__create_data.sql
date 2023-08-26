INSERT INTO
    book (id, title, description, genre, timestamp)
VALUES
    (1, 'horror book', 'some horror book description', 1, now()),
    (2, 'romance book', 'some romance book description', 2, now()),
    (3, 'book for children', 'some childrens book description', 3, now());

INSERT INTO
    author (id, name, timestamp)
VALUES
    (1, 'jane doe', now()),
    (2, 'john doe', now());
