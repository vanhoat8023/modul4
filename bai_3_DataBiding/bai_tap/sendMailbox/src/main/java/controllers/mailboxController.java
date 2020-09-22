package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
