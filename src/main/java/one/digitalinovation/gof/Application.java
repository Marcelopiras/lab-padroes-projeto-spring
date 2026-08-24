package one.digitalinovation.gof;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
     * Projeto Spring Boot gerado via Spring Inicializr.
     * Os seguintes módulos foram selecionados:
     * - Spring Data JPA
     * - Spring Web
     * - H2 Database
     * - OpenFeign
     *
     * @author Marcelo Abrantes
     */
    @EnableFeignClients
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class,args);
        }
}
