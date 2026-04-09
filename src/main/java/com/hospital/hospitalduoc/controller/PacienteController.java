package com.hospital.hospitalduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalduoc.model.Paciente;
import com.hospital.hospitalduoc.services.PacienteService;

@RestController
@RequestMapping("api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    //devuelve en consulta rest la información de la tabla Paciente
    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> pacientes = pacienteService.mostrarPacientes();
        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);

    }



    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente unPaciente){
        Paciente pacienteNuevo = pacienteService.crearPaciente(unPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNuevo);
    }

}
