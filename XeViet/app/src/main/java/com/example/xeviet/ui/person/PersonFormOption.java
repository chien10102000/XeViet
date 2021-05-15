package com.example.xeviet.ui.person;

public class PersonFormOption {
    int IconPerson;
    String TenPersonOption;

    public PersonFormOption() {
    }

    public PersonFormOption(int iconPerson, String tenPersonOption) {
        IconPerson = iconPerson;
        TenPersonOption = tenPersonOption;
    }

    public int getIconPerson() {
        return IconPerson;
    }

    public void setIconPerson(int iconPerson) {
        IconPerson = iconPerson;
    }

    public String getTenPersonOption() {
        return TenPersonOption;
    }

    public void setTenPersonOption(String tenPersonOption) {
        TenPersonOption = tenPersonOption;
    }
}
