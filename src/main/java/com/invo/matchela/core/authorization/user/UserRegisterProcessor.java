package com.invo.matchela.core.authorization.user;

import com.invo.matchela.api.entity.cards.UserFavCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class UserRegisterProcessor {

    public List<UserFavCategory> processRegisterFav(Set<UserFavCategory> userFavCategories) {
       userFavCategories.forEach(u -> u.setCurrentFav(Boolean.TRUE));
       return new ArrayList<>(userFavCategories);
    }
}
