package br.edu.unicesumar.prova.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.prova.domain.objectDTO;

@RestController
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private AmqpAdmin amqpAdmin;
	
	@PostMapping("/direct/{username}")
	public ResponseEntity<Void> sendDirectMessage(@PathVariable(name="username") String username, @RequestBody objectDTO msg){
		
		this.rabbitTemplate.convertAndSend("msg-direct", username, msg);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/exchange/{group}")
	public ResponseEntity<Void> createExchange(@PathVariable(name="group") String grupo){
		FanoutExchange exchangeFanout = new FanoutExchange("group-" + grupo, true, false);
		this.amqpAdmin.declareExchange(exchangeFanout);
		
		Binding bindingFanOut = new Binding(objectDTO.myUser, DestinationType.QUEUE, exchangeFanout.getName(), "", null);
		this.amqpAdmin.declareBinding(bindingFanOut);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/binding/{group}/{user}")
	public ResponseEntity<Void> createBinding(@PathVariable(name="group") String nomeGrupo, @PathVariable(name="user") String user){
		Binding bindingFanOut = new Binding(user, DestinationType.QUEUE, "group-"+nomeGrupo, "", null);
		this.amqpAdmin.declareBinding(bindingFanOut);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/fanout/{group}")
	public ResponseEntity<Void> createMessage(@PathVariable(name="group") String group, @RequestBody objectDTO message){
		this.rabbitTemplate.convertAndSend("group-"+group, "", message);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{group}/{assunto}")
	public ResponseEntity<Void> createExchangeBindingExchange(@PathVariable(name="group") String group, @PathVariable(name="assunto") String assunto){
		
		
		
		return ResponseEntity.ok().build();
	}
	
	@RabbitListener(queues = objectDTO.myUser, ackMode="AUTO")
    private void listenerMessage(objectDTO msg) {
		System.out.println(msg.getUser() + ": " + msg.getMessage());
    	
    }

}
