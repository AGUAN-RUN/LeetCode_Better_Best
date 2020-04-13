package chapter3_exercise1001to1500.section7_exercise1401to1450;

public class Ex1410_HTMLEntityParser {
    //28ms
    public String entityParser(String text) {
        String s=text.replace("&quot;","\"").replace("&apos;","'").replace("&gt;",">")
                .replace("&lt;","<").replace("&frasl;","/").replace("&amp;","&");
        return s;

    }
}
