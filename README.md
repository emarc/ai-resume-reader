# AI-powered Resume Reader

This is a simple all-in-one-view demo using the [Vaadin AI Form Filler](https://vaadin.com/docs/latest/tools/ai-form-filler) to fill a Resume form with information extracted from free-text – i.e copy and paste in the contents from a Resume PDF, and let the AI fill the form.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Project structure

`ResumeReaderView.java` contains everything - the form, the AI Form Filler integration (look in the button click-listener), and some inner classes used to represent items in lists.

This is intended for demo purposes only.