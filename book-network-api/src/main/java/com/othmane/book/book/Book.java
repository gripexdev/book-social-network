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

    // path to the book cover
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

    @Transient
    public double getRate() {
        if (feedbacks == null || feedbacks.isEmpty()) {
            return 0.0;
        }
        var rate = this.feedbacks.stream()
                .mapToDouble(Feedback::getNote)
                .average()
                .orElse(0.0);
        double roundedRate = Math.round(rate * 10.0) / 10.0;

        // example => Return 4.0 if roundedRate is less than 4.5, otherwise return 4.5
        return roundedRate;
    }
}
