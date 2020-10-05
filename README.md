# JavaFX + Spring Template

This is a template that put together JavaFX design application and Spring context
dependency injection.

## Why doing that?

[JavaFX](https://openjfx.io/) is a powerfull Rich Internet Application framework to
program GUI from java, with support to FXML (XML based language) that can be modelled
through graphical tool SceneBuilder. However the process of loading FXML from the
Java can be sometimes more complex, mainly when you need many different windows.

[Spring](https://spring.io/projects/spring-framework), on the other hand, is a vast
framework that has dependency injection as a mantra and allows the use of the concept
of contexts and beans, and create singletons that are accessible from any part of the
application. We can take advantage of it to make FXML pages more maintainable and
easily loadable.

## How to use it?

1. First clone this repository and make sure you have [Maven](https://maven.apache.org/) installed.
2. Create your pages in FXML (it can be done with SceneBuilder) and put
   them on the resources folder (see mainPage as example).
3. Go to `ui-beans.xml` to configure your page's singleton, which will
   be an instance of `FXMLView`. Add the `<bean>` tag accordingly, with
   a unique `id`.
```xml
<bean id="myPage" class="org.sample.springfx.FXMLView">
    <constructor-arg value="classpath:path/to/myPage.fxml" />
</bean>
```
4. Use the Spring context from anywhere in your application to access
   the JavaFX Scene associated with your view and its controller.
```java
FXMLView myView = App.context().getBean("myPage");
Scene myPageScene = myView.getScene();
MyController myController = myView.getController();
```
