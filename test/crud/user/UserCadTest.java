/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud.user;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Oswaldo
 */
public class UserCadTest {
    
    private static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/pfcTasker/planos.xhtml"); 
}
    
    @AfterClass
    public static void tearDownClass(){
        driver.quit();
    }
    
    @Test
    public void cadastrarUser(){
        WebElement btnCriar = driver.findElement(By.id("frmPlanos:cConta"));
        btnCriar.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 300);
        
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmCConta:email")));
        txtEmail.sendKeys("teste@testemail.com");
        
        WebElement txtSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmCConta:password")));
        txtSenha.sendKeys("teste123");
        
//        Select selPlan = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmCConta:plano"))));
//        selPlan.selectByVisibleText("Plano Free");
//        WebElement txtPlano = selPlan.getFirstSelectedOption();
        
        WebElement btnConta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmCConta:btnConta")));
        btnConta.click();
        
        WebElement msgSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-growl-title")));
                
        assertEquals("Sucesso", msgSucesso.getText());
    }
    
//    @Test
//    public void loginTestFalha(){
//        WebElement btnLogin = driver.findElement(By.id("frmPlanos:Login"));
//        btnLogin.click();
//        
//        WebDriverWait wait = new WebDriverWait(driver, 300);
//        
//        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:email")));
//        txtEmail.sendKeys("teste@testemail.com");
//        
//        WebElement txtSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:password")));
//        txtSenha.sendKeys("123");
//        
//        WebElement btnLogar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:loginButton")));
//        btnLogar.click();
//        
//        WebElement msgFalha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-growl-title")));
//                
//        assertEquals("Erro no Login", msgFalha.getText());
//    }
    
//    @Test
//    public void loginTestSucesso(){
//        WebElement btnLogin = driver.findElement(By.id("frmPlanos:Login"));
//        btnLogin.click();
//        
//        WebDriverWait wait = new WebDriverWait(driver, 300);
//        
//        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:email")));
//        txtEmail.sendKeys("teste@testemail.com");
//        
//        WebElement txtSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:password")));
//        txtSenha.sendKeys("teste123");
//        
//        WebElement btnLogar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmLogin:loginButton")));
//        btnLogar.click();
//                
//        assertEquals("Area de Usuario", driver.getTitle());        
//    }
    
}
