package com.riwi.library.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "books")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(length = 50, nullable = false)
    private String genre;

    @Column(length = 20, nullable = false)
    private String isbn;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loans;
    
}
