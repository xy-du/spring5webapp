package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Publisher publisher=new Publisher("XYpub","Mars Moon");
        publisherRepository.save(publisher);

        System.out.println("number of publisher "+publisherRepository.count());

        Book pybook=new Book("python book","121212121");
        Author austin=new Author("austin","du");
        austin.getBooks().add(pybook);
        pybook.getAuthors().add(austin);

        publisher.getBooks().add(pybook);
        pybook.setPublisher(publisher);

        authorRepository.save(austin);
        bookRepository.save(pybook);



        Book javaBook=new Book("java book","131313113");
        Author jack=new Author("jack","ck");
        jack.getBooks().add(javaBook);
        javaBook.getAuthors().add(jack);

        publisher.getBooks().add(javaBook);
        javaBook.setPublisher(publisher);

        authorRepository.save(jack);
        bookRepository.save(javaBook);

        publisherRepository.save(publisher);



        System.out.println("number of books "+bookRepository.count());

        System.out.println("Number of books in the publisher "+publisher.getBooks().size());
    }
}
