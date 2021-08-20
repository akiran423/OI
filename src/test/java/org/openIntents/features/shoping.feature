Feature: Test list add, remove and sort functionalities

@test1
Scenario: test add and delete items to list

Given Open OI application
When Create new list
And Add few items
And Delete one item

@sort @test2
Scenario: Verify added elements in a list are in sorted order

Given Open OI application
When Create new list
And Add few items
And Delete one item
Then List items are in sorted order
