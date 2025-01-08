package fitness.amanagement.system;

public class Feedback {
    private int feedbackId;
    private String content;
    private Client client;
    private Program program;

    public Feedback(int feedbackId, String content, Client client, Program program) {
        this.feedbackId = feedbackId;
        this.content = content;
        this.client = client;
        this.program = program;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}