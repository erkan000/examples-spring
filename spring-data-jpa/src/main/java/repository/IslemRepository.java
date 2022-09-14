package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Islem;

@Repository
public interface IslemRepository extends JpaRepository<Islem, Integer> {
	
	@EntityGraph(attributePaths = {"odemeBaslik"})
	Optional<Islem> findByName(String name);	

}
