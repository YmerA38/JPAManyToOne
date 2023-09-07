package stinus.com.jpamanytoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import stinus.com.jpamanytoone.model.Region;
import stinus.com.jpamanytoone.repositories.RegionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class APIServiceGetRegionIMPL implements APIServiceGetRegion{

    private RestTemplate restTemplate;

    public APIServiceGetRegionIMPL(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    String regionURL = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner)
    { regioner.forEach(reg -> regionRepository.save(reg)); }

    @Override
    public List<Region> getRegioner() {
        List<Region> lst = new ArrayList<>();
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>(){ });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;
    }
}
