package KodlamaIo.devs.ProgrammingLanguages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.FrameworkService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.CreateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.UpdateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllFrameworksResponse;
import KodlamaIo.devs.ProgrammingLanguages.core.utilities.mapper.ModelMapperService;
import KodlamaIo.devs.ProgrammingLanguages.dataAccess.abstracts.FrameworkRepository;
import KodlamaIo.devs.ProgrammingLanguages.entities.concretes.Framework;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService {

	FrameworkRepository frameworkRepository;
	ModelMapperService modelMapperService;

	@Override
	public void add(CreateFrameworksRequests createFrameworksRequests) {

		Framework framework = this.modelMapperService.forRequest().map(createFrameworksRequests, Framework.class);
		this.frameworkRepository.save(framework);

	}

	@Override
	public void delete(@PathVariable int id) {

		this.frameworkRepository.deleteById(id);

	}

	@Override
	public void update(UpdateFrameworksRequests frameworksRequests) {

		Framework framework = this.modelMapperService.forRequest().map(frameworksRequests, Framework.class);
		this.frameworkRepository.save(framework);

	}

	@Override
	public List<GetAllFrameworksResponse> getAll() {

		List<Framework> frameworks = frameworkRepository.findAll();

		List<GetAllFrameworksResponse> frameworksResponses = frameworks.stream()
				.map(framework -> this.modelMapperService.forResponse().map(framework, GetAllFrameworksResponse.class))
				.collect(Collectors.toList());

		return frameworksResponses;
	}

}
