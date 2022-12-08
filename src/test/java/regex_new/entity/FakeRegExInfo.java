package regex_new.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FakeRegExInfo {

  public static @NonNull RegExInfo createRegEx(@NonNull Long id, @NonNull String regularExpression,
      @Nullable String description) {
    return new RegExInfo(id, regularExpression, description);
  }
}
