package com.prueba.mapper;

import com.prueba.dto.ClaseRequest;
import com.prueba.dto.ClaseResponse;
import com.prueba.dto.HorarioResponse;
import com.prueba.model.Clase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaseMapper {

    public Clase toEntity(ClaseRequest request) {
        Clase clase = new Clase();
        clase.setNombre(request.getNombre());
        clase.setInstructor(request.getInstructor());
        clase.setCapacidad(request.getCapacidad());
        clase.setEntrenadorId(request.getEntrenadorId());
        return clase;
    }

    public ClaseResponse toResponse(Clase clase) {
        List<HorarioResponse> horarios = clase.getHorarios() == null ? List.of() :
                clase.getHorarios().stream()
                        .map(h -> new HorarioResponse(
                                h.getId(),
                                h.getDiaSemana(),
                                h.getHoraInicio(),
                                h.getHoraFin()
                        ))
                        .toList();

        return new ClaseResponse(
                clase.getId(),
                clase.getNombre(),
                clase.getInstructor(),
                clase.getCapacidad(),
                clase.getEntrenadorId(),
                horarios
        );
    }
}
