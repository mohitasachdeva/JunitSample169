import com.bridgelap.UserRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    static UserRegistration user;
    @BeforeAll
    public static void initiate(){
        user = new UserRegistration();
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInFnameAndMinThreeAlphabetsShouldReturnTrue() {

        String actual = user.validFirstName("Mohita");
        String expected = "Valid";
        Assertions.assertSame(actual, expected);
    }

    @Test
    public void givenTextWhenItDoesNotContainsFirstCapsInFnameShouldReturnTrue() {
        String actual = user.validFirstName("mohita");
        String expected = "InValid";
        Assertions.assertSame(actual, expected);
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInFnameButNotMinThreeCharShouldReturnTrue() {
        String actualResult = user.validFirstName("Mo");
        String expectedResult = "InValid";
        Assertions.assertSame(actualResult, expectedResult);
    }

    @Test
    public void givenTextWhenItDoesNotContainsFirstCapsInlnameShouldReturnTrue() {
        String actualResult = user.validFirstName("khurana");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenTextWhenItContainsFirstCapsInlnameButNotMinThreeCharShouldReturnTrue() {
        String actualResult = user.validSecondName("khu");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }
    @Test
    public void givenTextWhenItContainsFirstCapsInSnameShouldReturnTrue() {
        String actual = user.validFirstName("Mohita");
        String expected = "Valid";
        Assertions.assertSame(actual, expected);
    }

    @Test
    public void givenEmailWhenDoesNotContainsAtTheRateShouldReturnFalse() {

        String actualResult = user.validEmailId("mohi.gmail.com");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenDoesNotContainsabcShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz.gmail.co.in");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsMoreThanThreeCharAtLastShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz.gmail.co.india");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsMoreThanTwoTLDShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz.gmail.co.in.co");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsOneCharInTLDShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz.gmail.co.i");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsDoubleDotsShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz..gmail.co.i");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsSpecialCharacterShouldReturnFalse() {
        String actualResult = user.validEmailId("xyz.gmail.c@.i");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenItContainsDigitsInTLDShouldReturnFalse() {

        String actualResult = user.validEmailId("xyz.gmail.c1.i");
        String expectedRes = "InValid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenEmailWhenAccordingToProperReqShouldReturnTrue() {
        String actualResult = user.validEmailId("abc.xyz@bl.co.in");
        String expectedRes = "Valid";
        Assertions.assertEquals(actualResult, expectedRes);
    }

    @Test
    public void givenMobileNumberWithSpaceAndProperNumberShouldReturnTrue() {
        String actualResult = user.validPhoneNumber("91 7988939334");
        String expectedRes = "Valid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenMobileNumberWithoutSpaceAndProperNumberShouldReturnFalse() {

        String actualResult = user.validPhoneNumber("917988939334");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenMobileNumberWithSpaceButNotProperCountryCodeShouldReturnFalse() {

        String actualResult = user.validPhoneNumber("5246981635");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenPasswordWithoutAnUpperCaseShouldReturnFalse() {

        String actualResult = user.validPassword("abcc@123");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenPasswordWithoutASpecialCharShouldReturnFalse() {

        String actualResult = user.validPassword("abccc123");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenPasswordWithoutALowerCaseShouldReturnFalse() {

        String actualResult = user.validPassword("MMMMMM@123");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenPasswordWithoutMinNumOfCharShouldReturnFalse() {

        String actualResult = user.validPassword("Mo@123");
        String expectedRes = "InValid";
        Assertions.assertSame(actualResult, expectedRes);
    }

    @Test
    public void givenPasswordWithProperRequirementsShouldReturnTrue() {

        String actualResult = user.validPassword("Abccc@123");
        String expectedRes = "Valid";
        Assertions.assertEquals(actualResult, expectedRes);
    }
}
