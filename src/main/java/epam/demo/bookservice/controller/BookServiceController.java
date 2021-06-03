package epam.demo.bookservice.controller;

import java.util.Collections;
import java.util.List;
import epam.demo.bookservice.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
public class BookServiceController {

	@RequestMapping("/{bookId}")
	public List<Book> getBook(@PathVariable("bookId") String bookId){
		return Collections.singletonList(new Book("Godaan","Premchand","Fiction"
				,"Good Hindi Novel Literature."));
	}

}
