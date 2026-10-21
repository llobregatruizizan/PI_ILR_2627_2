import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class
PasswordCheckerTest {
    private Object password;
    private Object repeatPassword;

    PasswordChecker checker;
    @BeforeEach
    void setUp() {
        checker = new PasswordChecker();
        checker.setCheckUppers(true);
        checker.setCheckDigits(true);
        checker.setCheckLowers(true);
    }

    @Test void passwordCorrecto()
    {
        int resultado = checker.check("Abcde123", "Abcde123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test void comprobarDigitos()
    {


        int resultado = checker.check("Abcdzzzzz", "Abcdzzzzz");
        assertEquals(PasswordChecker.ERR_DIGITS, resultado);
    }

    @Test void comprobarMinusculas()
    {

        int resultado = checker.check("A123123123123", "A123123123123");
        assertEquals(PasswordChecker.ERR_LOWERS, resultado);
    }


    @Test void comprobarMayusculas()
    {
        int resultado = checker.check("a123123123123", "a123123123123");
        assertEquals(PasswordChecker.ERR_UPPERS, resultado);
    }

    @Test void comprobarLongitudMax()
    {
        checker.setMaxLength(8);
        int resultado = checker.check("Aa123123123123", "Aa123123123123");
        assertEquals(PasswordChecker.ERR_LENGTH, resultado);
    }

    @Test void comprobarLongitudMin()
    {
        int resultado = checker.check("aA123", "aA123");
        assertEquals(PasswordChecker.ERR_LENGTH, resultado);
    }

    @Test void comprobarLongitudMin2()
    {
        int resultado = checker.check("aA123", "aA123");
        assertEquals(PasswordChecker.ERR_LENGTH, resultado);
    }

    @Test void comprobarSetDigitsFalso()
    {
        checker.setCheckDigits(false);
        int resultado = checker.check("aAasdasdasd", "aAasdasdasd");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test void comprobarSetDigitsVerdadero()
    {
        int resultado = checker.check("aAasdasdasd", "aAasdasdasd");
        assertEquals(PasswordChecker.ERR_DIGITS, resultado);
    }



    @Test void comprobarSetLowersFalso()
    {
        checker.setCheckLowers(false);
        int resultado = checker.check("AAAAAAAAAA123", "AAAAAAAAAA123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }


    @Test void comprobarSetLowersVerdadero()
    {
        int resultado = checker.check("AAAAAAAAAA123", "AAAAAAAAAA123");
        assertEquals(PasswordChecker.ERR_LOWERS, resultado);
    }


    @Test void comprobarSetUppersFalso()
    {
        checker.setCheckUppers(false);
        int resultado = checker.check("aaaaaaaaa123", "aaaaaaaaa123");
        assertEquals(PasswordChecker.PASSWORD_OK, resultado);
    }

    @Test void comprobarSetUppersVerdadero()
    {
        int resultado = checker.check("aaaaaaaaa123", "aaaaaaaaa123");
        assertEquals(PasswordChecker.ERR_UPPERS, resultado);
    }






}
