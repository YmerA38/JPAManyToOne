package stinus.com.jpamanytoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import stinus.com.jpamanytoone.model.Region;
import stinus.com.jpamanytoone.service.APIServiceGetRegion;

import java.util.List;

@RestController
public class RegionRestController {
    @Autowired
    APIServiceGetRegion apiServiceGetRegion;

    @GetMapping("/regioner")
    public List<Region> getRegioner(){
        return apiServiceGetRegion.getRegioner();
    }
}
