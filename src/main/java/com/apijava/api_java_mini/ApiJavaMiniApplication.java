package com.apijava.api_java_mini;

import com.apijava.api_java_mini.entity.Pessoa;
import com.apijava.api_java_mini.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;



@SpringBootApplication
public class ApiJavaMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJavaMiniApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PessoaRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				List<Pessoa> pessoas = List.of(
						new Pessoa( "Ana Beatriz Silva", "123.456.789-00", "28", "ana.silva@example.com", "(11) 98888-0001"),
						new Pessoa( "Bruno Costa Lima", "321.654.987-01", "35", "bruno.lima@example.com", "(21) 98765-4321"),
						new Pessoa( "Carla Souza Mendes", "234.567.890-12", "42", "carla.mendes@example.com", "(31) 99876-5432"),
						new Pessoa( "Daniela Rocha", "456.789.012-23", "19", "daniela.rocha@example.com", "(41) 91234-5678"),
						new Pessoa("Eduardo Pereira", "567.890.123-34", "50", "eduardo.pereira@example.com", "(51) 92345-6789"),
						new Pessoa( "Fernanda Dias", "678.901.234-45", "26", "fernanda.dias@example.com", "(61) 93456-7890"),
						new Pessoa( "Gabriel Monteiro", "789.012.345-56", "31", "gabriel.monteiro@example.com", "(71) 94567-8901"),
						new Pessoa( "Helena Martins", "890.123.456-67", "29", "helena.martins@example.com", "(81) 95678-9012"),
						new Pessoa("Igor Albuquerque", "901.234.567-78", "40", "igor.albuquerque@example.com", "(91) 96789-0123"),
						new Pessoa("Juliana Nogueira", "012.345.678-89", "33", "juliana.nogueira@example.com", "(31) 97890-1234"),
						new Pessoa( "Kleber Araújo", "111.222.333-44", "45", "kleber.araujo@example.com", "(11) 98901-2345"),
						new Pessoa( "Larissa Carvalho", "222.333.444-55", "27", "larissa.carvalho@example.com", "(21) 99012-3456"),
						new Pessoa("Marcelo Duarte", "333.444.555-66", "38", "marcelo.duarte@example.com", "(51) 90123-4567"),
						new Pessoa("Natália Freitas", "444.555.666-77", "30", "natalia.freitas@example.com", "(61) 91234-5678"),
						new Pessoa("Otávio Sales", "555.666.777-88", "36", "otavio.sales@example.com", "(71) 92345-6789"),
						new Pessoa("Patrícia Lima", "666.777.888-99", "22", "patricia.lima@example.com", "(81) 93456-7890"),
						new Pessoa("Rafael Gomes", "777.888.999-00", "44", "rafael.gomes@example.com", "(91) 94567-8901"),
						new Pessoa("Sabrina Tavares", "888.999.000-11", "24", "sabrina.tavares@example.com", "(31) 95678-9012"),
						new Pessoa("Thiago Costa", "999.000.111-22", "39", "thiago.costa@example.com", "(41) 96789-0123"),
						new Pessoa("Vanessa Ribeiro", "000.111.222-33", "32", "vanessa.ribeiro@example.com", "(51) 97890-1234")
				);
				repository.saveAll(pessoas);
			}
		};
	}
}



