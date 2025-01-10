package com.othmane.book.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private Integer id;

    private String title;

    private String authorName;

    private String isbn;

    private String synopsis;

    private String owner;   // owner name

    private byte[] cover;   // picture of the book

    private double rate;    // average of feedbacks (stars)

    private boolean archived;

    private boolean shareable;
}
