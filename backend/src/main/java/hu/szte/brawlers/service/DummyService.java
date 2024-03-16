package hu.szte.brawlers.service;

import hu.szte.brawlers.model.dto.DummyRequestDto;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
    public DummyRequestDto getDummyDto() {
        return DummyRequestDto.builder()
                .status("success")
                .message("Hello world")
                .build();
    }
}
