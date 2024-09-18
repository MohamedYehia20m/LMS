package com.ebi.lms.Model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String title;
    private String author;
    private String publicationYear;
}
