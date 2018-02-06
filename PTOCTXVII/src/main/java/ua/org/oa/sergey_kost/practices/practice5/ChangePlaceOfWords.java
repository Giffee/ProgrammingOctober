package ua.org.oa.sergey_kost.practices.practice5;

import java.io.*;

public class ChangePlaceOfWords {
    public static String readFromFile(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                sb.append(br.readLine());
            }

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return sb.toString();
    }

    public static String changePlaceOfWords(String str) {
        String[] words = str.concat(" ").split(" ");
        StringBuilder change = new StringBuilder();
        change = change.append(words[words.length - 1]).append(" ");

        for (int i = 1; i < words.length - 1; i++) {
            change = change.append(words[i]).append(" ");
        }
        change.append(words[0] + "");
        return change.toString();
    }

    public static String changeWordsInAllSentences(String str) {
        String[] sentence = str.concat(" ").split("\\. ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sentence.length; i++) {
            sb.append(changePlaceOfWords(sentence[i]) + ". ");
        }
        return sb.toString();
    }
}
