import unittest
from selenium import webdriver
import page
import time

class PythonOrgSearch(unittest.TestCase):
    #first step
    def setUp(self):
        print("setup")
        self.driver = webdriver.Chrome("C:\Program Files (x86)\chromedriver.exe")
        self.driver.get("http://www.amazon.com")

#    def test_example(self):
        # see if the condition on the right side is true
#        assert False


#    def test_title_amazon(self):
#       mainPage = page.MainPage(self.driver)
#       assert mainPage.is_title_matches_amazon()

    def test_search_Amazon(self):
        mainPage = page.MainPage(self.driver)
        assert mainPage.is_title_matches_Amazon()
        mainPage.search_text_element = "DEAUVILLE MINI"
        mainPage.click_search_button()


#   def test_search_LV(self):
#        mainPage = page.MainPage(self.driver)
#        assert mainPage.is_title_matches()
#        mainPage.search_text_element = "DEAUVILLE MINI"
#        mainPage.click_go_button()
#        search_result_page = page.SearchResultPage(self.driver)
#        assert search_result_page.is_results_found()


#   def tearDown(self):
#        self.driver.close()

if __name__ == "__main__":
    # run all the tests that we have defined
    unittest.main()
