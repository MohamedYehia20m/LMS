package com.ebi.lms.Repository;

import com.ebi.lms.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long > {
}
