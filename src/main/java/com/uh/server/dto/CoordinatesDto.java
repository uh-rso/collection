package com.uh.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinatesDto {
    private double latitude;
    private double longitude;
}
