package edu.iesam.features.authors.presentation;

import edu.iesam.features.authors.data.AuthorDataRepository;
import edu.iesam.features.authors.data.AuthorMemLocalDataSource;
import edu.iesam.features.authors.domain.Author;
import edu.iesam.features.authors.domain.DeleteAuthorsUseCase;
import edu.iesam.features.authors.domain.GetAuthorsUseCase;
import edu.iesam.features.authors.domain.SaveAuthorsUseCase;

import java.util.ArrayList;

public class AuthorView {

    public static void printAuthors() {
        GetAuthorsUseCase getAuthorsUseCase = new GetAuthorsUseCase(
                new AuthorDataRepository(new AuthorMemLocalDataSource()));

        ArrayList<Author> authors = getAuthorsUseCase.execute();
        System.out.println(authors);
    }

    public static void saveAuthor() {
        Author newAuthor = new Author("1", "Author1", "2000-01-02", "España");

        SaveAuthorsUseCase saveAuthorsUseCase = new SaveAuthorsUseCase(new AuthorDataRepository(new AuthorMemLocalDataSource()));

        saveAuthorsUseCase.execute(newAuthor);
    }

    public static void deleteAuthor() {
        DeleteAuthorsUseCase deleteAuthorsUseCase = new DeleteAuthorsUseCase(new AuthorDataRepository(new AuthorMemLocalDataSource()));
        deleteAuthorsUseCase.execute("1");

    }

}
