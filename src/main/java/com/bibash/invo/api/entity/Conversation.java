package com.bibash.invo.api.user;

import com.nonononoki.alovoa.repo.UserBlockRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany
	private List<User> users;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "conversation")
	private List<Message> messages;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "conversation")
	private List<ConversationCheckedDate> checkedDates;

	private Date date;

	private Date lastUpdated;

	private Date lastOpened;

	public boolean containsUser(User user) {
		return users.contains(user);
	}

	public User getPartner(User user) {
		List<User> usersCopy = new ArrayList<>(users);
		usersCopy.remove(user);
		return usersCopy.get(0);
	}

//	public boolean isBlocked(UserBlockRepository userBlockRepo) {
//
//		UserBlock blockFrom = userBlockRepo.findByUserFromAndUserTo(users.get(0), users.get(1));
//		UserBlock blockTo = userBlockRepo.findByUserFromAndUserTo(users.get(1), users.get(0));
//
//		return blockFrom != null || blockTo != null;
//	}

}