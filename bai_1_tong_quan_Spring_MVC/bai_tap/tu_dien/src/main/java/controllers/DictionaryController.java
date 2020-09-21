package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping(value = "")
    public String show(){
        return "viewDictionary";
    }
    @PostMapping(value = "/dictionary")
    public ModelAndView getHelloPage(@RequestParam("keyword") String key){
        if (key == ""){
            key = "null";
        }
        return new ModelAndView("viewDictionary", "result", search(key));
    }
    private String search(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "xin chao");
        map.put("home", "nha");
        map.put("hoat", "dep trai");
        String result = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (key.equals(entry.getKey())) {
                result = entry.getValue();
                break;
            } else result = "fail!";
        }
        return result;
    }
}
