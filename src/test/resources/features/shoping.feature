Feature: Test list add, remove and sort functionalities

Scenario: test add and delete items to list

Given Open OI application
When create new list
And Add few items
And delete one item
Then only added elements should retain


Scenario: test add and delete items to list

Given Open OI application
When create new list
And Add few items
And sort the list
Then verify sorted list items shown