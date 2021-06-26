package com.sys.axsos.servieces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sys.axsos.repositries.RepresintingQuestion;
import com.sys.axsos.repositries.RepresintingQuestionsTags;
import com.sys.axsos.repositries.RepresintingUser;
import com.sys.axsos.models.Answer;
import com.sys.axsos.models.Question;
import com.sys.axsos.models.QuestionsTags;
import com.sys.axsos.models.Tag;
import com.sys.axsos.models.User;
import com.sys.axsos.repositries.RepresintingAnswer;
import com.sys.axsos.repositries.RepresintingTag;

@Service
public class ServicingStackAsd {
	private final RepresintingQuestion RepQ;
	private final RepresintingAnswer RepA;
	private final RepresintingTag RepTg;
	private final RepresintingQuestionsTags RepQnTg;
	private final RepresintingUser RepU;

	public ServicingStackAsd(RepresintingQuestion RQ, RepresintingAnswer RA, RepresintingTag RTg,
			RepresintingQuestionsTags RQnTg, RepresintingUser RU) {
		RepQ = RQ;
		RepA = RA;
		RepTg = RTg;
		RepQnTg = RQnTg;
		RepU = RU;
	}

	public Question createQuestion(Question potato) {
		return RepQ.save(potato);
	}

	public Answer createMostafa(Answer potato) {
		return RepA.save(potato);
	}

	public Tag createTag(Tag potato) {
		return RepTg.save(potato);
	}

	public QuestionsTags createQuestionsTags(QuestionsTags potato) {
		return RepQnTg.save(potato);
	}

	public User createMostafa(User potato) {
		return RepU.save(potato);
	}
	
	
	public List<Question> findQuestions() {
		return RepQ.findAll();
	}
	public List<Answer> findAnswers() {
		return RepA.findAll();
	}
	public List<Tag> findTags() {
		return RepTg.findAll();
	}
	public List<User> findUsers() {
		return RepU.findAll();
	}
	
	public Tag findTagNamed(String mazda) {
		return RepTg.findBySubjectIgnoreCase(mazda);
	}
	
	public Question findById(Long id) {
		return RepQ.findById(id).get();
	}
	
    
	
}