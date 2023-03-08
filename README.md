# clean_architecture_sample
This Android application is built using Clean Architecture, Koin, Retrofit, Nav Graph, View Model, and Flavors. It is designed to showcase best practices and coding conventions for building scalable and maintainable Android applications.

# Architecture
This application follows the Clean Architecture principles proposed by Robert C. Martin (Uncle Bob). It is composed of three layers:

Presentation layer: This layer is responsible for displaying the UI to the user and receiving user inputs. It is built using Android's XML layouts and Fragments, along with the View Model component to handle UI logic.

Domain layer: This layer contains the business logic and use cases of the application. It is independent of any framework or platform-specific code and can be reused across different platforms.

Data layer: This layer is responsible for providing data to the domain layer. It uses the Retrofit library to perform HTTP requests and retrieve data from the server. It also uses Koin for dependency injection to provide the necessary dependencies to the classes in this layer.

The communication between these layers is done using interfaces and abstractions, allowing for loose coupling and easier testing.

# Dependencies
This application uses several third-party libraries to provide additional functionality:

Koin: Used for dependency injection.
Retrofit: Used for making HTTP requests and handling network responses.
Nav Graph: Used for handling navigation between screens.
View Model: Used for handling UI logic and maintaining the state of the UI.
Gson: Used for serializing and deserializing JSON data.

# Flavors
This application uses flavors to demonstrate how different build variants can be used to customize the behavior of an application. Two flavors are provided:

Development: This flavor is used for development purposes and connects to a development server.
Production: This flavor is used for release builds and connects to a production server.
To switch between flavors, simply select the desired flavor from the Build Variants panel in Android Studio.

# Conclusion
This application provides a solid foundation for building scalable and maintainable Android applications using Clean Architecture, Koin, Retrofit, Nav Graph, View Model, and Flavors. It demonstrates best practices and coding conventions that can be applied to any Android application to improve its quality and maintainability.