*** Settings ***
Documentation    This test suite tests basic use cases.
Library  SeleniumLibrary  run_on_failure=Nothing
Resource  URLs.robot
Resource  browsers.robot
Resource  values.robot
Resource  buttons.robot
Resource  inputs.robot

*** Test Cases ***
Pre-conditions
    Set Selenium Speed  0.2
    Open Browser  ${URL_Amazon_Webpage}  ${BrowserChrome}

TC_Marek_001_Search for an item and put it in cart
    Wait Until Element Is Visible  ${Input_Amazon_SearchTextBox_XPath}
    Wait Until Element Is Visible  ${Button_Amazon_SearchTextBox_XPath}
    Input Text  ${Input_Amazon_SearchTextBox_XPath}  ${Value_Amazon_Notebook}
    Click Element  ${Button_Amazon_SearchTextBox_XPath}
    Wait Until Element Is Visible  ${Value_Amazon_SearchResult_Notebook_XPath}
    Element Should Be Visible  ${Value_Amazon_SearchResult_Notebook_XPath}
    Wait Until Element Is Visible  ${Value_Amazon_SearchResult_SpecificNotebookLink_XPath}
    Click Element  ${Value_Amazon_SearchResult_SpecificNotebookLink_XPath}
    Wait Until Element Is Visible  ${Button_Amazon_Product_AddToCart_XPath}
    Click Element  ${Button_Amazon_Product_AddToCart_XPath}
    Wait Until Element Is Visible  ${Button_Amazon_Product_AddToCart_Popup_Cart_XPath}
    Click Element  ${Button_Amazon_Product_AddToCart_Popup_Cart_XPath}
    Wait Until Element Is Visible  ${Value_Amazon_Cart_Subtotal}
    Element Should Contain  ${Value_Amazon_Cart_Subtotal}  Subtotal (1 item):

Post-Conditions
    Close Browser
