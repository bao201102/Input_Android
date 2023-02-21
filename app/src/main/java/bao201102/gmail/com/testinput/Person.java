package bao201102.gmail.com.testinput;

import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Serializable {
    protected String name;
    protected String phone;
    protected Boolean gender;
    protected String level;
    protected String age;
    protected Boolean sport;
    protected String music;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Boolean getSport() {
        return sport;
    }
    public void setSport(Boolean sport) {
        this.sport = sport;
    }
    public String getMusic() {
        return music;
    }
    public void setMusic(String music) {
        this.music = music;
    }

    public Person(String name, String phone, Boolean gender, String level, String age, Boolean sport, String music) {
        super();
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.level = level;
        this.age = age;
        this.sport = sport;
        this.music = music;
    }
}
