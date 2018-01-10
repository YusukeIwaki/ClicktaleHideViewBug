package io.github.yusukeiwaki.clicktalehideviewbug.model;

public class Message {
    public final long id;
    public final String body;
    public final User sender;

    public Message(long id, String body, User sender) {
        this.id = id;
        this.body = body;
        this.sender = sender;
    }
}
