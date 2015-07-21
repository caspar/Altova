import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TaskEx {
  public static void main(String[] args) {
    showDoitAnno();
  }
  static void showDoitAnno() {
    try {
      Method m = TaskEx.class.getMethod("doit");
      Annotation[] annos = m.getAnnotationsByType(Schedule.class);
      I("getAnnotationsByType");
      for (Annotation an : annos) {
        P("annos: " + an);
      }
      I("getAnnotation");
      Annotation a = m.getAnnotation(Schedule.class);
      P("anno: " + a);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Schedule(dayOfMonth="Last")
  @Schedule(dayOfWeek="Fri", hour="23")
  public void doit() {

  }
  static void P(Object o) { System.out.println(o); }
  static void I(Object o) { System.out.println("I: " + o); }
  static void W(Object o) { System.out.println("I: " + o); }
  static void E(Object o) { System.out.println("I: " + o); }
}