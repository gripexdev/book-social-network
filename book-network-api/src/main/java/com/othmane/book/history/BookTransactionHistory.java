package com.othmane.book.history;

import com.othmane.book.book.Book;
import com.othmane.book.common.BaseEntity;
import com.othmane.book.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookTransactionHistory extends BaseEntity {

    // The association table
    // User relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Book relationship
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // approved by the user who borrowed the book
    private boolean returned;

    // approved by the book owner
    private boolean returnApproved;
}
