package jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TitlesRepo extends CrudRepository<Titles, String> {
	@Query("from Titles where price>10")
	List<Titles> getPrice();

	@Query("from Titles where title like %:s%")
	List<Titles> getTitlesMatch(@Param("s") String s);

}
