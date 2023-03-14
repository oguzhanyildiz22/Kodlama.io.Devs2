package KodlamaIo.devs.ProgrammingLanguages.business.requests.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFrameworksRequests {

	private int id;
	private String name;
}
