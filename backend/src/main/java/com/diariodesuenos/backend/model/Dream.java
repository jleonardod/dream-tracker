package com.diariodesuenos.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dreams")
public class Dream {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String text;
	
	@Column(name = "recorded_at", nullable = false)
	private LocalDate recordedAt;
	
	private String emotion;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "dream_keywords",
			joinColumns = @JoinColumn(name = "dream_id"),
			inverseJoinColumns = @JoinColumn(name = "keyword_id")
	)
	private Set<Keyword> keywords;
}
