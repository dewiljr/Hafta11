package dev.patika;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private int id; // book_id

    @Column(name = "book_name", unique = true, length = 100, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_pub_year", unique = true, nullable = false)
    private LocalDate pubYear;


    @Column(name = "book_stock", nullable = false)
    private int stock;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")

    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<Borrower> borrowerList;

    @ManyToMany(mappedBy = "bookList")
    List <Category> categoryList;


    public Book() {

    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPubYear() {
        return pubYear;
    }

    public void setPubYear(LocalDate pubYear) {
        this.pubYear = pubYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Borrower> getBorrowerList() {
        return borrowerList;
    }

    public void setBorrowerList(List<Borrower> borrowerList) {
        this.borrowerList = borrowerList;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pubYear=" + pubYear +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
