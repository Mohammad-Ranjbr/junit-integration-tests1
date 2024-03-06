package com.application;

import com.application.entity.Library;
import com.application.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class SpringBootRestServiceApplication implements CommandLineRunner {

	private final LibraryRepository libraryRepository;

	@Autowired
	public SpringBootRestServiceApplication(LibraryRepository libraryRepository){
		this.libraryRepository = libraryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceApplication.class, args);
	}

	@Bean
	public AtomicLong getAtomicLong(){
		return new AtomicLong();
	}

	@Override
	public void run(String... args){
		if(libraryRepository.findById("sia 2024").isPresent()) {
			System.out.println("Fetch Data : ");
			Library library = libraryRepository.findById("sia 2024").get();
			System.out.println("Book Name : " + library.getBook_name());

			System.out.println("\n" + "Insert Data : ");
			Library entity = new Library();
			entity.setAisle(2022);
			entity.setAuthor("Hamed Aziz");
			entity.setBook_name("Ruby");
			entity.setIsbn("R");
			entity.setId("R2022");
			libraryRepository.save(entity);
			System.out.println("See Database!!");

			System.out.println("\n" + "All Records in DB : ");
			List<Library> libraries = libraryRepository.findAll();
			libraries.forEach(l -> System.out.println(l.toString()));

			System.out.println("\n" + "Delete Record from DB : ");
			libraryRepository.deleteById("R2022");

			System.out.println("\n" + "All Records in DB : ");
			List<Library> libraries1 = libraryRepository.findAll();
			libraries1.forEach(l -> System.out.println(l.toString()));

		}
	}

}
