@addplace 
Feature: adding a place 
@add 
Scenario: Adding a place and verifying it 
	Given the environment URL 
	When header values are passed 
		|Content-Type | application/json|
	And query parameters are passed 
		|key |qaclick123 | 
	#And payload is passed with the expected values 
	#|lat|lng|accuracy|name|phone_number|address|type1|type2|website      |language|
	#|123|-50|50      |vgb |897712120   |vhs    |ship |ment |www.gmail.com|eng|		
	And payload is passed with the expected values along with json file "postpayload" 
	| name | bhargav  |
	| address | hyderabad  |
	And pass the "post" resource name 
	Then validate the status as "200" 
	And retrieve the "place_id" value 
	Given the environment URL 
	And query parameters are passed 
		|key |qaclick123 | 
		|place_id| ENV-place_name |
	And pass the "get" resource name passed 
	Then validate the status as "201" 
	#And verify name in post and get are same 
	
@get 
Scenario: get details 
	Given the environment URL 
	And query parameters are passed 
		|key |qaclick123 | 
		|place_id| 9a6865ed31ffa3cefc2eb40a211d0762 |
	And pass the "get" resource name passed 
	Then validate the status as "200" 
	


	
	
	
