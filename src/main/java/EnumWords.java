import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import com.google.gson.*;



public class EnumWords {

    private String message; //сообщение которое будет обрабатываться
    private int wordCount; // счётчик искомого слова
    private int simbolCount; //счётчик знаков препинания


    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSimbolCount() {
        return simbolCount;
    }

    public void setSimbolCount(int simbolCount) {
        this.simbolCount = simbolCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void readJson(String filepath) { //метод для чтения json
        JsonParser parser = new JsonParser();
        String elements[] = new String[10];
        int i = 0;
        try {
            JsonArray jArray = (JsonArray) parser.parse(new FileReader(filepath));
            for (Object o : jArray) {
                JsonObject root = (JsonObject) o;
                elements[i] = root.get("greeting").getAsString();//условимся, что именно это поле нас интересует
                i++;
            }
            setMessage(Arrays.toString(elements)); //пишем в поле message полученную строку из всего содержимого полей greeting
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchWord(String message, String targetWord) { //ищем и считаем требуемое слово
        System.out.println(message);
        message = message.toLowerCase();
        targetWord = targetWord.toLowerCase(); //приводим обе строки к одному регистру
        int i = message.indexOf(targetWord);
        int count = 0;
        while (i >= 0) {
            count++;
            i = message.indexOf(targetWord, i + 1);
        }
        setWordCount(count);
    }

    public void searchSimbols(String message) { //ищем все знаки препинания
        char[] c = {'.', ',', '-', ':', ';', '?', '!'};
        int count = 0;

        char[] ch = message.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (ch[i] == c[j]) {
                    count++;
                }
                setSimbolCount(count);
            }


        }

    }
}
