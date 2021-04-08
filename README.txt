==========================================================================================
Top 15 UI Test Automation Best Practices You Should Follow
https://www.blazemeter.com/blog/top-15-ui-test-automation-best-practices-you-should-follow
===========================================================================================
[01] Do not rely ONLY on UI test automation
==> agile test pyramid, initially designed by Mike Cohn.
 -1st always Unit test (70%)
 -2nd priority goes to API testing, IntegrationTest, ComponentTest (20%)
 -3rd priority goes to GUI testing Manual+Automated (10%)
   Let’s try to think why the pyramid was constructed this way.
   First, low-level tests are much faster by nature.
   Unit tests are faster than API tests while API tests are much faster than UI tests.
   Why is this important? Mainly, because faster tests give you faster feedback.
   Faster feedback from tests execution allows you to catch issues early on, saving you huge amounts of costs.
 
[02] Consider using a BDD framework

[03] Always always ALWAYS use test design patterns and principles
==> Page Objects Design pattern
 why??? To avoid code Duplication, To improve Readability ,TO organize code & TO improves test maintenance
 
[04] NEVER use Thread.sleep() unless there are specific test requirements
 why? hold Appn but guranty what if it takes more than that time or less? & never mix implicit & explicit.better with Explicit wait.
 
[05] Do not run ALL tests across ALL target browsers.(cross browser Testing)
==>Just run main test case like HP in other browser also choose which cover most Functionality then run only that.
   E2E only in most use browser like CHROME()
	Chrome 63.5%
	Safari 19.00%
	Firefox 3.7
	Edge 3.5

[06] Separate your tests from your test automation framework
[07] Make your test automation framework portable
[08] Name your tests wisely
[09] Use soft assertions if you need to make a list of related checks on the same web page
[10] Take screenshots for failure investigation

[11] Make tests simpler instead of adding comments
==> Using POM design pattern we can Absolutely work without Comments

[12] Follow the “green tests run” policy
==>  “green tests policy” we mean that if some tests failed and are red, then 100% you have an issue in your application under test.
     some QAE follow some don't. coz some of test case are suppose to fail.already created minor bug. fixed later. coz it's not a blocker.

[13] Use data-driven instead of repeated tests

[14] All tests should be independent
==> You might disagree, but I strongly believe that ALL tests should ALWAYS be independent. 
 	Dependencies will make your tests hard to read and maintain.
 	You will definitely get into trouble during parallel automation runs because during 
 	parallel testing you cannot guarantee the order of your tests in the run.
 	
[15] Setup detailed automation tests reporting
[16] Use assertion Only in Test Class & Never use driver instance in Test class.

[17] Implement run fail test twice feature in Regression TestSuite.
==> means sometime test case fail because of various region that may pass in Rerun. 
   & even they fail twice. then we don't have to run locally twice to verify for creating Bug.

-----------------------------------
How to push from git bash 
----------------------------------
1.git status will show the file in red
2. git add type name + tab for autocomplete
3. git add .  ==> will add all & git * ==> will add all
4. git status will show the file in greeen
5. git rm --cached README.md ==> to send back to unstaged
6. git commit -m "added jmeter file"
7. git push origin master
