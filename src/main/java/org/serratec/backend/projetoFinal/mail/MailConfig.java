package org.serratec.backend.projetoFinal.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("grupo6ff@gmail.com");
		message.setTo(para);
		message.setSubject("Projeto Final API");
		message.setText("Testando" + texto + "1 2.3");
		javaMailSender.send(message);
	}

}
