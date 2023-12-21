# Shape Drawing Application Documentation

This documentation outlines the structure and components of a shape drawing application implemented in Java. The application is designed around the Model-View-Controller (MVC) architecture and consists of several key interfaces and classes.

## Preview

https://github.com/zheenlu/shapes_album/assets/121406160/9e9f7237-d1a8-48ec-bacf-4ff952854bb5



### PhotoAlbumMain

`PhotoAlbumMain` is the main class of the application and serves as its entry point. It parses command-line arguments to configure and run the application. It validates command-line arguments and prints error messages for missing or invalid inputs.

In the main method, command-line arguments are parsed using a switch statement. The `PhotoAlbumMain` class creates and configures a `Controller` object to parse input files and generate outputs based on view configurations.

### IModel and Model

`IModel` defines the operations expected from the model in the shape drawing application. The model maintains a canvas of shapes and provides methods for adding, removing, resizing, and moving shapes. It also supports the creation and management of snapshots to capture the state of the canvas.

`Model` is the concrete class that implements the `IModel` interface. It contains two primary fields: `canvas` (a list of shapes in the model) and `snapshots` (a list of snapshots captured from the model). The `Model` class provides implementations for all the methods defined in the `IModel` interface.

### ISnapshot and Snapshot

A `Snapshot` represents a read-only copy of the model's state at a specific moment in time. Each `Snapshot` is a copy of the model's canvas tagged with a timestamp id and description. The `Snapshot` class implements the `ISnapshot` interface, which defines methods for retrieving information about the snapshot. In the `Snapshot` class, the constructor takes a short description of the snapshot and the current state of the model's canvas as input. It creates a new list of shapes and adds shapes from the input list as new `Rectangle` and `Oval` objects, ensuring immutability.

### Controller

`IController` is an interface for the controller class, responsible for coordinating interactions between the model and view components. It defines methods for parsing files, managing snapshots, generating outputs, and retrieving information from the view.

The `Controller` class implements `IController` and acts as the central component of the application. It initializes the model and view based on provided parameters and coordinates their interactions.

### View

The view component is responsible for rendering the application's user interface. It's represented by two concrete classes: `GUIView` and `WebView`. Both classes implement the `IView` interface, defining methods for generating output based on snapshots.

`GUIView` displays snapshots graphically in a Swing window with navigation controls, while `WebView` generates an HTML representation of the snapshots. Both classes provide methods for interacting with snapshots and user interfaces.

## Conclusion

This documentation provides an overview of the key components and their interactions in the shape drawing application. The Model-View-Controller design pattern separates data, user interface, and control flow, enabling flexibility and maintainability in the application's design.
