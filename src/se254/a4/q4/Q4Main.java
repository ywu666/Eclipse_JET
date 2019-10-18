package se254.a4.q4;

/**
 * SE254 Assignment 4 Question 4 Main. Running this should generate and print out the classes as discussed in the
 * assignment handout.
 */
public class Q4Main {

	public static void main(String[] args) {

		TemplateArgument extractorArg = new TemplateArgument();
		extractorArg.a = A.class;
		extractorArg.b = B.class;
		extractorArg.className = "P";

		ExtractorTemplate template = new ExtractorTemplate();
		String result = template.generate(extractorArg);
		System.out.println(result);

	}

}
