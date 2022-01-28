package io.techstack.valueObjects;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class User {
    private String firstName;
    private String lastName;
    private String email;
}
