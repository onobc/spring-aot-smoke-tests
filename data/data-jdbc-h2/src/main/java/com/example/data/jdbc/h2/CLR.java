package com.example.data.jdbc.h2;

import java.util.List;
import java.util.Set;

import com.example.data.jdbc.h2.model.Author;
import com.example.data.jdbc.h2.model.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class CLR implements CommandLineRunner {

	private final AuthorRepository authorRepository;

	CLR(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public void run(String... args) {
		insertAuthors();
		listAllAuthors();
		findById();
		findByPartialName();
		queryFindByName();
		deleteAll();
	}

	private void deleteAll() {
		this.authorRepository.deleteAll();
		long count = this.authorRepository.count();
		System.out.printf("deleteAll(): count = %d%n", count);
	}

	private void queryFindByName() {
		Author author1 = this.authorRepository.queryFindByName("Josh Long").orElse(null);
		Author author2 = this.authorRepository.queryFindByName("Martin Kleppmann").orElse(null);

		System.out.printf("queryFindByName(): author1 = %s%n", author1);
		System.out.printf("queryFindByName(): author2 = %s%n", author2);
	}

	private void findByPartialName() {
		Author author1 = this.authorRepository.findByNameContainingIgnoreCase("sh lo").orElse(null);
		Author author2 = this.authorRepository.findByNameContainingIgnoreCase("in kl").orElse(null);

		System.out.printf("findByPartialName(): author1 = %s%n", author1);
		System.out.printf("findByPartialName(): author2 = %s%n", author2);
	}

	private void findById() {
		Author author1 = this.authorRepository.findById(1L).orElse(null);
		Author author2 = this.authorRepository.findById(2L).orElse(null);

		System.out.printf("findById(): author1 = %s%n", author1);
		System.out.printf("findById(): author2 = %s%n", author2);
	}

	private void listAllAuthors() {
		List<Author> authors = this.authorRepository.findAll();
		for (Author author : authors) {
			System.out.printf("listAllAuthors(): author = %s%n", author);
			for (Book book : author.getBooks()) {
				System.out.printf("\t%s%n", book);
			}
		}
	}

	private void insertAuthors() {
		Author author1 = this.authorRepository.save(new Author(null, "Josh Long",
				Set.of(new Book(null, "Reactive Spring"), new Book(null, "Cloud Native Java"))));
		Author author2 = this.authorRepository.save(
				new Author(null, "Martin Kleppmann", Set.of(new Book(null, "Designing Data Intensive Applications"))));

		System.out.printf("insertAuthors(): author1 = %s%n", author1);
		System.out.printf("insertAuthors(): author2 = %s%n", author2);
	}

}
