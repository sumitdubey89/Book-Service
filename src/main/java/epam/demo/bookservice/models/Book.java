package epam.demo.bookservice.models;

public class Book {

	private String name;
	private String author;
	private String Category;
	private String Description;

	public Book(String name, String author, String category, String description) {
		this.name = name;
		this.author = author;
		Category = category;
		Description = description;
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
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
