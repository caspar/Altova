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


public class DeprecatedTester extends DeprecatedClass {

  public void doSomething() {
    // Overrides a deprecated method
  }
}

class DeprecatedClass {

  /**
   * This method has now been deprecated in favor of doSomethingElse()
   * @deprecated Use doSomethingElse() instead
   */

  @Deprecated public void doSomething() {
    // Really... do something...
  }

  public void doSomethingElse() {
    // Do something else (and presumably better)
  }
}
