package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Denic
 */
@Getter
@Setter
@ToString
public class Settings implements Serializable {
    private String language;
    private String email;
    private boolean picture;
    private boolean location;
    private String username;
    private String password;
    private Integer delete;
    private String frstKey;
    private String secondKey;

    public Locale getLocaleLanguage() {
        return Locale.forLanguageTag(language);
    }

}
