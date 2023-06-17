package org.playtime.builder;



class User {
    private String name;
    private String lastName;
    private int age;
    private String address;
    private String occupation;
    private String gender;

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

    public void setGender(String gender) {
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

    public UserBuilder addGender(String s){
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
                .addName("lee")
                .addLastName("Fowler")
                .addAge(20)
                .addAddress("Simrishamnsvägen")
                .addOccupation("Engineer")
                .addGender("Male")
                .build();

        System.out.println(s.toString());

    }

}
