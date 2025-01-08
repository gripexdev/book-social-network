package com.othmane.book.feedback;

import com.othmane.book.book.Book;
import com.othmane.book.common.BaseEntity;
import jakarta.persistence.*;
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
public class Feedback extends BaseEntity {

    // 1-5 stars
    private Double note;

    // feedback
    private String comment;

    // many feedbacks are for one book
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
