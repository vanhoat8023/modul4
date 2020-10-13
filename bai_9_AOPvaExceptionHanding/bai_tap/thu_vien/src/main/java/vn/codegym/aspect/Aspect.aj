package vn.codegym.aspect;


import exception.GiveBookBackException;
import exception.RentBookException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    @After("execution(* vn.codegym.controllers.BookController.rentBook(..)),")
    public void writeLog(JoinPoint joinPoint) {
        System.out.println("Hello"+joinPoint.getSignature().getName());
    }
    @ExceptionHandler(RentBookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error");
    }
    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("errorGiveBookBack");
    }
}