package gioelefriggia.u5d7.services;

import gioelefriggia.u5d7.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final List<Author> authors = new ArrayList<>();
    private int nextId = 1;

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthorById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author createAuthor(Author author) {
        author.setId(nextId++);
        authors.add(author);
        return author;
    }

    public Author updateAuthor(int id, Author updatedAuthor) {
        for (Author author : authors) {
            if (author.getId() == id) {
                author.setName(updatedAuthor.getName());
                author.setEmail(updatedAuthor.getEmail());
                return author;
            }
        }
        return null;
    }

    public void deleteAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
    }
}
