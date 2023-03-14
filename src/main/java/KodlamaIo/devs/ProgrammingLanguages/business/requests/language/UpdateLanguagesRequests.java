package KodlamaIo.devs.ProgrammingLanguages.business.requests.language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguagesRequests {

	private int id;
	private String name;
}
