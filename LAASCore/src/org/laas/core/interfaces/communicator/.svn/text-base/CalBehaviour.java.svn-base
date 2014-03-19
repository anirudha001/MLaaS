package org.laas.core.interfaces.communicator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)

public @interface CalBehaviour {

	public enum BehaviourTypes {
		BLOCKING,
		NON_BLOCKING
	}
	
	public BehaviourTypes behaviourTypes() default BehaviourTypes.BLOCKING;
	
}
