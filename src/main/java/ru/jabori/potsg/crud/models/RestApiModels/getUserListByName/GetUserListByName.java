package ru.jabori.potsg.crud.models.RestApiModels.getUserListByName;

import java.io.Serializable;

public class GetUserListByName implements Serializable {

    private int user_id;

    private String characters_combination;

    public GetUserListByName(int user_id, String characters_combination) {
        this.user_id = user_id;
        this.characters_combination = characters_combination;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCharacters_combination() {
        return characters_combination;
    }

    public void setCharacters_combination(String characters_combination) {
        this.characters_combination = characters_combination;
    }
}
