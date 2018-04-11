package bootstrap;
import java.util.ArrayList;

import com.compassco.Compass3DTwo;

public class Registry {
  public static ArrayList<Class<?>> _classes = new ArrayList<Class<?>>();
  static{
      _classes.add(Compass3DTwo.class);
	}
}