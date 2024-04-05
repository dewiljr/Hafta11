package dev.patika;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrower")
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrower_id", columnDefinition = "serial")
    private int id;

    @Column(name = "borrower_name", length = 100, nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "borrower_date")
    private LocalDate borrower_date;

    @Column(name = "return_date")
    private LocalDate return_date;

    @ManyToOne ( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;




    public Borrower() {
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

    public LocalDate getBorrower_date() {
        return borrower_date;
    }

    public void setBorrower_date(LocalDate borrower_date) {
        this.borrower_date = borrower_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
