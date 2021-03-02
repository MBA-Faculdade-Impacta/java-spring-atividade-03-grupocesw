package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int productId,
			@RequestParam(name="codTipoPagamento") int typePaymentId) {

		String productionDescription = "";
		String conditionDescription = "";
		
	    double value = 0;
	    
	    switch (productId) {
		    case 1:
		    	productionDescription = "Camisa";
		    	value = 70.00;
		    	break;
		    case 2:
		    	productionDescription = "Shorts";
		    	value = 57.50;
		    	break;
		    case 3:
		    	productionDescription = "Meia";
		    	value = 9.99;
		    	break;
		    case 4:
		    	productionDescription = "Toca";
		    	value = 35.00;
		    	break;
		    case 5:
		    	productionDescription = "Luvas";
		    	value = 19.50;
		    	break;
	    }
	    
	    switch (typePaymentId) {
		    case 1:
		    	conditionDescription = "à vista no dinheiro com 10% de desconto";
		    	value -= (value * 0.10);
		    	break;
		    case 2:
		    	conditionDescription = "à vista no cartão de crédito  com 5% de desconto";
		    	value -= (value * 0.05);
		    	break;
		    case 3:
		    	conditionDescription = "em duas parcelas sem nenhum desconto";
		    	break;
		    case 4:
		    	conditionDescription = "em três vezes com 10% de juros";
		    	value += (value * 0.10);
		    	break;
	    }
	    
	    return ResponseEntity.ok(
	    		String.format("%s sendo pago %s custará %.2f reais",
	    				productionDescription, conditionDescription, value)
	    		);
	}
	
}
