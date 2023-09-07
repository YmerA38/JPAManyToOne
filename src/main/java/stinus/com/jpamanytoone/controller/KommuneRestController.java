package stinus.com.jpamanytoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stinus.com.jpamanytoone.model.Kommune;
import stinus.com.jpamanytoone.repositories.KommuneRepository;
import stinus.com.jpamanytoone.service.APIServiceGetKommune;

import java.util.List;

@RestController
public class KommuneRestController {
    @Autowired
    APIServiceGetKommune apiServiceGetKommune;
    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/kommuner")    // Henter fra url og gemmer i database
    public List<Kommune> kommuner(){
        return apiServiceGetKommune.getKommuner();
    }
    @PostMapping("/postkommune")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune){
        return kommuneRepository.save(kommune);
    }


}
