package hu.szte.brawlers.controller;

import hu.szte.brawlers.model.dto.DummyRequestDto;
import hu.szte.brawlers.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// TODO: global CORS configot beallitani 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dummy")
public class DummyController {

    private final DummyService dummyService;

    @Autowired
    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("/test")
    public ResponseEntity<DummyRequestDto> getTestEndpoint() {
        DummyRequestDto dto = this.dummyService.getDummyDto();
        return ResponseEntity.ok(dto);
    }
}
