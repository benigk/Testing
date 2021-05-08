from locator import *
from element import BasePageElement
#when we set up a base page and base page is gonna stand for this will be the base class for all of our pages we will
# need to pass it a driver so the idea here is inside of this page file we're gonna define a class for each web page we
# are gonna test so say we have the home page and maybe like you know the search page or something like that then we
# would have two classes home page  search page and we would both inherit from base page because we've defined this constructor
# which will be used for both of them and there was any methods that we wanted both of them to have access to when you
# put them inside of base page and then since we are inheriting from base page we would get access to that
class SearchTextElement(BasePageElement):
    locator = "field-keywords"

class SignInButtonElement(BasePageElement):
    locator = "nav-search-submit-button"

class SearchButtonElement(BasePageElement):
    locator = "nav-search-submit nav-sprite"


class BasePage(object):
    def __init__(self, driver):
        self.driver = driver

class MainPage(BasePage):

    search_text_element = SearchTextElement()

    def is_title_matches_amazon(self):
        return "amazon" in self.driver.title

    def is_title_matches_Amazon(self):
        return "Amazon" in self.driver.title

    def click_sign_in_button(self):
        element = self.driver.find_element(*MainPageLocators.SIGNIN_BUTTON)
        element.click()

    def click_search_button(self):
        element = self.driver.find_element(*MainPageLocators.SEARCH_BUTTON)
        element.click()

class SearchResultPage(BasePage):

    def is_results_found(self):
        return "No results found." not in self.driver.page_source

