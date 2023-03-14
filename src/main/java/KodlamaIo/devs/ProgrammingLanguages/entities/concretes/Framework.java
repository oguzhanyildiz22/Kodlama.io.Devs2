package KodlamaIo.devs.ProgrammingLanguages.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="Frameworks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Framework {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "language_id")
	private ProgrammingLanguage language;
}
