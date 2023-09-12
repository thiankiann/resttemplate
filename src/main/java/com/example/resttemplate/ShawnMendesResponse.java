package com.example.resttemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

public record ShawnMendesResponse(Integer resultCount, List<ShawnMendesResult> results) {
}
