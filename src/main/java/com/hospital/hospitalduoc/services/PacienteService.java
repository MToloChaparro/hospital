package com.hospital.hospitalduoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalduoc.model.Paciente;
import com.hospital.hospitalduoc.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public List<Paciente> mostrarPacientes(){
        return pacienteRepository.findAll();
    }


    public Paciente buscarId(Long id){
        return pacienteRepository.findById(id).get();
    }

    public Paciente crearPaciente(Paciente unPaciente){
        return pacienteRepository.save(unPaciente);

    }

    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);

    }


}
