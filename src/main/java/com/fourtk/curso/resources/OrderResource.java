package com.fourtk.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourtk.curso.entities.Order;
import com.fourtk.curso.services.OrderService;

//classe responsavel pelo CRUD (Acesso direto ao BD)

@RestController //Classe de recursos do controle do banco
@RequestMapping(value = "/orders") //nome do recurso
public class OrderResource {
	
	@Autowired
	private OrderService orderService; //Injetando uma instancia do userService
	
	@GetMapping //Usado para definir que é uma chamada GET
	public ResponseEntity<List<Order>> findAll(){//metodo que busca todos os usuarios por id
		
		List<Order> list = orderService.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")//declara que o metodo vai passar um id
	public ResponseEntity<Order> findById(@PathVariable Long id){ //@Pathvariable define a passagem dessa variavel id (VITAL)
		
		Order obj = orderService.findById(id); //recebe o metodo findbyId do OrderService
		return ResponseEntity.ok().body(obj);
	}

}
