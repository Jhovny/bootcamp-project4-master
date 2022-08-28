/**
 * Resumen.
 * Objeto                   : MasterApplication.java
 * Descripción              : Clase para iniciar el microservicio.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Clase para iniciar el microservicio.
 */
@EnableEurekaClient
@SpringBootApplication
public class MasterApplication implements CommandLineRunner {

	/** Declaración de la variable de log */
	private static final Logger log = LoggerFactory.getLogger(MasterApplication.class);

	/** Creación del método main y sus argumentos */
	public static void main(String[] args) {
		SpringApplication.run(MasterApplication.class, args);
	}

	/** Creación del método run y sus argumentos */
	@Override
	public void run(String... args) throws Exception {
		log.info("Init Project");
	}

}
