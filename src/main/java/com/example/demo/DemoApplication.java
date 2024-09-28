package com.example.demo;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // Initialize Jansi for colored console output
        AnsiConsole.systemInstall();

        // Print text with background and foreground colors in the console
        System.out.println(Ansi.ansi()
                .bg(Ansi.Color.MAGENTA) // Background color: Magenta
                .fg(Ansi.Color.WHITE)   // Foreground color: White
                .a("Hello, Colorful World with Background in Console!") // Text content
                .reset());

        // Start Spring Boot application
        SpringApplication.run(DemoApplication.class, args);

        // Uninstall Jansi
        AnsiConsole.systemUninstall();
    }
}

@RestController
class HelloController {

    @GetMapping("/hello")
    public String hello() {
        // Return HTML content with background and text color for the browser
        return "<html><body style='background-color:magenta; color:white;'>" +
               "Hello, Colorful World with Background in Browser!" +
               "</body></html>";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello, World!";
    }
}
