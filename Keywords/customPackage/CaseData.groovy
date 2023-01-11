package customPackage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class CaseData {

	@Keyword
	def GetCaseDataAsString(String excelDataPath, String excelCol, int excelRow){
		def excelData = TestDataFactory.findTestData(excelDataPath)
		def test = excelData.getValue(excelCol, excelRow)

		Console.println(test)
	}

	@Keyword
	def WriteToFile(String[] LPAsToWriteToFile, String ReportDirectory, String fileName){
		if (LPAsToWriteToFile.size() > 0) {
			def file = new File(ReportDirectory)

			file.mkdir()

			new File(ReportDirectory, fileName).withWriter('utf-8', { def writer ->
				LPAsToWriteToFile.each({
					if (it != null) {
						System.out.println(it + '\r\n')

						writer.write(it + '\r\n')
					}
				})
			})
		}
	}

	@Keyword
	def CreateReportTemplate(String[] ReprotTemplateArray, String Header) {
		(ReprotTemplateArray[0]) = Header

		(ReprotTemplateArray[1]) = '  '

		(ReprotTemplateArray[2]) = '------------------------------------------------------'

		(ReprotTemplateArray[3]) = '  '
	}
}
