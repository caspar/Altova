package Annotations;
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
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



public class AnnotationTester {

  @InProgress
  @GroupTODO(
    severity=GroupTODO.Severity.CRITICAL,
    item="Figure out the amount of interest per month",
    assignedTo="Brett McLaughlin",
    dateAssigned="04-26-2004"
  )
  public void calculateInterest(float amount, float rate) {
    // Need to finish this method later
  }
}
