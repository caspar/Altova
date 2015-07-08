
package oldAnnotations/* Annotations */;
/*
License for Java 1.5 'Tiger': A Developer's Notebook
     (O'Reilly) example package

Java 1.5 'Tiger': A Developer's Notebook (O'Reilly) 
by Brett McLaughlin and David Flanagan.
ISBN: 0-596-00738-8

You can use the examples and the source code any way you want, but
please include a reference to where it comes from if you use it in
your own products or services. Also note that this software is
provided by the author "as is", with no expressed or implied warranties. 
In no event shall the author be liable for any direct or indirect
damages arising in any way out of the use of this software.
*/
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;

//import java.util.Date;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//import oldAnnotations.GroupTODO.Severity;

public class ReflectionTester {

  public ReflectionTester() {
  }

  public void testAnnotationPresent(PrintStream out) throws IOException {
    Class c = Super.class;
    boolean inProgress = c.isAnnotationPresent(InProgress.class);
    if (inProgress) {
      out.println("Super is In Progress");
    } else {
      out.println("Super is not In Progress");
    }
  }

  public void testInheritedAnnotation(PrintStream out) throws IOException {
    Class c = Sub.class;
    boolean inProgress = c.isAnnotationPresent(InProgress.class);
    if (inProgress) {
      out.println("Sub is In Progress");
    } else {
      out.println("Sub is not In Progress");
    }
  }

  public void testGetAnnotation(PrintStream out) 
    throws IOException, NoSuchMethodException {

    Class c = AnnotationTester.class;
    AnnotatedElement element = c.getMethod("calculateInterest", 
                                  float.class, float.class);

    GroupTODO groupTodo = element.getAnnotation(GroupTODO.class);
    String assignedTo = groupTodo.assignedTo();

    out.println("TODO Item on Annotation Tester is assigned to: '" + 
        assignedTo + "'");
  }

  public void printAnnotations(AnnotatedElement e, PrintStream out)
    throws IOException {

    out.printf("Printing annotations for '%s'%n%n", e.toString());

    Annotation[] annotations = e.getAnnotations();
    for (Annotation a : annotations) {
      out.printf("    * Annotation '%s' found%n", 
        a.annotationType().getName());
    }
  }

  public static void main(String[] args) {
    try {
      ReflectionTester tester = new ReflectionTester();

      tester.testAnnotationPresent(System.out);
      tester.testInheritedAnnotation(System.out);

      tester.testGetAnnotation(System.out);

      Class c = AnnotationTester.class;
      AnnotatedElement element = c.getMethod("calculateInterest", 
                                    float.class, float.class);      
      tester.printAnnotations(element, System.out);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}

class Sub extends Super {

  public void print(PrintStream out) throws IOException {
    out.println("Sub printing...");
  }
}

@InProgress class Super {

  public void print(PrintStream out) throws IOException {
    out.println("Super printing...");
  }
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface GroupTODO {

  public enum Severity { CRITICAL, IMPORTANT, TRIVIAL, DOCUMENTATION };

  Severity severity() default Severity.IMPORTANT;
  String item();
  String assignedTo();
  String dateAssigned();
}

/**
 * Marker annotation to indicate that a method or class
 *   is still in progress.
 */
@Documented @Retention(RetentionPolicy.RUNTIME) @Inherited /* @Documented */
/* @Inherited */
/* @Retention(RetentionPolicy.RUNTIME) */
@interface InProgress { }

