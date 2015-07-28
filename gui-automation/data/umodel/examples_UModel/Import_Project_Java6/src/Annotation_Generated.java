/* The foolowing java 1.6 common annotations are tested 
 * Generated
 * Resource
 * Resouces
 * PostConstruct
 * PreDestroy
 */

import javax.annotation.*;
import java.lang.*;

 class Annotation_Generated {
	public void developerCode(){
    }

    @Generated(
        value = "ClassNameThatGeneratedThisCode", 
        comments = "This is Tool Generated Code", 
        date = "5 June 2007"
    )
    public void toolGeneratedCode(){
    }
}

class Annotation_Resource{
	
	@Resource(name = "MyQueue", type =java.lang.Object.class  , 
		    shareable = false, 
		    authenticationType = Resource.AuthenticationType.CONTAINER, 
		    description = "A Test Queue"
		)
		private Boolean myQueue;
	
		
}

class Annotation_Resources {
	@Resources({
	    @Resource(name = "MySecondQueue", type = java.lang.Object.class), 
	    @Resource(name = "myTopic", type = java.lang.Object.class),
	}) enum a {SUNDAY, MONDAY};
	
}

class Annotation_PostConstruct{
	public Annotation_PostConstruct(){
    }

    @PostConstruct()
    public void loadDefaults(){

        // Load the Driver Class.
        // Get the Connection and Do other stuffs.

    }
}

class Annotation_PreDestroy{
	public Annotation_PreDestroy(){
    }

    @PreDestroy()
    public void releaseResources(){

        // Close the Connection.
        // Unload the Class Driver from the System

    }
}