package courseSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("is-palindrome/{word}")
    public String Palindrome(@PathVariable String word) {
        if (isPalindrome(word)) {
            return "La palabra " + word + " es un palíndromo";
        } else {
            return "La palabra " + word + " no es un palíndromo";
        }
    }

    private boolean isPalindrome(String word) {
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
