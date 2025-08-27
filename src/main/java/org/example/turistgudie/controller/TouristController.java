package org.example.turistgudie.controller;

import org.example.turistgudie.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.example.turistgudie.service.TouristService;
import org.example.turistgudie.repository.TouristRepository;
import org.example.turistgudie.model.TouristAttraction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping

    @ResponseBody
    public ResponseEntity<String> attractions() {
        return ResponseEntity.ok("See all attractions");

    }


}



