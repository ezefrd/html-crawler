# HTML CRAWLER

This is a HTML Crawler that has been made with Java 11 and Gradle 4.10.2
The application has been developed using TDD, from the starting usecase "HtmlCrawler" with the needed entities, 
to the detail of the application that is used to consume the useCase..

I used a repository called DataProvider that has been developed to be a FileSystem but the app is ready to use another DataProvider with the condition of return a Document.

You can test the provided use cases using the HtmlCrawlerTest class or building and executing the app with this commands:

>`gradle fatJar`

>`java -jar ./build/libs/html-crawler-all-1.0-SNAPSHOT.jar ./src/test/resources/originalSource.html ./src/test/resources/similarSource1.html make-everything-ok-button`

And then you'll get something like: `#root >  html >  body >  div >  div >  div >  div >  div >  div > a` that it's the path to the most similar object in the similar html.

I think that this kind of answer, that it's what was required in the excercise it's not enought verbose to understand the similarity of the found element
But it's not hard to extend this answer and add things like the data in the found element and the % of similarity with the original element.

The algorithm used to found similar elements was something like "if I have an element with a tag and with attributes then I want the element in the similar html that has the most similarities with those tags and attributes"

** If you want to add a similar html then you have to add it in /src/test/resources folder
