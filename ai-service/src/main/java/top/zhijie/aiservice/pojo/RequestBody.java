package top.zhijie.aiservice.pojo;

public class RequestBody {
    String model;
    Message[] messages;

    public RequestBody(String model, Message[] messages) {
        this.model = model;
        this.messages = messages;
    }
}