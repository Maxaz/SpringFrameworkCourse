package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("Neil");
        author1.setLastName("Gaiman");

        Book book1 = new Book();
        book1.setTitle("American Gods");
        book1.setIsbn("1234567");

        Author author1Saved = authorRepository.save(author1);
        Book book1Saved = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("Frank");
        author2.setLastName("Herbert");

        Book book2 = new Book();
        book2.setTitle("Dune");
        book2.setIsbn("7654321");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        book1Saved.getAuthors().add(author1Saved);
        book2Saved.getAuthors().add(author2Saved);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("qwerty");
        Publisher publisher1Saved = publisherRepository.save(publisher1);

        book1Saved.setPublisher(publisher1Saved);
        book2Saved.setPublisher(publisher1Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

//        publisher1Saved.getBooks().add(book1Saved);
//        publisher1Saved.getBooks().add(book2Saved);

        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);
//        publisherRepository.save(publisher1Saved);


        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
