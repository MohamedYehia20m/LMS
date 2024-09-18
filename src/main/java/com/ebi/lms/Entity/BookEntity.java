package com.ebi.lms.Entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publicationYear;
}
