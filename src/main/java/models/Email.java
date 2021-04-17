package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Email implements Serializable {

    private String date;
    private boolean sent;

    public Email(String date, boolean sent) {
        this.date = date;
        this.sent = sent;
    }
}
