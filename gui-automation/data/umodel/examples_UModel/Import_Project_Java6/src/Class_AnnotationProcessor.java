/* the following java 1.6 type is tested
 * class AbstractProcessor
 */

import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;

@SupportedAnnotationTypes(value= {"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_6)

public class Class_AnnotationProcessor extends AbstractProcessor  {
	@Override
    public boolean process(
        Set<? extends TypeElement> annotations, RoundEnvironment roundEnv){
        
        for (TypeElement element : annotations){
            System.out.println(element.getQualifiedName());
        }
        return true;
    }   
   
}

