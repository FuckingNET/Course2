package com.skypro.course2.service;

import com.skypro.course2.entity.Question;
import com.skypro.course2.exception.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new QuestionAmountException("количество не может быть отрицательным");
        }

        if (amount > questionService.getAll().size()) {
            throw new QuestionAmountException("список содержит меньше вопросов, чем запрашивается ");
        }

        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}
