package by.example.infrastructure.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
public @interface Singleton {
}
