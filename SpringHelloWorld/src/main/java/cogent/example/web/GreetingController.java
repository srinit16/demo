package cogent.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

	@GetMapping
	public String annn(@RequestParam(name="name", required=false, defaultValue="World") String pname, Model model) {
		model.addAttribute("person", new Person("GET " + pname));
		return "abc";
	}
	@PostMapping
	public String ann(@ModelAttribute Person person) {
		person.setName("Mr. " + person.getName());
		return "abc";
	}

	@GetMapping(path = "/sayHello", produces = "application/json")
	public Person hello() {
		// JPARespository findbyID(..) a Person
		Person p = new Person("Nitin");
		return p;
	}

}