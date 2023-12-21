In this project, I have implemented the Model-View-Controller (MVC) design pattern to separate the concerns of data management, user interface, and control flow. The primary components of this pattern in our project are the Controller, GraphicalView, WebView, and Album (model) classes.

Model - Album
    The Album class is a singleton class that represents the data model for our application. It manages the shapes and snapshots, as well as provides methods for adding, moving, resizing, changing color, and removing shapes. The model is responsible for maintaining the state of the application and notifying the views of any changes in the state.

Views - GraphicalView and WebView
    The views are responsible for displaying the data from the model in a user-friendly format. In our project, we have two different types of views: GraphicalView and WebView.

GraphicalView: The GraphicalView class extends JFrame and is responsible for displaying the model in a graphical interface. The class consists of methods to create and manage the buttons panel, the snapshot panel, and the snapshot display. It also implements the Singleton pattern to ensure only one instance of the class is created.
SnapshotPanel: The SnapshotPanel class extends JPanel and is responsible for displaying a single snapshot of the model, including the snapshot's ID, description, and shapes. The shapes are drawn using Java's Graphics API.
WebView: The WebView class generates an HTML file with a visual representation of the model. The class consists of methods to create the head and body of the HTML file, as well as to generate SVG elements for each shape in the snapshots. The WebView class also implements the Singleton pattern to ensure only one instance of the class is created.

Controller - Controller
    The Controller class acts as an intermediary between the views and the model. It implements the IController interface and provides methods for reading input files, running the views, and delegating user actions to the model. When a user performs an action in a view, the controller interprets that action and calls the appropriate method in the model. The controller also handles any exceptions that might occur during the execution of these actions.
    It implements the IController interface and is responsible for managing the model and the views. The class contains methods to read input files, create and manipulate shapes, and to run the graphical or web views. The input file contains commands to create, move, resize, and remove shapes, as well as to take snapshots of the current state of the model.
    The methods available in the Controller class are:
        readFile: Reads the input file and processes each command.
        runWebView: Reads the input file and runs the WebView to generate an HTML file with the visual representation of the model.
        runGraphicalView: Reads the input file and runs the GraphicalView to display the model in a graphical interface.
        createShape: Creates a shape with the given arguments and adds it to the model.
        moveShape: Moves a shape with the given name to a new position.
        changeColor: Changes the color of a shape with the given name.
        resizeShape: Resizes a shape with the given name.
        removeShape: Removes a shape with the given name from the model.
        takeSnapshot: Takes a snapshot of the current state of the model with an optional description.
PhotoAlbumMain: The PhotoAlbumMain class contains the main method for the application. It reads command-line arguments to determine the input file, output file, view type, and dimensions for the views. Based on the provided arguments, it runs either the WebView or the GraphicalView using the Controller.

The relation between the Controller, Views, and Model is as follows:
    The Controller reads the input file and calls the appropriate methods in the model to create, move, resize, change color, or remove shapes.
    The Controller runs the specified view (GraphicalView or WebView) and passes the necessary data from the model to the view.
    The views (GraphicalView and WebView) display the data from the model in their respective formats.
    When a user performs an action in a view, the controller interprets that action and calls the appropriate method in the model to update the data.
    If the data in the model changes, the views are updated to reflect those changes.

