package se254.a4.q4;

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
  protected final String TEXT_5 = ";     ";
  protected final String TEXT_6 = NL + "}" + NL + "" + NL + "" + NL + "public class A extends ";
  protected final String TEXT_7 = "  {";
  protected final String TEXT_8 = NL + "      private ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "}" + NL + "" + NL + "" + NL + "public class B extends ";
  protected final String TEXT_11 = NL + NL + "}" + NL;
  protected final String TEXT_12 = NL + NL + NL + NL;
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String common ="";
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
    common= fa.getType().getSimpleName()+ fa.getName();
    }
}
}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(c.getField("className").get(argument));
    stringBuffer.append(TEXT_7);
    for (Field fa:a.getFields()){
  if(! common.equals(fa.getType()+fa.getName())){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fa.getType().getSimpleName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fa.getName());
    stringBuffer.append(TEXT_9);
    }
}
    stringBuffer.append(TEXT_10);
    stringBuffer.append(c.getField("className").get(argument));
    stringBuffer.append(TEXT_7);
    for (Field fa:a.getFields()){
  if(! common.equals(fa.getType()+fa.getName())){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fa.getType().getSimpleName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fa.getName());
    stringBuffer.append(TEXT_9);
    }
}
    stringBuffer.append(TEXT_11);
    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e){
 e.printStackTrace();
}
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
