package controllers;

import com.sun.scenario.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MailboxService;
import service.MailboxServiceImpl;

@Controller
@RequestMapping("/mailbox")
public class mailboxController {

    MailboxService mailboxService = new MailboxServiceImpl();

    @GetMapping
    public String getStudentPage(Model model) {
        model.addAttribute("mailbox", mailboxService.findAll());
        return "mailbox";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("settings") Settings settings, Model model){
        model.addAttribute("languages",settings.getLanguages());
        model.addAttribute("pageSize",settings.getPageSize());
        model.addAttribute("spamsFilter",settings.getSpamsFilter());
        model.addAttribute("signature",settings.getSignature());
        return "editMailbox";
    }
}
