package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;


@Controller
public class TimeController {
   @GetMapping("worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {

       // Get current time at local
       Date date = new Date();
// Get timezone by the local
       TimeZone local = TimeZone.getDefault();
// Get timezone by the specified city
       TimeZone locale = TimeZone.getTimeZone(city);
       // Set the data sent to the view
      long locale_time = date.getTime() +
              (locale.getRawOffset() - local.getRawOffset());
// Reset the date by locale_time
      date.setTime(locale_time);
       model.addAttribute("city", city);
       model.addAttribute("date", date);
       return "index";
   }
}
