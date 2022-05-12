package com.example.melitask.service.impl;

import com.example.melitask.dto.*;
import com.example.melitask.helper.MathHelper;
import com.example.melitask.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private List<Satellite> currentSatellites = List.of(
            new Satellite("Kenobi", new Position(4.0, 4.0)),
            new Satellite("Skywalker", new Position(9.0, 7.0)),
            new Satellite("Sato", new Position(9.0, 1.0)));

    /**
     * Method that retrieves the location from the emisor using the Trilateration
     * (https://en.wikipedia.org/wiki/True-range_multilateration)
     *
     * @param distances Distance to emisor, received by each satellite
     * @return Coordinates X and Y of the satellite represented by {@link Position}
     */
    public Position getLocation(Double [] distances) {
        // for each element of the array of distances, calculate the distance to the satellite
        // We have 3 positions known and 3 distances

        Satellite PA = currentSatellites.get(0);
        Satellite PB = currentSatellites.get(1);
        Satellite PC = currentSatellites.get(2);

        Double d1;
        Double d2;
        Double d3;

        if (distances.length == 1) {
            d1 = distances[0];
            d2 = distances[0];
            d3 = distances[0];
        } else {
            d1 = distances[0];
            d2 = distances[1];
            d3 = distances[2];
        }

        double pBpADistance = Math.pow(Math.pow(PB.getPosition().getX() - PA.getPosition().getX(), 2) +
                Math.pow(PB.getPosition().getY() - PA.getPosition().getY(), 2), 0.5);
        Position ex = new Position((PB.getPosition().getX() - PA.getPosition().getX()) / pBpADistance,
                (PB.getPosition().getY() - PA.getPosition().getY()) / pBpADistance);
        Position aux = new Position(PC.getPosition().getX() - PA.getPosition().getX(),
                PC.getPosition().getY() - PA.getPosition().getY());

        double xMagnitude = ex.getX() * aux.getX() + ex.getY() * aux.getY();
        Position aux2 = new Position((PC.getPosition().getX() - PA.getPosition().getX() - xMagnitude * ex.getX()),
                (PC.getPosition().getY() - PA.getPosition().getY() - xMagnitude * ex.getY()));
        Position ey = new Position(aux2.getX() / MathHelper.getPositionNorm(aux2),
                aux2.getY() / MathHelper.getPositionNorm(aux2));
        double yMagnitude = ey.getX() * aux.getX() + ey.getY() * aux.getY();

        double x = (Math.pow(d1, 2) - Math.pow(d2, 2) + Math.pow(pBpADistance, 2)) /
                (2 * pBpADistance);
        double y = (Math.pow(d1, 2) - Math.pow(d3, 2) + Math.pow(yMagnitude, 2) + Math.pow(yMagnitude, 2))
                / ((2 * yMagnitude) - (xMagnitude * x / yMagnitude));

        double finalX = PA.getPosition().getX() + x * ex.getX() + y * ey.getX();
        double finalY = PA.getPosition().getY() + x * ex.getY() + y * ey.getY();

        return new Position(finalX, finalY);
    }

    /**
     * Method that recreates the message originally sent by the emisor
     *
     * @param parts The message as is received by each satellite
     * @return The message as it is generated by the emisor
     */
    public String getMessage(String [] parts) {
        StringBuilder builder = new StringBuilder();

        for (String string : parts) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(string);
        }
        return builder.toString();
    }

}