package cn.jinronga.rabbitmq04.controller;

import cn.jinronga.rabbitmq04.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/confirm")
public class ProducerController {

 @Autowired
 private RabbitTemplate rabbitTemplate;

 //发消息
 @GetMapping("/sendMessage/{message}")
 public void sendMessage(@PathVariable String message){
  CorrelationData correlationData = new CorrelationData("1");
  rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME
          ,ConfirmConfig.CONFIRM_routing_key
          ,message,correlationData);
  log.info("发送消息内容：{}",message);
 }
}

