package com.othmane.book.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private List<T> content;

    private int number;

    // the size of each page
    private int size;

    private long totalElements;

    private int totalPages;

    // true if the page is the first one
    private boolean first;

    // true if the page is the last one
    private boolean last;
}
