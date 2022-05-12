package com.example.melitask.service;

import com.example.melitask.dto.Position;
import com.example.melitask.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class LocationServiceTests {

    private LocationService locationService;

    @BeforeEach
    public void setUp() {
        locationService = new LocationServiceImpl();
    }

    @Test
    public void getMessageTest_Success() {
        String [] message = {"este", "es", "un", "mensaje", "secreto"};
        String expected = "este es un mensaje secreto";

        String result = locationService.getMessage(message);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void getLocationTest_Success() {
        Double [] distances = {100.0, 115.5, 142.7};
        Position expected = new Position(-271.95374664237374, -87.11875559604366);

        Position result = locationService.getLocation(distances);

        assertThat(result.getX()).isEqualTo(expected.getX());
        assertThat(result.getY()).isEqualTo(expected.getY());
    }
}
