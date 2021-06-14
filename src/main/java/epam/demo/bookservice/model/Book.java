package epam.demo.bookservice.model;

import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Details of the book")
@Entity
@Table(name = "book")
public class Book {

	@Id
	/*@SequenceGenerator(name = "book_id_sequence",
			sequenceName = "book_id_sequence",
			allocationSize = 1,
			initialValue = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="book_id_sequence")*/
	@Column(name = "id",nullable = false)
	@ApiModelProperty(notes = "Its same as Book Id, must be unique")
	private Integer id;

	@ApiModelProperty(notes = "Name of the Book Title")
	@Column(name = "book_name",nullable = false)
	private String name;

	@ApiModelProperty(notes = "Who wrote / authored the book")
	@Column(name = "author_name",nullable = false)
	private String author;

	@ApiModelProperty(notes = "Genre of the book basically")
	@Column(name = "book_category",nullable = false)
	private String category;

	@ApiModelProperty(notes = "Small Description of the book")
	@Column(name = "book_description",nullable = false)
	private String description;

	@ApiModelProperty(notes = "Retail Price of the Book")
	@Column(name="book_price",nullable = false)
	private Integer price;

	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Book(Integer id, String name, String author, String category, String description, Integer price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	@Override public String toString() {
		return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + ", category='" + category + '\''
				+ ", description='" + description + '\'' + ", price=" + price + '}';
	}
}
