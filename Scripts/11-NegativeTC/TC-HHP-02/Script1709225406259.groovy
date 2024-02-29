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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// TC for Negative Case, Invalid Value:
// 1. Penghasilan < Pengeluaran
// 2. Penghasilan == Pengeluaran
// -----

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

// Error Verification
// Wording for "Isi kurang dari nilai sebelumnya" & Not Clickable Hitung Button
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti/p_Isi kurang dari nilai sebelumnya'), 0)

WebUI.verifyElementNotClickable(findTestObject('Page_Hitung Harga Properti/button_Hitung'))

WebUI.takeScreenshot()

// Close Web
WebUI.closeBrowser()

