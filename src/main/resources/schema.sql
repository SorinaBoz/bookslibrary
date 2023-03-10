DROP TABLE books IF EXISTS;
CREATE TABLE books (
  id      INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  isbn VARCHAR(30),
  title  VARCHAR(30)
  loan_id INTEGER
);
ALTER TABLE books ADD CONSTRAINT fk_books_loans FOREIGN KEY (loan_id) REFERENCES loans (id);
CREATE INDEX books_title ON books (title);

