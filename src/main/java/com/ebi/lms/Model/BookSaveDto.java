package com.ebi.lms.Model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BookSaveDto {
    private Long id;
    private String title;
    private String author;
    private String publicationYear;
}
