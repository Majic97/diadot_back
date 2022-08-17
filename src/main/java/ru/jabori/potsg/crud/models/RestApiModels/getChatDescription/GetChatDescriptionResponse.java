package ru.jabori.potsg.crud.models.RestApiModels.getChatDescription;

import java.io.Serializable;
import java.util.List;

public class GetChatDescriptionResponse implements Serializable {

    private int chat_id;

    private String chat_name;

    private String description;

    private List<LinkData> links;

    public GetChatDescriptionResponse(int chat_id, String chat_name, String description, List<LinkData> links) {
        this.chat_id = chat_id;
        this.chat_name = chat_name;
        this.description = description;
        this.links = links;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LinkData> getLinks() {
        return links;
    }

    public void setLinks(List<LinkData> links) {
        this.links = links;
    }
}

