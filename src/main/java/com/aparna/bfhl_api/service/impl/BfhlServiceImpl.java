package com.aparna.bfhl_api.service.impl;

import com.aparna.bfhl_api.dto.request.BfhlRequestDTO;
import com.aparna.bfhl_api.dto.response.BfhlResponseDTO;
import com.aparna.bfhl_api.exception.ApiException;
import com.aparna.bfhl_api.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public BfhlResponseDTO processData(BfhlRequestDTO request) {

        if (request == null || request.getData() == null) {
            throw new ApiException("Input data cannot be null");
        }

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder alphabetChars = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                long number = Long.parseLong(item);

                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                // Store alphabets for concat_string logic
                alphabetChars.append(item.toUpperCase());

            } else {

                specialCharacters.add(item);
            }
        }

        String concatString =
                generateAlternatingCaps(
                        alphabetChars.reverse().toString()
                );

        return BfhlResponseDTO.builder()
                .is_success(true)
                .user_id("aparna_nair_30122004")
                .email("aparna.nair.btech2023@sitpune.edu.in")
                .roll_number("23070122040")
                .odd_numbers(oddNumbers)
                .even_numbers(evenNumbers)
                .alphabets(alphabets)
                .special_characters(specialCharacters)
                .sum(String.valueOf(sum))
                .concat_string(concatString)
                .build();
    }

    private String generateAlternatingCaps(String input) {

        StringBuilder result = new StringBuilder();

        boolean upper = true;

        for (char ch : input.toCharArray()) {

            if (upper) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }

            upper = !upper;
        }

        return result.toString();
    }
}