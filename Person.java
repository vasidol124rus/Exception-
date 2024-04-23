import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class Person {

    private String lastname;
    private String firstname;
    private String patronymic;
    private Date birthdate;
    private long phonenumber;
    private char gender;

    public Person(String[] data) throws InvalidDataFormatException {
        if (data.length != 6) {
            throw new InvalidDataFormatException("Недопустимое количество элементов данных.");

        }
        this.lastname = data[0];
        this.firstname = data[1];
        this.patronymic = data[2];

        try {
            this.birthdate = new SimpleDateFormat("dd.mm.yyyy").parse(data[3]);

        } catch (ParseException e) {
            throw new InvalidDataFormatException("Неверный формат даты рождения.");

        }

        try {
            this.phonenumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Неверный формат номера телефона.");

        }
        if (data[5].length() != 1 || (!data[5].equalsIgnoreCase("f") && !data[5].equalsIgnoreCase("m"))) {
            throw new InvalidDataFormatException("Неверный формат пола. Используйте 'f' для женщин и 'm' для мужчин.");

        }
        this.gender = data[5].charAt(0);
    }

    public String getLastName() {
        return lastname;
    }

    public String getFirstName() {
        return firstname;

    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public long getPhoneNumber() {
        return phonenumber;
    }

    public char getGender() {
        return gender;

    }
}
