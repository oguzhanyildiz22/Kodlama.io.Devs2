package KodlamaIo.devs.ProgrammingLanguages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.CreateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.language.UpdateLanguagesRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllLanguagesResponse;
import KodlamaIo.devs.ProgrammingLanguages.core.utilities.mapper.ModelMapperService;
import KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;
	private ModelMapperService modelMapperService;

	

	@Override
	public void add(CreateLanguagesRequests createLanguagesRequests){
		ProgrammingLanguage language = this.modelMapperService.forRequest()
				.map(createLanguagesRequests,ProgrammingLanguage.class );
		
		this.languageRepository.save(language);
	}
 
	@Override
	public void delete(int id) {

		this.languageRepository.deleteById(id);
		;

	}

	@Override
	public void update(UpdateLanguagesRequests updateLanguagesRequests){

		ProgrammingLanguage language = this.modelMapperService.forRequest()
				.map(updateLanguagesRequests, ProgrammingLanguage.class);
		this.languageRepository.save(language);

	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();

		List<GetAllLanguagesResponse> languagesResponses = languages.stream()
				.map(language->this.modelMapperService.forResponse()
						.map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());

		return languagesResponses;
	}

}
