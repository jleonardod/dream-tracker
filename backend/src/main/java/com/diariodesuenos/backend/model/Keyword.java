package com.diariodesuenos.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "keywords")
public class Keyword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String word;
	
	@ManyToMany(mappedBy = "keywords")
	private Set<Dream> Dreams;
}
