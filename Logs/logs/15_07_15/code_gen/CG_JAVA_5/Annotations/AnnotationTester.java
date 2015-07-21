package Annotations;
public class AnnotationTester{
	public @InProgress @GroupTODO( severity=GroupTODO.Severity.CRITICAL, item="Figure out the amount of interest per month", assignedTo="Brett McLaughlin", dateAssigned="04-26-2004" ) void calculateInterest(float amount, float rate){
		// TODO add implementation
	}

}

