# Earthquake Backend

To run the program make sure that you are using at least Java 11. Then run EarthquakeApplication from your IDE.

## Endpoint(s)

GET localhost:8080/earthquake?days={}&country={} (replace curly brackets with input that you want to give)

Example: localhost:8080/earthquake?days=30&country=Turkey

## Additional Info

* Normally I would create entities for the whole JSON response. But, task was not complex so, I just made entity for only 
required parts.
* Country is case-sensitive.
* Sometimes API doesn't give information about the country. For example, if you write country as America, it will not return any earthquake information. But, if you give country as state of America like Alaska it will return earthquake information.