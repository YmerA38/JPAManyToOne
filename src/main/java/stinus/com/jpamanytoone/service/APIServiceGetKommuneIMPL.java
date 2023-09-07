package stinus.com.jpamanytoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import stinus.com.jpamanytoone.model.Kommune;
import stinus.com.jpamanytoone.model.Region;
import stinus.com.jpamanytoone.repositories.KommuneRepository;
import stinus.com.jpamanytoone.repositories.RegionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class APIServiceGetKommuneIMPL implements APIServiceGetKommune {

    private RestTemplate restTemplate;

    public APIServiceGetKommuneIMPL(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    String regionURL = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuner(List<Kommune> kommuner)
    { kommuner.forEach(kom -> kommuneRepository.save(kom)); }




    @Override
    public List<Kommune> getKommuner() {
        List<Kommune> lst = new ArrayList<>();
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(regionURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>(){ });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuner(kommuner);
        return kommuner;
    }
}
