package ua.org.oa.sergey_kost.lectures.lecture2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParcer {

    public static String parcer(String str) {
        String result;

        Pattern h3 = Pattern.compile("(^#{3}\\b)(.+)");
        Matcher matcherH3 = h3.matcher(str);
        result = matcherH3.replaceAll("<h3>$2</h3>");

        Pattern h2 = Pattern.compile("(^#{2}\\b)(.+)");
        Matcher matcherH2 = h2.matcher(result);
        result = matcherH2.replaceAll("<h2>$2</h2>");

        Pattern h1 = Pattern.compile("(^#{1}\\b)(.+)");
        Matcher matcherh1 = h1.matcher(result);
        result = matcherh1.replaceAll("<h1>$2</h1>");

        Pattern strong = Pattern.compile("(\\*{2})(\\w+)(\\*{2})");
        Matcher matcherStrong = strong.matcher(result);
        result = matcherStrong.replaceAll("<strong>$2</strong>");

        Pattern em = Pattern.compile("(\\*{1})(\\w+)(\\*{1})");
        Matcher matcherEm = em.matcher(result);
        result = matcherEm.replaceAll("<em>$2</em>");

        Pattern link = Pattern.compile("(\\[)([A-z\\s]+)(\\])(\\()(https:\\/\\/www\\.\\w+\\.\\w{2,3})(\\))");
        Matcher matcherLink = link.matcher(result);
        result = matcherLink.replaceAll("<a href=\"$5\">$2</a>");

        Pattern p = Pattern.compile("(^(?!<h2>))(.*)", Pattern.MULTILINE);
        Matcher matcherP = p.matcher(result);
        result = matcherP.replaceAll("<p>$2</p>");

        StringBuilder sb = new StringBuilder(result);
        sb.insert(0, "<html>\n<body>\n").append("\n</body>\n</html>");

        return sb.toString();
    }
}
