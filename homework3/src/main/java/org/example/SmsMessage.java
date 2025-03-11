package org.example;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class SmsMessage {
    private String phone;
    private String message;


    @Override
    public String toString() {
        return " SMS to: " + phone + "\n Message " + message;
    }
}
