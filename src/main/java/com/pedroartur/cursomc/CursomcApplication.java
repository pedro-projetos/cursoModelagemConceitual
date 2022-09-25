package com.pedroartur.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedroartur.cursomc.domain.Categoria;
import com.pedroartur.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Categoria categoria1 = new Categoria(0,"Informática");
	Categoria categoria2 = new Categoria(0, "Escritório");
	
	categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
	}

}
