package KodlamaIo.devs.ProgrammingLanguages.webApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.FrameworkService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.CreateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.UpdateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllFrameworksResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/frameworks")
@AllArgsConstructor
public class FrameworkController {

	private FrameworkService frameworkService;

	@GetMapping()
	public List<GetAllFrameworksResponse> getAll() {
		return this.frameworkService.getAll();
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateFrameworksRequests createFrameworksRequests) {
		this.frameworkService.add(createFrameworksRequests);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.frameworkService.delete(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateFrameworksRequests frameworksRequests) {
		this.frameworkService.update(frameworksRequests);
	}

}
