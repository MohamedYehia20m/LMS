package com.ebi.lms.Controller;


import com.ebi.lms.Model.BookDto;
import com.ebi.lms.Model.BookSaveDto;
import com.ebi.lms.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {

    final BookService bookService;

    @ResponseBody
    @GetMapping
    List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @ResponseBody
    @GetMapping("/{id}")
    BookDto getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @ResponseBody
    @PostMapping
    BookDto AddBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @ResponseBody
    @PutMapping
    BookSaveDto updateBook(@RequestBody BookSaveDto bookSaveDto) {
        return bookService.updateBook(bookSaveDto);
    }

    @ResponseBody
    @PatchMapping
    BookSaveDto patchBook(@RequestBody BookSaveDto bookSaveDto) {
        return bookService.patchBook(bookSaveDto);
    }
    @ResponseBody
    @DeleteMapping("{id}")
    void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

}
