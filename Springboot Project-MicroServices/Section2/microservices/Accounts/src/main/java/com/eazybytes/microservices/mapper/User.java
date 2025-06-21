package com.arav.junit.mapper;

import lombok.Data;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@Data
public class User {
    private Optional<Integer> id = Optional.empty();
    private Optional<String> name = Optional.empty();
    private Optional<Profile> profile = Optional.empty();
    private Optional<String> status = Optional.empty();
    private Optional<List<HistoryItem>> history = Optional.empty();

    public Optional<String> getStreet() {
        return profile.flatMap(p -> Optional.ofNullable(p.getAddress()))
                .map(Address::getStreet);
    }

    // Other getters and setters
}
@Data
class Profile {
    private Address address;
    private Contact contact;
    private Preferences preferences;

    // Getters and Setters
}

@Data
class Contact {
    private String email;
    private Phone phone;

    // Getters and Setters
}
@Data
class Address {
    private String street;
    private String city;
    private String country;

    // Getters and Setters
}

@Data
class Phone {
    private String mobile;
    private String home;

    // Getters and Setters
}
@Data
class Preferences {
    private Notifications notifications;
    private String language;

    // Getters and Setters
}
@Data
class Notifications {
    private boolean email;
    private boolean sms;

    // Getters and Setters
}
@Data
class HistoryItem {
    private String date;
    private String event;
    private HistoryDetails details;

    // Getters and Setters
}
@Data
class HistoryDetails {
    private String type;
    private String source;

    // Getters and Setters
}
