package stinus.com.jpamanytoone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stinus.com.jpamanytoone.model.Kommune;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

    //List<Kommune> getKommuner();
}
