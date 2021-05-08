*** Settings ***
Documentation    This test suite tests basic use cases
Library  SeleniumLibrary  run_on_failure=Nothing
Resource  URLs.robot
Resource  browsers.robot
Resource  values.robot
Resource  buttons.robot
Resource  inputs.robot

*** Test Cases ***
Pre-conditions
    Set Selenium Speed  1.0
    Open Browser  ${URL_Amazon_Webpage}  ${BrowserChrome}

TC_Wenjie_001_SignIn
    Wait Until Element Is Visible  ${Area_Amazon_SignIn_XPath}
    mouse over  ${Area_Amazon_SignIn_XPath}
    Wait Until Element Is Visible  ${Button_Amazon_SignIn_XPath}
    click element  ${Button_Amazon_SignIn_XPath}
    input text  ${Input_Amazon_SignInEmailTextBox_XPath}  ${Value_Amazon_SignInEmailCorrect01}
    click element  ${Button_Amazon_SignInContinue_XPath}
    input password  ${Input_Amazon_SignInPasswordTextBox_XPath}  ${Value_Amazon_SignInPasswordCorrect01}
    click element  ${Button_Amazon_SignInSubmit_XPath}

Post-Conditions
    Close Browser

