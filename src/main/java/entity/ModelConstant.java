package entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ModelConstant {
    static final String VALUE_CANNOT_BE_NULL = "Value cannot be null";
    static final String INVALID_PASSWORD_MESSAGE = "Invalid password";
}
