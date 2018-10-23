import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EnumWords ew = new EnumWords();     //создаем экземпляр класса для поиска слова и знаков препинания
        Scanner input = new Scanner(System.in);

        System.out.println("Введите искомое слово: ");
        String wordTarget = input.nextLine();

        String filepath = "./src/main/resources/generated.json";

        ew.readJson(filepath);
        System.out.println("Читаем файл...");
        ew.searchWord(ew.getMessage(), wordTarget);
        System.out.println("Слово " + wordTarget + " повторяется " + ew.getWordCount() + " раз");

        ew.searchSimbols(ew.getMessage());
        System.out.println("Количество знаков препинания в файле: " + ew.getSimbolCount());
    }
}
