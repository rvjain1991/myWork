package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Location;

@Repository
public interface LocationDao extends JpaRepository<Location, Integer>{

}
