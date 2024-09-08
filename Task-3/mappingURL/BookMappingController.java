package ir.freeland.springboot;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@RestController
@Controller
@RequestMapping(value = "/book")
public class BookMappingController {
    
    
    @GetMapping(value = "/books")
    @ResponseBody
    public String getAllbooks() {
        return "you call api books list";
    }
    
    @PostMapping(value = "/books")
    @ResponseBody
    public String addBooks() {
        return "you call api post book";
    }
    
    @PutMapping(value = "/books/{id}")
    @ResponseBody
    public String updateBooks(@PathVariable final long id) {
        return "you call api update book with id: " + id;
    }
    
    @DeleteMapping(value= "/books/{id}")
    @ResponseBody
    public String deleteBookId(@PathVariable final long id) {
        return "you call api delete book: " + id;
    }
 
    @GetMapping(value = "/books/{id}")
    @ResponseBody
    public String searchBookId(@PathVariable final long id) {
        return "you call api get book with id: " + id;
    }
    
   
}
