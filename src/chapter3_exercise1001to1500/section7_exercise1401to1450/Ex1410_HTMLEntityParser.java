package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.

The special characters and their entities for HTML are:

Quotation Mark: the entity is &quot; and symbol character is ".
Single Quote Mark: the entity is &apos; and symbol character is '.
Ampersand: the entity is &amp; and symbol character is &.
Greater Than Sign: the entity is &gt; and symbol character is >.
Less Than Sign: the entity is &lt; and symbol character is <.
Slash: the entity is &frasl; and symbol character is /.
Given the input text string to the HTML parser, you have to implement the entity parser.

Return the text after replacing the entities by the special characters.

Constraints:
1 <= text.length <= 10^5
The string may contain any possible characters out of all the 256 ASCII characters.

*/
public class Ex1410_HTMLEntityParser {
    //28ms 击败88.69的用户
    public String entityParser(String text) {
        String s=text.replace("&quot;","\"").replace("&apos;","'").replace("&gt;",">")
                .replace("&lt;","<").replace("&frasl;","/").replace("&amp;","&");
        return s;

    }
}
