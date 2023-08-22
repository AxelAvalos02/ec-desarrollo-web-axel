package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Libro;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.PedidoRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public void run(String... strings) throws Exception {
		Cliente cliente1 = new Cliente("Juan Pérez", "juan@example.com");
		Cliente cliente2 = new Cliente("María García", "maria@example.com");
		Cliente cliente3 = new Cliente("Carlos López", "carlos@example.com");
		Cliente cliente4 = new Cliente("Ana Rodríguez", "ana@example.com");
		Cliente cliente5 = new Cliente("Luis Martínez", "luis@example.com");

		this.clienteRepository.save(cliente1);
		this.clienteRepository.save(cliente2);
		this.clienteRepository.save(cliente3);
		this.clienteRepository.save(cliente4);
		this.clienteRepository.save(cliente5);

		Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Ficción", 25.99);
		Libro libro2 = new Libro("1984", "George Orwell", "Ciencia Ficción", 19.99);
		Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupéry", "Infantil", 12.99);
		Libro libro4 = new Libro("Orgullo y prejuicio", "Jane Austen", "Romance", 17.99);
		Libro libro5 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía", 21.99);

		this.libroRepository.save(libro1);
		this.libroRepository.save(libro2);
		this.libroRepository.save(libro3);
		this.libroRepository.save(libro4);
		this.libroRepository.save(libro5);

		Pedido pedido1 = new Pedido(cliente1, libro1, LocalDate.now());
        Pedido pedido2 = new Pedido(cliente2, libro2, LocalDate.now());
        Pedido pedido3 = new Pedido(cliente3, libro3, LocalDate.now());
        Pedido pedido4 = new Pedido(cliente4, libro4, LocalDate.now());
        Pedido pedido5 = new Pedido(cliente5, libro5, LocalDate.now());

		this.pedidoRepository.save(pedido1);
		this.pedidoRepository.save(pedido2);
		this.pedidoRepository.save(pedido3);
		this.pedidoRepository.save(pedido4);
		this.pedidoRepository.save(pedido5);
	}
}