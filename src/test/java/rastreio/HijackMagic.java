package rastreio;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class HijackMagic {
  private static final String URL = Magic.URL;

  private HijackMagic() {}

  public static void changeUrl(String newUrl) throws IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = Magic.class.getField("URL");
    field.setAccessible(true);

    Field fieldModifiers = Field.class.getDeclaredField("modifiers");
    fieldModifiers.setAccessible(true);
    fieldModifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, newUrl);
  }

  public static void revertUrl() throws IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = Magic.class.getField("URL");
    field.setAccessible(true);

    Field fieldModifiers = Field.class.getDeclaredField("modifiers");
    fieldModifiers.setAccessible(true);
    fieldModifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, URL);
  }
}
