package se254.a4.q2;

import java.lang.reflect.*;

public class ClassGenerator
{
  protected static String nl;
  public static synchronized ClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ClassGenerator result = new ClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public class ";
  protected final String TEXT_2 = "Implementation implements ";
  protected final String TEXT_3 = "{";
  protected final String TEXT_4 = NL + "    @Override" + NL + "    public ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = " (";
  protected final String TEXT_7 = " arg";
  protected final String TEXT_8 = ") {" + NL + "    //TODO Auto-generated method stub";
  protected final String TEXT_9 = NL + "      return 0;";
  protected final String TEXT_10 = NL + "      return false;";
  protected final String TEXT_11 = NL + "      return null;";
  protected final String TEXT_12 = NL + "    }" + NL + "   ";
  protected final String TEXT_13 = NL + NL + NL + "}" + NL;
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Class<?> c = (Class<?>) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_3);
     for(Method m : c.getMethods()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(m.getReturnType().getSimpleName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(m.getName());
    stringBuffer.append(TEXT_6);
    int i =0;
     for(Class<?> p: m.getParameterTypes()) {
    stringBuffer.append(p.getSimpleName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_5);
    i++;
    }
    stringBuffer.append(TEXT_8);
     if((m.getReturnType().getSimpleName()).equals("int") || (m.getReturnType().getSimpleName()).equals("double")) { 
    stringBuffer.append(TEXT_9);
     } else if((m.getReturnType().getSimpleName()).equals("boolean")){ 
    stringBuffer.append(TEXT_10);
     } else if(! m.getReturnType().isPrimitive()){ 
    stringBuffer.append(TEXT_11);
     } else{ 
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
