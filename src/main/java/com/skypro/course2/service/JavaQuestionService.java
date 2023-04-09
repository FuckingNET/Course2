package com.skypro.course2.service;

import com.skypro.course2.entity.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    Question question1 = new Question("1", "22");
    private final Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>(Set.of(question1));
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return add(question1);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(random.nextInt(questionList.size()));
    }
}
