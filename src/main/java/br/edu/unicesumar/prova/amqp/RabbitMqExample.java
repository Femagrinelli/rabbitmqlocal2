package br.edu.unicesumar.prova.amqp;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.unicesumar.prova.domain.Aluno;
import br.edu.unicesumar.prova.domain.objectDTO;

@Component
public class RabbitMqExample {

	@Autowired
	private AmqpAdmin amqpAdmin;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	/*
	@PostConstruct
	public void adiciona() {
		/*
		//FANOUT
		Queue filaFanOut = new Queue("fila-felipe-magrinelli-fanout", true, false, false);

		FanoutExchange exchangeFanoutTeste = new FanoutExchange("exchange-teste", true, false);
	
		Binding bindingTesteFanOut = new Binding(filaFanOut.getName(), DestinationType.QUEUE, exchangeFanoutTeste.getName(), "teste", null);
		this.amqpAdmin.declareQueue(filaFanOut);
		this.amqpAdmin.declareExchange(exchangeFanoutTeste);
		this.amqpAdmin.declareBinding(bindingTesteFanOut);
		
		
		
		//DIRECT
		Queue filaTesteDirect = new Queue("fila-felipe-magrinelli-direct", true, false, false);
		DirectExchange directExchangeTeste = new DirectExchange("direct-exchange-teste",true,false);
		Binding bindingTesteDirect = new Binding(filaTesteDirect.getName(), DestinationType.QUEUE, directExchangeTeste.getName(), "felipe.magrinelli", null);
		//this.rabbitTemplate.convertAndSend(directExchangeTeste.getName(), "felipe.magrinelli", "message");//essa vai apenas quem tem a routing key -> direct == felipe.magrinelli
		this.amqpAdmin.declareQueue(filaTesteDirect);
		this.amqpAdmin.declareExchange(directExchangeTeste);
		this.amqpAdmin.declareBinding(bindingTesteDirect);
		
		
		//TOPIC
		Queue filaLogInfo = new Queue("felipe-log", true, false, false);
		Queue filaLogWarn = new Queue("felipe-warn", true, false, false);
		Queue filaLogError = new Queue("felipe-error", true, false, false);
		
		TopicExchange topicExchangeTeste = new TopicExchange("topic-exchange-teste", true, false);
		
		Binding bindingFilaLogInfo = new Binding(filaLogInfo.getName(), DestinationType.QUEUE, topicExchangeTeste.getName(),"#.info.#",null);
		Binding bindingFilaLogWarn = new Binding(filaLogWarn.getName(), DestinationType.QUEUE, topicExchangeTeste.getName(),"#.warn",null);
		Binding bindingFilaLogError = new Binding(filaLogError.getName(), DestinationType.QUEUE, topicExchangeTeste.getName(),"#.error",null);
		this.amqpAdmin.declareQueue(filaLogInfo);
		this.amqpAdmin.declareQueue(filaLogWarn);
		this.amqpAdmin.declareQueue(filaLogError);
		
		this.amqpAdmin.declareExchange(topicExchangeTeste);
		this.amqpAdmin.declareBinding(bindingFilaLogError);
		this.amqpAdmin.declareBinding(bindingFilaLogWarn);
		this.amqpAdmin.declareBinding(bindingFilaLogInfo);
		
		
		// * -> uma palavra qualquer
		// # -> nenhuma ou varias palavra qualquer
		// . -> delimitador
		 }
		*/
		/*1 DE JUNHO EXERCICIO DE GRUPOS*/

		/*@PostConstruct
		private void postConstruct() {
			Queue fila = new Queue(objectDTO.myUser, true, false, false);
			DirectExchange exchangeDirect = new DirectExchange("directExchange", true, false);
			Binding binding = new Binding(objectDTO.myUser, DestinationType.QUEUE, exchangeDirect.getName(), objectDTO.myUser, null);
					
			this.amqpAdmin.declareExchange(exchangeDirect);
			this.amqpAdmin.declareQueue(fila);
			this.amqpAdmin.declareBinding(binding);
		}*/
	
	/*@RabbitListener(queues = "fila-teste", ackMode = "AUTO")
	private void consumerFilaTeste(Aluno aluno) {
		System.out.println(aluno);
	}*/
	
	
}
