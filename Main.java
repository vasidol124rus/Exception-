import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Введите данные через пробел(Фамилия Имя Отчество дату_рождения (в формате dd.mm.yyyy) номер_телефона пол)");
        String input = scanner.nextLine();
        scanner.close();

        String[] data = input.split("\\s+");

        try {
            Person person = new Person(data);
            writeToFile(person);
            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void writeToFile(Person person) throws IOException{
        String fileName = person.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(String.format("%s %s %s %s %d %c\n", 
            person.getLastName(),
            person.getFirstName(),
            person.getPatronymic(),
            new SimpleDateFormat("dd.mm.yyyy").format(person.getBirthDate()),
            person.getPhoneNumber(),
            person.getGender()));
        }
    }

}
