package com.application;

import com.application.entity.Library;
import com.application.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			Library library = libraryRepository.findById("sia 2024").get();
			System.out.println("Book Name : " + library.getBook_name());
		}
	}

}
