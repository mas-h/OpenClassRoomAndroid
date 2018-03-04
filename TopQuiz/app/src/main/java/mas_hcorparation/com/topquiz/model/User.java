package mas_hcorparation.com.topquiz.model;

/**
 * Created by mash on 04/03/18.
 */

public class User {

    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}