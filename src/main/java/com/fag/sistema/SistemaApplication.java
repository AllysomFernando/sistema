package com.fag.sistema;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.infrastructure.adapters.json.JsonFileReader;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SistemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
    }

    @Bean
    CommandLineRunner initEmpregado(EmpregadoRepository empregadoRepository, JsonFileReader jsonFileReader) {
        return args -> {
            Resource resource = new ClassPathResource("empregado.json");
            try (InputStream inputStream = resource.getInputStream()) {
                List<Empregado> empregados = jsonFileReader.readEmpregadoList(inputStream);
                empregadoRepository.addAllEmpregados(empregados);
                System.out.println("Empregados carregados do arquivo JSON com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            }
        };
    }
    @Bean
    CommandLineRunner initEmpresa(EmpresaRepository empresaRepository, JsonFileReader jsonFileReader) {
        return args -> {
            Resource resource = new ClassPathResource("empresa.json");
            try (InputStream inputStream = resource.getInputStream()) {
                List<Empregador> empresas = jsonFileReader.readEmpresaList(inputStream);
                empresaRepository.addAllEmpresas(empresas);
                System.out.println("Empresas carregadas do arquivo JSON com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            }
        };
    }
}

