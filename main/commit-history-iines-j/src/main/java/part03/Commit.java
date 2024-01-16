package part03;

public class Commit {
    private String username;
    private String id;
    private String parent;
    private String text;

    public Commit(String username, String id, String parent, String text) {
        this.username = username;
        this.id = id;
        this.parent = parent;
        this.text = text;
    }

    public String getUsername() {
        return this.username;
    }

    public String getId() {
        return this.id;
    }

    public String getParent() {
        return this.parent;
    }

    public String getText() {
        return this.text;
    }

}
