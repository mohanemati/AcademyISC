package ir.freeland.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import ir.freeland.springboot.model.Article;

@Controller
@RequestMapping(value = "/article")
public class MainController {

	@GetMapping("/search")
	@ResponseBody
    public String searchArticles(@RequestParam("name") String name, @RequestParam("toDate") String toDate, @RequestParam("fromDate") String fromDate) {
        return "Searching Article " + name ;
    }

	@PostMapping(value = "/print", consumes= {"application/json", "text/plain" })
    @ResponseBody
    public String postController(@RequestBody Article article) {
		 return article.toString(); 
        
    }
    
    @RequestMapping(value = "*")
    @ResponseBody	
    public String allFallback() {
        return "Bad api called";
    }

}