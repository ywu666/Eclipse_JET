package se254.a4.q3;

import java.lang.reflect.*;

public class ExtractorTemplate
{
  protected static String nl;
  public static synchronized ExtractorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExtractorTemplate result = new ExtractorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "public class ";
  protected final String TEXT_2 = " {";
  protected final String TEXT_3 = NL + "   public ";
  protected final String TEXT_4 = " ";
  protected final String TEXT_5 = ";      ";
  protected final String TEXT_6 = NL + "}" + NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    try {
    Class<?> c = argument.getClass();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getField("className").get(argument));
    stringBuffer.append(TEXT_2);
    Class<?> a =(Class<?>) c.getField("a").get(argument);
Class<?> b =(Class<?>) c.getField("b").get(argument);
for (Field fa:a.getFields()){
for (Field fb:b.getFields()){
   
      if (fa.getName().equals(fb.getName()) && fa.getType().equals(fb.getType())){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fa.getType().getSimpleName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fa.getName());
    stringBuffer.append(TEXT_5);
    }
   
}
}
    stringBuffer.append(TEXT_6);
    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e){
 e.printStackTrace();
}
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
