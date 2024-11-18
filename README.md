# Weather forecast
This is the start of a weather app for android
It takes a hardcoded coordinates value to fetch weather data from Meterologisk institutt, and displays the current weather for the provided location

## Tools
This app is made using the MVVM pattern, retrofit and okHttp in the network layer and koin for dependency injection. The weather data is fetched async using coroutines. 

## Future work
this app is not complete as per the core requirements. to complete the core requirements, I would do these things next
- [ ] create a strings file and map them to the `SymbolCode` enums
- [ ] map icons to `SymbolCode` enums
- [ ] use strings and icons to display a more human friendly weather description
- [ ] add more basic styling to composable showing current weather, including boarder around the view, text styling, background colour and separator between elements
- [ ] ask for location permission and use the location to fetch weather data for current location.

in addition, these are the things that I would do next that is outside of the core requirements
- [ ] organize code in folders and modules
  - [ ] move composables to it's own folder
- [ ] make a dimens to hold padding values etc used in composables
- [ ] localisation. make sure that the numbers are displayed in a norwegian number format
- [ ] introduce useCase classes and move logic from viewModel there related to each network call. 
