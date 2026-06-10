package com.aparna.bfhl_api.controller;

import com.aparna.bfhl_api.dto.request.BfhlRequestDTO;
import com.aparna.bfhl_api.dto.response.BfhlResponseDTO;
import com.aparna.bfhl_api.service.BfhlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
@RequiredArgsConstructor
public class BfhlController {

    private final BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<BfhlResponseDTO> processData(
            @RequestBody BfhlRequestDTO request) {

        return ResponseEntity.ok(
                bfhlService.processData(request)
        );
    }

    @GetMapping
    public String healthCheck() {
        return "BFHL API is running";
    }
}