package org.example.turistgudie.controller;

import org.example.turistgudie.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.example.turistgudie.service.TouristService;
import org.example.turistgudie.repository.TouristRepository;
import org.example.turistgudie.model.TouristAttraction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> attractions() {
        List<TouristAttraction> listToReturn = service.getAll();
        return new ResponseEntity<>(listToReturn, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> findAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction savedAttraction = service.addAttraction(attraction);
        return new ResponseEntity<>(savedAttraction, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction (@RequestBody TouristAttraction attraction) {
        TouristAttraction deleted = service.deleteAttraction(attraction, true);
        return new ResponseEntity<>(deleted, HttpStatus.OK);

    }

@PostMapping("/update/{name}")
    public ResponseEntity<TouristAttraction> updatedAttraction(@PathVariable String name,
                                                               @RequestBody TouristAttraction updatedAttraction){
        TouristAttraction attraction = service.updateAttraction(name, updatedAttraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
}
}



