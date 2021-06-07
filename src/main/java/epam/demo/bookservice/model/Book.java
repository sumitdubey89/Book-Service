package epam.demo.bookservice.model;

import javax.persistence.*;


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
	private Integer id;

	@Column(name = "book_name",nullable = false)
	private String name;

	@Column(name = "author_name",nullable = false)
	private String author;

	@Column(name = "book_category",nullable = false)
	private String category;

	@Column(name = "book_description",nullable = false)
	private String description;

	public Book() {
	}

	public Book(Integer id, String name, String author, String category, String description) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.description = description;
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

	@Override public String toString() {
		return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + ", Category='" + category + '\''
				+ ", Description='" + description + '\'' + '}';
	}
}
