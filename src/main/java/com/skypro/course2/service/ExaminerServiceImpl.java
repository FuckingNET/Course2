package com.skypro.course2.service;

import com.skypro.course2.entity.Question;
import com.skypro.course2.exception.QuestionAmountException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random;

    private final QuestionService questionService;

    public ExaminerServiceImpl(Random random, QuestionService questionService) {
        this.random = random;
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new QuestionAmountException("");
        }

        if (amount > questionService.getAll().size()) {
            throw new QuestionAmountException("");
        }

        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}
