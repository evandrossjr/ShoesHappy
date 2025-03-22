package com.sh.sistema.dto;

import com.sh.sistema.entities.enuns.Modality;

public record ClientDTO(Integer matricula, String name, String adress, Modality modality) {
}
