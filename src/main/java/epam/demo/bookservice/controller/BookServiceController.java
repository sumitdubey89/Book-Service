package epam.demo.bookservice.controller;

import java.util.Collections;
import java.util.List;
import epam.demo.bookservice.model.Book;
import epam.demo.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookServiceController {

	@Autowired
	BookRepository bookRepository;

//	@RequestMapping("/{bookId}")
//	public List<Book> getBook(@PathVariable("bookId") String bookId){
//		return Collections.singletonList(new Book("Godaan","Premchand","Fiction"
//				,"Good Hindi Novel Literature."));
//	}

	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	@GetMapping("/books/{book_ID}")
	public List<Book> getBookEntry(@PathVariable ("book_ID") Integer bookID){
		return bookRepository.findAllById(Collections.singleton(bookID));

	}

	@PostMapping("/books")
	public String saveEntry(@RequestBody final Book book){
		 bookRepository.save(book);
		return ("Entry for the book is saved as :"+book.toString());
	}

	@DeleteMapping("/books/{book_ID}")
	public String deleteEntry(@PathVariable ("book_ID") Integer bookID){
		bookRepository.deleteById(bookID);
		return ("Entry for the book ID: "+bookID +" has been deleted ");
	}

	@PutMapping("/books/{book_ID}")
	public String updateEntry(@PathVariable ("book_ID") String bookId,@RequestBody final Book book){
		if(bookId.equals(book.getId())){
			bookRepository.save(book);
			return "Entry for the book ID "+bookId+" has been updated";
		}
		return "Mismatch in path and Msg Book ID";
	}
}
