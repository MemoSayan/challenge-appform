package mx.com.appfull.app.fullstack.domain.services.token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TokenGenerator {

        // Prueba con un nombre y apellido
        private String name;
        private String lastName;

        // Llama al método para generar el string
       // String result = generateString(name, lastName);

    // Método que comprueba si un carácter es una vocal (mayúscula o minúscula)
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // Método que genera el string a partir del nombre y apellido
    public static String generateString(String name, String lastName) {
        String result = "";
        // Crea un objeto Random para generar números aleatorios
        Random random = new Random();

        // Recorre el nombre y añade las vocales al resultado
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (isVowel(c)) {
                result += c;
            }
        }
        // Añade la primera letra del apellido al resultado
        result += lastName.charAt(0);
        // Añade la última letra del apellido al resultado
        result += lastName.charAt(lastName.length() - 1);
        // Añade tres números aleatorios al resultado
        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(10); // Genera un número entre 0 y 9
            result += n;
        }
        return result;
    }


}