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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open Web
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.btnproperti.co.id/tools/hitung-harga-properti')

// Input Penghasilan
WebUI.setText(findTestObject('Page_Hitung Harga Properti/input_Penghasilan'), Penghasilan)

WebUI.takeScreenshot()

// Input Pengeluaran
WebUI.setText(findTestObject('Page_Hitung Harga Properti/input_Pengeluaran'), Pengeluaran)

WebUI.takeScreenshot()

// Input Jangka Waktu
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Hitung Harga Properti/select_Jangka Waktu'), JangkaWaktu, true)

WebUI.takeScreenshot()

// Submit
WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti/button_Hitung'))

// Price Result
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti/h5_Harga Properti Maksimal Kamu'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti/h3_Hasil Harga'), 0)

WebUI.takeScreenshot()

// Price Verification in Formula
// (Penghasilan - Pengeluaran) * (Jumlah Bulan * Jangka Waktu) / 3

// Variables
def penghasilan = Double.parseDouble(Penghasilan)
def pengeluaran = Double.parseDouble(Pengeluaran)
String getNumber = JangkaWaktu.replaceAll('[^0-9]', '')
def jangkaWaktu = Integer.parseInt(getNumber)

// Formula Execution
def a = penghasilan - pengeluaran
def b = jangkaWaktu * 12
def result = a * b / 3
println(result)

// Result & Price Conversion for Verification
String finalResult = String.format('%.0f', result)
println(finalResult)
def getPrice = WebUI.getText(findTestObject('Object Repository/Page_Hitung Harga Properti/h3_Hasil Harga'))
String getGetPrice = getPrice.replaceAll('[^0-9]', '')
WebUI.verifyEqual(finalResult, getGetPrice)

// Close Web
WebUI.closeBrowser()

