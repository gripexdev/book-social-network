package com.othmane.book.book;

import com.othmane.book.common.BaseEntity;
import com.othmane.book.feedback.Feedback;
import com.othmane.book.history.BookTransactionHistory;
import com.othmane.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    private String title;

    private String authorName;

    private String isbn;

    // small resume about the book
    private String synopsis;

    private String bookCover;

    private boolean archived;

    private boolean shareable;

    // the owner of the book (one book has one owner) - (user has many books)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // a book can have many feedbacks
    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    // The association table
    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;
}
