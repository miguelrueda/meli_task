package com.example.melitask.service.impl;

import com.example.melitask.dto.*;
import com.example.melitask.helper.ArrayHelper;
import com.example.melitask.helper.MathHelper;
import com.example.melitask.service.LocationService;
import com.example.melitask.service.MeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeliServiceImpl implements MeliService {

    @Autowired
    private LocationService locationService;

    @Override
    public SecretResponse processRequest(SecretRequest request) {

        // Get the position from the incoming distances
        Double[] distances = request.getSatellites().stream()
                .map(PositionRequest::getDistance)
                .toArray(Double[]::new);

        Position location = locationService.getLocation(distances);

        // Get messages from the incoming parts
        List<String[]> collect = request.getSatellites().stream()
                .map(PositionRequest::getMessage)
                .collect(Collectors.toList());
        String[] recoveredMessage = ArrayHelper.mergeArrays(collect);

        return new SecretResponse(location, locationService.getMessage(recoveredMessage));
    }

    @Override
    public SecretResponse processSplitRequest(SplitSecretRequest request, String satelliteName) {
        Double [] distance = {request.getDistance()};
        Position location = locationService.getLocation(distance);

        List<String[]> message = new ArrayList<>();
        message.add(request.getMessage());
        String[] recoveredMessage = ArrayHelper.mergeArrays(message);
        return new SecretResponse(location, locationService.getMessage(recoveredMessage));
    }


}
