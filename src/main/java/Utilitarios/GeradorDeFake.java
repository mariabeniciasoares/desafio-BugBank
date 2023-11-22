package Utilitarios;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class GeradorDeFake {
    private Faker faker;
    private String  firstName;
    private String  fullName;
    private String  lastname;
    private String  email;


    public GeradorDeFake(WebDriver driver) {

        faker = new Faker(new Locale("pt-BR"));
    }

    public String   getFirstName(){
        firstName   =   faker.name().firstName();
        return firstName;
    }
    public String   getFullName(){
        fullName   =   faker.name().fullName();
        return fullName;
    }

    public String   getLastname(){
        lastname    =   faker.name().lastName();
        return lastname;
    }

    public String   getEmail(){
        email   =   faker.internet().emailAddress();
        return email;
    }


}
