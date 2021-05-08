# so the idea behind this file is any CSS selector any ID way that we locate an element we should keep in on centralized
# location so that if we ever need to it's very easy to change the ID or to chage the CSS selector to change some
# attribute and we don't have to change any other aspect of the code other than this file which will be quite small
# so what we're  actually doing here is

#waht we're gonna do is create classes that represent objects that we want to find so

from selenium.webdriver.common.by import By

class MainPageLocators(object):
    SIGNIN_BUTTON = (By.ID, "nav-link-accountList-nav-line-1")
    SEARCH_BUTTON = (By.ID, "nav-search-submit-button")


class SearchResultsPageLocators(object):
    pass