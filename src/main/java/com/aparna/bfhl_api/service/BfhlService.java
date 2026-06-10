package com.aparna.bfhl_api.service;

import com.aparna.bfhl_api.dto.request.BfhlRequestDTO;
import com.aparna.bfhl_api.dto.response.BfhlResponseDTO;

public interface BfhlService {

    BfhlResponseDTO processData(BfhlRequestDTO request);

}