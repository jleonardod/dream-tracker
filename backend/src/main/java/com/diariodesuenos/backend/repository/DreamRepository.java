package com.diariodesuenos.backend.repository;

import com.diariodesuenos.backend.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DreamRepository extends JpaRepository<Dream, Long>{
	@Query(value = "SELECT k.word, COUNT(dk.keyword_id) as count FROM keywords k JOIN dream_keywords dk ON k.id = dk.keyword_id GROUP BY count DESC", nativeQuery = true)
	List<Object[]> findKeywordFrequency();
	
	@Query("SELECT d.emotion, COUNT(d) FROM Dream d GROUP BY d.emotion")
	List<Object[]> findEmotionFrequency();
}
