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

// Przeniesienie na podany adres URL zawartego jako VARIABLE w programie

WebUI.navigateToUrl(url)

// Wcisniecie pola "Sign in" ktore przenosi do podstrony odpowiedzialej za rejestracje jak i logowanie

WebUI.click(findTestObject('Object Repository/Page_My Store/a_Sign in'))

// Wprowadzenie poprawnego, nie uzytego wczesniej adresu Email w polu "address email" w bloku REGISTER zawartego jako VARIABLE w programie

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email_create'), email)

// Przeniesienie na podstrone z formularzem nowego uzytkownika

WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Create an account'))

// Wprowadzenie poprawnych danych w pole " First Name " pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__customer_firstname'), findTestData('Dane1').getValue(
        1, 1))

// Wprowadzenie poprawnych danych w pole "Last Name" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__customer_lastname'), findTestData('Dane1').getValue(
        1, 2))

// Wprowadzenie poprawnych danych w pole "Password" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - My Store/input__passwd'), findTestData('Dane1').getValue(
        1, 3))

// Wprowadzenie poprawnych danych w pole "Address" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__address1'), findTestData('Dane1').getValue(
        1, 4))

// Wprowadzenie poprawnych danych w pole "City" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__city'), findTestData('Dane1').getValue(1, 5))

// Wybranie poprawnej opcji z Comboboxa "State"

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Login - My Store/select_-AlabamaAlaskaArizonaArkansasCalifor_c52141'), 
    '16', true)

// Wprowadzenie poprawnych danych w pole "Postal/Zip Code" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__postcode'), findTestData('Dane1').getValue(
        1, 6))

// Pominiecie wymaganego pola "Mobile phone", przejscie do kolejnego pola

WebUI.click(findTestObject('Object Repository/Page_Login - My Store/div_Create an accountYour personal informat_4721ab'))

// Wprowadzenie niepoprawnych danych w pole "Assign an address alias for future reference" pobieranych z Pliku (DATA FIILE) przez program

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input__alias'), findTestData('Dane1').getValue(1, 
        7))

// Wcisniecie przycisku "Register" w celu ukonczenia rejestracji

WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Register'))

// Pojawia sie blad informujacy o braku wypelnionego pola oraz o blednych danych

WebUI.verifyElementText(findTestObject('Object Repository/Page_Login - My Store/li_You must register at least one phone number'), 
    'You must register at least one phone number.')

