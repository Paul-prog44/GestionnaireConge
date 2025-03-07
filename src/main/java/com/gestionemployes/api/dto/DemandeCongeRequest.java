package com.gestionemployes.api.dto;

import lombok.Data;

@Data
public class DemandeCongeRequest {
    private Long employeeId;
    private Long periodeId;
}
