package repo.collectorss;

import java.util.Arrays;
import java.util.List;

public class Blog {

    private List<String> comments;
    private String authorName;

    public Blog(){}
    public Blog(String number, String disappointing, String ok) {
        authorName = number;
        comments = Arrays.asList(disappointing,ok);
    }

    public Blog(String number, String disappointing, String ok, String couldBeBetter) {
        authorName = number;
        comments = Arrays.asList(disappointing,ok,couldBeBetter);
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

}
