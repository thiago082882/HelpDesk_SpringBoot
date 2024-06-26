package com.thiago.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thiago.helpdesk.domain.Tecnico;
import com.thiago.helpdesk.domain.dtos.TecnicoDTO;
import com.thiago.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	
	
	@Autowired
	private TecnicoService service;
	

	@GetMapping(value="/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable("id") Integer id) {
	    Tecnico obj = this.service.findById(id);
	    return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}


}
