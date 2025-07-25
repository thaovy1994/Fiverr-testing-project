package scripts;

import listeners.TestListenerRegistration;
import org.testng.annotations.Listeners;
import pages.RegisterPage;
import org.testng.annotations.Test;

@Listeners(TestListenerRegistration.class)
public class RegistrationTest extends BaseTest{
    @Test(priority = 1)
    public void verifyValidRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.validRegistration("mina","mina1@gmail.com","abc123","abc123","0790512345","12-25-2000");
    }

    @Test(priority = 2)
    public void  verifyEmptyRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerWithEmptyFields();
    }

    @Test(priority = 3)
    public void verifyInvalidNameFormat (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidNameFormat("mina!@#");
    }

    @Test(priority = 4)
    public void verifyInvalidEmailFormat (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidEmailFormat("abc@vn");
    }

    @Test(priority = 5)
    public void verifyInvalidPassword (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidPassword("abc");
    }

    @Test(priority = 6)
    public void verifyInvalidPhone (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidPhone("0123");
    }

    @Test(priority = 7)
    public void VerifyDOB(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterDOB("05-10-2025");
    }

    @Test(priority = 8)
    public void verifyCheckbox (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.uncheckBox("mina","mina@gmail.com","abc123","abc123","0790512345","12-25-2000");
    }

    @Test(priority = 9)
    public void verifyExistingEmail(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.checkExistingEmail("mina","mina@gmail.com","abc123","abc123","0790512345","12-25-2000");
    }
}
