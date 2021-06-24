import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private List<App.Post> postList;

    User(String login, String password){
        this.login = login;
        this.password = password;
    }

    User(){
        postList = new ArrayList<>();
    }
    public List<App.Post> getPostList() {
        return postList;
    }

    public void addPost(App.Post post) {
        this.postList.add(post);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
