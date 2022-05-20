package projeto.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//essa é uma classe de configuração, instanciada cquando precisa dos seus servicos
//vai disponibiliza o get template para ligar serviços
@Configuration
public class AppConfig {
//o @Bean diferente de serve para configurar chamadas de metodos e nao de classe
	
	@Bean//o RestTemplate para comunicar entre projetos
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
