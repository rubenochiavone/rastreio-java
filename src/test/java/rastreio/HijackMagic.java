package rastreio;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class HijackMagic {
  private static final String URL = Magic.URL;
  private static final String URL2 = Magic.URL2;

  private HijackMagic() {}

  public static void changeUrl(String newUrl) throws IllegalAccessException, NoSuchFieldException, SecurityException {
    hijackMagic("URL", newUrl);
  }

  public static void revertUrl() throws IllegalAccessException, NoSuchFieldException, SecurityException {
    hijackMagic("URL", URL);
  }

  public static void changeUrl2(String newUrl) throws IllegalAccessException, NoSuchFieldException, SecurityException {
    hijackMagic("URL2", newUrl);
  }

  public static void revertUrl2() throws IllegalAccessException, NoSuchFieldException, SecurityException {
    hijackMagic("URL2", URL2);
  }

  private static void hijackMagic(String fieldName, String fieldValue) throws IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = Magic.class.getField(fieldName);
    field.setAccessible(true);

    Field fieldModifiers = Field.class.getDeclaredField("modifiers");
    fieldModifiers.setAccessible(true);
    fieldModifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, fieldValue);
  }
}
