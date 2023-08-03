package exercises.section04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Playground {
    public static void main(String[] args) {
//        1. Write a regex that would match the following words: Dark, bark, Lark
//        1. For extra challenge, could you additionally make it match: stark
        String regexp = "([DbL]|st)ark";
        System.out.println("Dark".matches(regexp));
        System.out.println("bark".matches(regexp));
        System.out.println("Lark".matches(regexp));
        System.out.println("stark".matches(regexp));

//        2. Use capture groups to write a regex that could match: Abracadabra or Agracadagra
        regexp = "A([bg])racada\\1ra";
        System.out.println("Abracadabra".matches(regexp));
        System.out.println("Agracadagra".matches(regexp));
        System.out.println("Agracadabra".matches(regexp));

//        3. How can you use parentheses in a regex for grouping but without capturing?
        regexp = "(?:blablabla)";

//        4. Write a regex that tests whether a String is an address and allows you to extract the parts
//        (your choice for address format).
        regexp = """
            (?<line1>.*?)(?:[,;]?[\\n\\s])
            (?<code>\\d\\d-\\d\\d\\d)\\s(?<city>[\\w\\s]*)
        """;
        String address = "os. blablabla 100/34, 00-000 some city";

        Pattern pat = Pattern.compile(regexp, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(address);

        System.out.println(mat.matches());

        System.out.println(mat.group("line1"));
        System.out.println(mat.group("code"));
        System.out.println(mat.group("city"));

//        5. Write a regex that tests whether a String is an email address.
//        1. Note: Doing this in regex is actually notoriously difficult to comply with ALL the ways an
//        email address can be written. However, you can just do the simplest form of email
//        address you can think of, such as: first.last@domain.com
        regexp = "[\\w\\d]+(.[\\w\\d]+)+@([\\w\\d]*.)+\\w+";
        pat = Pattern.compile(regexp, Pattern.DOTALL);
        mat = pat.matcher("email.email3.@blabla.jiji.com");
        System.out.println(mat.matches());
    }
}