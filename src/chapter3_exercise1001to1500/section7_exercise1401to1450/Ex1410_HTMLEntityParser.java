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

/*
「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。

HTML 里这些特殊字符和它们对应的字符实体包括：

双引号：字符实体为 &quot; ，对应的字符是 " 。
单引号：字符实体为 &apos; ，对应的字符是 ' 。
与符号：字符实体为 &amp; ，对应对的字符是 & 。
大于号：字符实体为 &gt; ，对应的字符是 > 。
小于号：字符实体为 &lt; ，对应的字符是 < 。
斜线号：字符实体为 &frasl; ，对应的字符是 / 。
给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。

 

示例 1：

输入：text = "&amp; is an HTML entity but &ambassador; is not."
输出："& is an HTML entity but &ambassador; is not."
解释：解析器把字符实体 &amp; 用 & 替换
示例 2：

输入：text = "and I quote: &quot;...&quot;"
输出："and I quote: \"...\""
示例 3：

输入：text = "Stay home! Practice on Leetcode :)"
输出："Stay home! Practice on Leetcode :)"
示例 4：

输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
输出："x > y && x < y is always false"
示例 5：

输入：text = "leetcode.com&frasl;problemset&frasl;all"
输出："leetcode.com/problemset/all"
 

提示：

1 <= text.length <= 10^5
字符串可能包含 256 个ASCII 字符中的任意字符。


* */
public class Ex1410_HTMLEntityParser {
    //28ms 击败88.69的用户
    public String entityParser(String text) {
        String s=text.replace("&quot;","\"").replace("&apos;","'").replace("&gt;",">")
                .replace("&lt;","<").replace("&frasl;","/").replace("&amp;","&");
        return s;

    }
}
