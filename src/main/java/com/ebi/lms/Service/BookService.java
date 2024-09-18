package com.ebi.lms.Service;

import com.ebi.lms.Entity.BookEntity;
import com.ebi.lms.Model.BookDto;
import com.ebi.lms.Model.BookSaveDto;
import com.ebi.lms.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@RequestMapping
public class BookService {

    final BookRepository bookRepository;
    final ModelMapper modelMapper;

    public List<BookDto> getAllBooks() {
       List<BookEntity>  bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(bookEntity -> modelMapper.map(bookEntity , BookDto.class)).collect(Collectors.toList());
    }

    public BookDto getBook(Long id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        return modelMapper.map(bookEntity,BookDto.class);
    }

    public BookDto addBook( BookDto bookDto) {
        if (bookDto.getAuthor().isEmpty() || bookDto.getTitle().isEmpty() || bookDto.getPublicationYear().isEmpty() ) {
            System.out.println("missing data to register!");
        }

        BookEntity savedEntity = bookRepository.save(modelMapper.map(bookDto,BookEntity.class));
        return modelMapper.map(savedEntity ,BookDto.class);
    }

    public BookSaveDto updateBook(BookSaveDto bookSaveDto) {
        BookEntity savedEntity = bookRepository.save(modelMapper.map(bookSaveDto,BookEntity.class));

        return modelMapper.map(savedEntity,BookSaveDto.class);
    }

    public BookSaveDto patchBook(BookSaveDto bookSaveDto) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookSaveDto.getId());
        //BookEntity savedEntity = null;
        if(optionalBookEntity.isPresent())
        {
            if( bookSaveDto.getAuthor() != null && !bookSaveDto.getAuthor().isEmpty() ) {
                optionalBookEntity.get().setAuthor(bookSaveDto.getAuthor());
            }

            if( bookSaveDto.getTitle() != null && !bookSaveDto.getTitle().isEmpty() ) {
                optionalBookEntity.get().setTitle(bookSaveDto.getTitle());
            }

            if( bookSaveDto.getPublicationYear() != null && !bookSaveDto.getPublicationYear().isEmpty() ) {
                optionalBookEntity.get().setPublicationYear(bookSaveDto.getPublicationYear());
            }
        }

        BookEntity savedEntity = bookRepository.save(optionalBookEntity.get());

        return modelMapper.map(savedEntity,BookSaveDto.class);
    }

    public void deleteBook(Long id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        bookRepository.delete(bookEntity.get());
    }
}
