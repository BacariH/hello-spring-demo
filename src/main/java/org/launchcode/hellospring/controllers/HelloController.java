package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("form")
    public String displayForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='POST'>" +
                            "<label for='languages'>Type in your Name:</label>" +
                            "<input type='text' name='name'/>" +
                                "<select name='language'>" +
                                    "<option value='english'>English</option>" +
                                    "<option value='spanish'>Spanish</option>" +
                                    "<option value='japanese'>Japanese</option>" +
                                    "<option value='russian'>Russian</option>" +
                                    "<option value='german'>German</option>" +
                            "<input type='submit' value='Greet me!'/>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = {"hello"})
    public static String createMessage(@RequestParam String name, @RequestParam String language){

        String message = "";
        switch (language){
            case "english":
                message += "<html>" +
                        "<body>" +
                        "<div>" +
                        "<h1>English</h1>" +
                        "<p>Hello, " + name + "!</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                break;

            case "spanish":
                message += "<html>" +
                        "<body>" +
                        "<div>" +
                        "<h1>Spanish</h1>" +
                        "<p>Hola, " + name + "!</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                break;

            case "japanese":
                message += "<html>" +
                        "<body>" +
                        "<div>" +
                        "<h1>日本語</h1>" +
                        "<p>やっほ～, " + name + "!</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                break;

            case "russian":
                message += "<html>" +
                        "<body>" +
                        "<div>" +
                        "<h1>Русский</h1>" +
                        "<p>Прует, " + name + "!</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                break;

            case "german":
                message += "<html>" +
                        "<body>" +
                        "<div>" +
                        "<h1>Deutsch</h1>" +
                        "<p>Hallo, " + name + "!</p>" +
                        "</div>" +
                        "</body>" +
                        "</html>";
                break;
        }

        return message;
    }

    //method will take name as input and language as language to convert name into another language
    public static String changeToLanguage(String input, String language){
        String output = "";
        char[] brokenDownInput = input.toCharArray();
        switch (language){
            case "japanese":
                for( char eachChar: brokenDownInput){
                    if(eachChar == 'B'){
                        output += 'バ';
                    }
                    if (eachChar == 'c'){
                        output += 'カ';
                    }
                    if (eachChar == 'r'){
                        output += 'リ';
                    }
                }
                break;
        }



        return output;
    }
}
