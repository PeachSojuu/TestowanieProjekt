import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Otwarcie przegladarki

WebUI.openBrowser('')

// Przekierowanie na podany adres URL zawarty w programie jako VARIABLE

WebUI.navigateToUrl(url)

// Wcisniecie pola "Sign in" w celu zalogowania sie na istniejace juz konto

WebUI.click(findTestObject('Object Repository/Page_My Store/a_Sign in'))

// Wprowadzenie poprawnego adresu Email w pole odpowiadajace za logowanie zawartego w programie jako VARIABLE

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email'), mail)

// Wprowadzenie poprawnego haslo w pole odpowiadajace za logowanie zawartego w programie jako VARIABLE

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - My Store/input_Password_passwd'), haslo)

// Wcisniecie przycisku Sign in w celu zalogowania

WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Sign in'))

// Wyswietlenie karty uzytkownika oraz wcisniecie przycisku My Personal Information

WebUI.click(findTestObject('Object Repository/Page_My account - My Store/span_My personal information'))

// Wprowadzenie poprawnych danych w pole "Current password" pobieranego z pliku (DATA FILE) przez program

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Identity - My Store/input_Current Password_old_passwd'), findTestData(
        'Dane4').getValue(1, 1))

// Wprowadzenie popranych danych w pole "New password" pobieranego z pliku (DATA FILE) przez program

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Identity - My Store/input_New Password_passwd'), findTestData(
        'Dane4').getValue(1, 2))

// Wprowadzenie poprawnych lecz nie odpowiadajacych danych w pole "Confirmation" pobieranego z pliku (DATA FILE) przez program

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Identity - My Store/input_Confirmation_confirmation'), findTestData(
        'Dane4').getValue(1, 3))

// Wcisniecie przycisku "Save"

WebUI.click(findTestObject('Object Repository/Page_Identity - My Store/span_Save'))

// Przekierowanie na komunikat o niepasujacych do siebie haslach

WebUI.verifyElementText(findTestObject('Page_Identity - My Store/li_The password and confirmation do not match'), 'The password and confirmation do not match.')

