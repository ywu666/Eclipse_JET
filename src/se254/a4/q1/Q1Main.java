package se254.a4.q1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * SE254 Assignment 4 Question 1 Main. This class should be implemented to contain the functionality described in the
 * assignment handout. you may implement additional classes if you wish, but this class should be the main program entry
 * point.
 */
public class Q1Main {
	public static void main(String[] args) {
		try{
			System.out.println("Please enter the class name: ");
			String className = readUserInput();
            className = "se254.a4.q1.Counter";
            
			//create a class and a object by the class name
			Class<?> aClass = Class.forName(className);
			Object myObject = aClass.newInstance();
			
			//print
			PrintPublicFields(aClass,className,myObject);
			int numberOfMethods=PrintMethods(aClass,className,myObject);

			//ask user which method they want to invoke
			if (numberOfMethods != 1){
			System.out.println("\nPlease enter the q if you want to quit.");
			System.out.println("Please enter the method name you wnat to execute: ");

			String method = readUserInput();
			while(! method.equals("q")){  //keep asking until user want to quit
				Method invokeMethod = aClass.getMethod(method, null);
				invokeMethod.invoke(myObject);
				PrintPublicFields(aClass,className,myObject);
				PrintMethods(aClass,className,myObject);
				System.out.println("\nPlease enter the method name you wnat to execute: ");
				method = readUserInput();
			}

			System.out.println("Finished!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}




	}


	public static String readUserInput(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}


	public static void PrintPublicFields(Class<?> aClass, String className,Object myObject) throws IllegalArgumentException, IllegalAccessException{
		// get the public fields and print
		Field[] fields = aClass.getFields();
		

		if(fields.length!=0){
			System.out.println("All Public Firlds in " + className + ": ");
			for(Field f: fields){ 
				System.out.println("Filed Name:" +f.getName() + " Value:"+ f.get(myObject));
			}
		}else{
			System.out.println("No public fields in " + className);
		}

	}


	public static int PrintMethods(Class<?> aClass, String className,Object myObject){
		//get the methods without arguments
		Method[] methods = aClass.getDeclaredMethods();
		System.out.println("\nAll Methods without arguements in " + className + ": ");
		//print all the declared methods
		int i=1;
		for(Method method : methods){ // print the declared methods
			if(method.getParameterCount() == 0){
				 if(Modifier.isPublic(method.getModifiers())) { 
				System.out.println("Method" + i +": " + method.getName());
				i++;
				 }
			}	    
		}

		if ( i==1){
			System.out.println("No public methods without arguement in " +className);
		}
		return i;
	}

}


