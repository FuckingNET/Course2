package com.skypro.course2.service;

import com.skypro.course2.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
