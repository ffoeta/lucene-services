INSERT INTO
    book (id, title, description, genre, timestamp)
VALUES
    (gen_random_uuid(), 'horror book', 'some horror book description', 1, now()),
    (gen_random_uuid(), 'romance book', 'some romance book description', 2, now()),
    (gen_random_uuid(), 'book for children', 'some childrens book description', 3, now());