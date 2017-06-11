package com.quangnguyen.stackoverflowclient.data.repository.remote;

import com.quangnguyen.stackoverflowclient.data.api.ApiServiceGenerator;
import com.quangnguyen.stackoverflowclient.data.model.Question;
import com.quangnguyen.stackoverflowclient.data.repository.QuestionDataSource;
import com.quangnguyen.stackoverflowclient.data.api.QuestionResponse;
import com.quangnguyen.stackoverflowclient.data.api.QuestionService;
import io.reactivex.Flowable;
import java.util.List;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public class QuestionRemoteDataSource implements QuestionDataSource {

  private QuestionService questionService;

  public QuestionRemoteDataSource() {
    questionService = ApiServiceGenerator.getInstance().createService(QuestionService.class);
  }

  @Override
  public Flowable<List<Question>> loadQuestions(boolean forceRemote) {
    return questionService.loadQuestionsByTag("android").map(QuestionResponse::getQuestions);
  }

  @Override
  public void addQuestion(Question question) {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");
  }

  @Override
  public void clearData() {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");
  }
}
