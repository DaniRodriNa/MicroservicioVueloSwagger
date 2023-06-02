package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VuelosService;

import io.swagger.annotations.ApiOperation;
/**
 * Clase controlador: VuelosController
 * @author Daniel Rodriguez
 * @version 1.0.0 02-06-2023
 */
@RestController
public class VuelosController {
	@Autowired
	VuelosService service;
	@ApiOperation(value="Devulve una lista de vuelos")
	@GetMapping(value="vuelos",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelos() {
		return service.listaTotalVuelos();
	}
	@ApiOperation(value="Devulve una lista de vuelos que tengan las plazas equivalentes o mas a las que se piden")
	@GetMapping(value="vuelos/{plazas}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelos(@PathVariable("plazas") int plazas) {
		return service.listaVuelos(plazas);
	}
	@ApiOperation(value="Devulve un vuelo especifico que tenga plazas disponibles a las que yo le pido")
	@GetMapping(value="vuelo/{idVuelo}/{plazas}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo elegirVuelo(@PathVariable("idVuelo") int idVuelo,@PathVariable("plazas") int plazas) {
		return service.elegirVuelo(idVuelo, plazas);
	}
	@ApiOperation(value="Actualiza un vuelo a partir de su identificador y el numero de plazas")
	@PutMapping(value="vuelo/{idVuelo}/{plazas}")
	public void actualizarVuelo(@PathVariable("idVuelo") int idVuelo,@PathVariable("plazas") int plazas) {
		service.actualizarVuelo(idVuelo, plazas);
	}
}
