Travel Destination App

This Android app allows users to explore various travel destinations, displaying key information about each destination, such as the best season to visit, popular attractions, and a brief description. The app is designed to provide a smooth user experience, integrating various Android development best practices, including RecyclerView for displaying lists and API integration for fetching data dynamically.

Features

	•	Login Screen: Secure login interface to authenticate users.
	•	Dashboard: Displays a list of travel destinations with a summary (destination, country, best season).
	•	Detail Screen: Provides detailed information about a selected destination, including popular attractions and a full description.
	•	API Integration: Fetches destination data from a remote server.
	•	Responsive UI: Adapts to different screen sizes using Material 3 design principles.
	•	Smooth Navigation: Uses Android’s Navigation Component for seamless transitions between screens.

Technologies Used

	•	Programming Language: Kotlin
	•	UI Framework: Jetpack Compose / XML (depending on your implementation)
	•	API Handling: Retrofit for network requests and Moshi for JSON parsing
	•	Data Management: RecyclerView for displaying travel destinations and ViewModel for managing UI-related data
	•	UI Navigation: Android Navigation Component for managing app navigation
	•	Design: Material 3 design principles for consistent and modern UI components
	•	Version Control: Git (recommended tool: SourceTree)

Screens

	1.	Login Screen:
	•	Allows users to log in with their credentials.
	•	Validates input and provides feedback for invalid login attempts.
	2.	Dashboard Screen:
	•	Displays a list of travel destinations in a RecyclerView.
	•	Summaries include the destination name, country, and the best season to visit.
	3.	Detail Screen:
	•	Shows detailed information about the selected travel destination.
	•	Includes the destination’s description and popular attractions.

Data Model

The app uses a DetailItem model for travel destination data, with fields such as:

	•	destination: The name of the travel destination.
	•	country: The country where the destination is located.
	•	bestSeason: The best season to visit.
	•	popularAttraction: A notable attraction in the destination.
	•	description: A detailed description of the destination.

 Example API Response (JSON) : 
{
  "destination": "Paris",
  "country": "France",
  "bestSeason": "Spring",
  "popularAttraction": "Eiffel Tower",
  "description": "A beautiful city with rich history and culture."
}

Setup and Installation

To run the app locally, follow these steps:

	1.	Clone the repository: https://github.com/meverlyyg/FinalAsignment_NIT3213.git

 	2.	Open in Android Studio: Launch Android Studio and open the cloned project.
	3.	API Setup: Ensure that the API endpoint for fetching travel data is correctly configured in your Retrofit instance.
	4.	Run the app: Connect your Android device or emulator and click “Run” in Android Studio.

Development Notes

	•	Navigation: The app uses a BottomNavigationView for switching between screens (e.g., Dashboard, Profile).
	•	Fragments: The Dashboard and Profile views are managed via fragments.
	•	Material 3: The app’s UI follows Material 3 guidelines, but customization may be necessary depending on your app’s design needs.
	•	Version Control: Follow best practices for Git branching (e.g., feature branches for new features).
