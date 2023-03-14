package KodlamaIo.devs.ProgrammingLanguages.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.devs.ProgrammingLanguages.business.abstracts.FrameworkService;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.CreateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.requests.framework.UpdateFrameworksRequests;
import KodlamaIo.devs.ProgrammingLanguages.business.responses.GetAllFrameworksResponse;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworkController {

	private FrameworkService frameworkService;

	@Autowired
	public FrameworkController(FrameworkService frameworkService) {
		super();
		this.frameworkService = frameworkService;
	}

	@GetMapping("/getall")
	public List<GetAllFrameworksResponse> getAll() {
		return this.frameworkService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateFrameworksRequests createFrameworksRequests) throws Exception {
		this.frameworkService.add(createFrameworksRequests);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		this.frameworkService.delete(id);
	}

	@PostMapping("/update")
	public void update(UpdateFrameworksRequests frameworksRequests) throws Exception {
		this.frameworkService.update(frameworksRequests);
	}

}
