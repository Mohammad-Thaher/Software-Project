package fitness.amanagement.system;

public class Content {
    private int contentId;
    private String title;
    private String type; 
    private String contentText; 
    private Instructor instructor;
    private String status;
    public Content(int contentId, String title, String type, String contentText, Instructor instructor) {
        this.contentId = contentId;
        this.title = title;
        this.type = type;
        this.contentText = contentText;
        this.instructor = instructor;
        this.status = "Pending";
    }

    public void approveContent() {
        System.out.println("Content approved: " + title);
    }

    public void rejectContent() {
        System.out.println("Content rejected: " + title);
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}