package com.example.melitask.service;

import com.example.melitask.dto.SecretRequest;
import com.example.melitask.dto.SecretResponse;
import com.example.melitask.dto.SplitSecretRequest;

public interface MeliService {

    SecretResponse processRequest(SecretRequest request);

    SecretResponse processSplitRequest(SplitSecretRequest request, String satelliteName);

}
