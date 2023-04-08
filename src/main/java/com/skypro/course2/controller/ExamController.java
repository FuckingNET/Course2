package com.skypro.course2.controller;

import com.skypro.course2.entity.Question;
import com.skypro.course2.exception.QuestionAmountException;
import com.skypro.course2.service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public String handleException(QuestionAmountException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }


    @GetMapping("/{amount}")
    public Collection<Question> getAll(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
