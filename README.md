    
     /$$$$$$$$                                  /$$  /$$$$$$$$                    /$$
    |__  $$__/                                 | $$ |__  $$__/                   | $$    
       | $$ /$$  /$$  /$$  /$$$$$$   /$$$$$$  /$$$$$$  | $$  /$$$$$$   /$$$$$$$ /$$$$$$  
       | $$| $$ | $$ | $$ /$$__  $$ /$$__  $$|_  $$_/  | $$ /$$__  $$ /$$_____/|_  $$_/  
       | $$| $$ | $$ | $$| $$$$$$$$| $$$$$$$$  | $$    | $$| $$$$$$$$|  $$$$$$   | $$    
       | $$| $$ | $$ | $$| $$_____/| $$_____/  | $$ /$$| $$| $$_____/ \____  $$  | $$ /$$
       | $$|  $$$$$/$$$$/|  $$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$$ /$$$$$$$/  |  $$$$/
       |__/ \_____/\___/  \_______/ \_______/   \___/  |__/ \_______/|_______/    \___/  
                                                                                         

Test
----
1. Use java or javascript to get and display some tweets from Twitter for a passed in search term
2. Use java or javascript (the one you didn't use in #1) to output the language names (e.g., German, English) from this url <http://gmc.lingotek.com/language>
3. List the HTTP requests (i.e., request urls and parameters, response codes and results) and responses used for both #1 and #2 above
4. Use any language (ruby, python, java, javascript, php, C#) to compare two files programmatically.

Answers
-------
1. <http://tweet-test.herokuapp.com/#/search> OR <http://localhost:8080/#/search>
2. <http://tweet-test.herokuapp.com/#/lang> OR <http://localhost:8080/#/lang>
3. Click on the "See Raw" buttons in either answer.
4. <https://gist.github.com/milespomeroy/5431725>

*Note*: 1 and 2 were implemented together with Java and JavaScript through this repo.

How to Deploy Locally
---------------------

    $ mvn clean install
    $ java -jar target/tweettest-*.jar server config.yml

Resources Used
--------------
- <https://dev.twitter.com/console>
- <http://dropwizard.codahale.com/manual/>
- <https://jersey.java.net/nonav/documentation/latest/user-guide.html>
- <http://docs.oracle.com/javase/7/docs/api/>
- <http://angularjs.org>
- <http://wiki.fasterxml.com/JacksonInFiveMinutes>
- <http://stackoverflow.com/questions/1760654/java-printstream-to-string>
