package epam.demo.bookservice.controller;

import java.util.Collections;
import java.util.List;
import epam.demo.bookservice.model.Book;
import epam.demo.bookservice.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bookService")
public class BookServiceController {

	@Autowired
	BookRepository bookRepository;

//	@RequestMapping("/{bookId}")
//	public List<Book> getBook(@PathVariable("bookId") String bookId){
//		return Collections.singletonList(new Book("Godaan","Premchand","Fiction"
//				,"Good Hindi Novel Literature."));
//	}

	@GetMapping("/books")
	@ApiOperation(value = "fetching data for all Books",
			notes = "This method calls the Table Book in Database and fetch all the entries",
	response = Book.class)
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	@GetMapping("/books/{book_ID}")
	@ApiOperation(value = "fetching data based on Book ID",
			notes = "This method calls the Table Book in Database and fetch all the entries for a "
					+ "perticular Book based on Book ID",
			response = Book.class)
	public List<Book> getBookEntry(@PathVariable ("book_ID") Integer bookID){
		return bookRepository.findAllById(Collections.singleton(bookID));

	}

	@PostMapping("/books")
	@ApiOperation(value = "Creating data entry for a Book",
			notes = "This method calls the Table Book in Database and creates the entry for the book in the "
					+ "table",
			response = Book.class)
	public String saveEntry(@RequestBody final Book book){
		 bookRepository.save(book);
		return ("Entry for the book is saved as :"+book.toString());
	}

	@DeleteMapping("/books/{book_ID}")
	@ApiOperation(value = "Deleting entry of book based on Book ID",
			notes = "This method calls the Table Book in Database and deletes the entry of the book based"
					+ " on the book ID ",
			response = Book.class)
	public String deleteEntry(@PathVariable ("book_ID") Integer bookID){
		bookRepository.deleteById(bookID);
		return ("Entry for the book ID: "+bookID +" has been deleted ");
	}

	@PutMapping("/books/{book_ID}")
	@ApiOperation(value = "Edit Book info",
			notes = "This method calls the Table Book in Database and edits the entry in the database"
					+ " for a Book based on the supplied book ID.",
			response = Book.class)
	public String updateEntry(@ApiParam(value = "Book Id is the entry id in DB",required = true) @PathVariable ("book_ID") String bookId,@RequestBody final Book book){
		if(bookId.equals(book.getId().toString())){
			bookRepository.save(book);
			return "Entry for the book ID "+bookId+" has been updated";
		}
		return "Mismatch in path and Msg Book ID";
	}
}
