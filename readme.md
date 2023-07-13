# **_Hiking advisory app_**

To run this app download Maven link below

https://maven.apache.org/

Run command: **mvn clean install**

When run the app.

The application is running on http://localhost:8080

This application has one API endpoint:
http://localhost:8080/hike/inventory

The **distance** field accepts values higher than 0 and less than 1000

The **season** field accepts: **"summer", "autumn", "winter", "spring"**

The **surface** field accepts: **"gravel", "asphalt", "sand", "grass"**


Request example:

`{
"distance" : 10,
"season" : "summer",
"surface": "gravel"
}`

Expected response:

`{
"hikeInventory": {
"First Aid Kit": "1",
"Cap": "1",
"Sneakers": "1",
"Snacks": "1",
"Bottle of water": "1",
"Mobile Phone": "1",
"Camping Backpack": "1",
"Sunglasses": "1"
}
}`


