package org.playtime.builder;



class User {
    enum Gender {
        FEMALE,
        MALE,
    }


    private String name;
    private String lastName;
    private int age;
    private String address;
    private String occupation;
    private Gender gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", occupation='" + occupation + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class UserBuilder {
    private User user;
    public UserBuilder() {
        user = new User();
    }

    public UserBuilder addName(String s){
        user.setName(s);
        return this;
    }

    public UserBuilder addLastName(String s){
        user.setLastName(s);
        return this;
    }

    public UserBuilder addAge(int s){
        user.setAge(s);
        return this;
    }

    public UserBuilder addAddress(String s){
        user.setAddress(s);
        return this;
    }

    public UserBuilder addOccupation(String s){
        user.setOccupation(s);
        return this;
    }

    public UserBuilder addGender(User.Gender s){
        user.setGender(s);
        return this;
    }

    public User build() {
        return user;
    }

}

public class Main {

    public static void main(String[] args) {

        var s = new UserBuilder()
                .addName("meep")
                .addLastName("mooper")
                .addAge(23)
                .addAddress("Meadow of Sorrows")
                .addOccupation("Mail delivery guy")
                .addGender(User.Gender.FEMALE)
                .build();

        System.out.println(s.toString());

    }

}
