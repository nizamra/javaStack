package com.sys.axsos.servieces;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sys.axsos.models.Answer;
import com.sys.axsos.models.LoginUser;
import com.sys.axsos.models.Question;
import com.sys.axsos.models.QuestionsTags;
import com.sys.axsos.models.Tag;
import com.sys.axsos.models.User;
import com.sys.axsos.repositries.RepresintingAnswer;
import com.sys.axsos.repositries.RepresintingQuestion;
import com.sys.axsos.repositries.RepresintingQuestionsTags;
import com.sys.axsos.repositries.RepresintingTag;
import com.sys.axsos.repositries.RepresintingUser;

@Service
public class ServicingStackAsd {
	private final RepresintingQuestion RepQ;
	private final RepresintingAnswer RepA;
	private final RepresintingTag RepTg;
	private final RepresintingQuestionsTags RepQnTg;
	@Autowired
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

	public void deletingQuestionById(Long id) {
		RepQ.deleteById(id);
	}

	public User register(User newUser, BindingResult result) {
		if (RepU.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return RepU.save(newUser);
		}
	}

	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = RepU.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}

	public User findSpicificUser(Long uesrId) {
		return RepU.findById(uesrId).get();
	}

}