import java.util.ArrayList;
import java.util.Scanner;
class VocabListDriver {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("play game? (yes/no)");
        String ans = input.next();
        if(ans.equals("yes")) {
            VocabListDriver Game = new VocabListDriver();
            Game.vocabQuiz();
        } else {
            String[] words = {"hello", "death", "buffalo", "clock"};
            String[] definitions = {"a greeting", "everything after life", "a big floofy boi",
                    "count the hours until spring break!"};

            VocabList dictionary = new VocabList(words, definitions);
            System.out.println("our dictionary \n" + dictionary);

            VocabList dic2 = new VocabList(dictionary);
            System.out.println("the copy \n" + dic2);

            System.out.println("size of dictionary: " + dictionary.size());
            System.out.println("is there doorhinge in this list?: " + dictionary.contains("doorhinge"));
            System.out.println("what does hello mean?: " + dictionary.getDefinition("hello"));
            System.out.println("cool, what word was that again?: " +  dictionary.getWord("a greeting"));
            System.out.println("random word!: " + dictionary.getRandomWord());
            System.out.println("random definition!: " + dictionary.getRandomDefinition());

            System.out.println("\nwe all know what clock means, lets remove it");
            dictionary.remove("clock");
            System.out.println(dictionary);
        }
    }

    public void vocabQuiz() {
        String[] words = {"accessorMethod", "class", "classVariable", "client",
                "constructor", "driver", "encapsulation", "helperMethod", "instance", 
                "instance", "instantiate", "interface", "mutatorMethod", "object",
                "overload", "private", "public", "static", "this"};
        String[] definitions = {"A public method that is used by driver classes to see the values of private instance variables without being able to change them",
                "A collection of data (variables) and behaviours (methods) that outlines the blueprint for creating a particular kind of software object. Defined by a programmer in the source code",
                "a ______________ is a static variable that is declared in the same place as instance variables. While objects get unique copies of the instance variables, all objects of the same class share just one copy of static variables. If you change the value of a static variable, then it changes for all objects at the same time.",
                "________ code refers to code that is outside of a class that refers to that class.",
                "A special method that is responsible for initializing an object’s instance variables. Inside the class, you can spot the method as it has no return type (not even void) and it’s name is exactly the same as the class’s name.",
                "A class that is external to another class but uses that other class is said to be a ________ class. Similar meaning to client code.",
                "This is the software engineering principal of packaging data with all the operations that are needed to operate on that data and protect that data. We practiced this in the Fraction class by making the Fractions infallible to the client",
                "A method that helps another method to perform its task. These are typically used when a method has to perform a complicated task that is composed of several smaller tasks. The smaller tasks are often performed by helper methods. Can be private or public, but usually is private to keep the interface clean.",
                "Another word for object.",
                "_______ variables are the data that objects of a particular class keep track of. Every object made from a particular class gets its own separate copy of the _________ variables.",
                "To _______ is to make an object of a particular class. It involves the new keyword and calling one of the class’s constructors. e.g. Fraction f1 = new Fraction(1,2);",
                "The public collection of methods for a particular class. These are the methods you can use to interact with objects of that class.",
                "A public method that is used by driver classes to change the values of private instance variables. These methods often contain error checking and data correction to account for incorrect or dangerous changes to the instance variables.",
                "what is created when a class is instantiated. if the class is a blueprint this is what the blueprint creates",
                "creating multiple methods with the same name and different parameters. e.g. multiple constructor methods",
                "variables and methods only accessible inside the class they are created",
                "variables and methods accessibly outside of the class they're created",
                "methods called from a class instead of an object",
                "refers to the object from which you're calling the method"};
        VocabList gameDictionary = new VocabList(words, definitions);
        System.out.println("AP scholars, what do they know? do they know things? let's find out!\n");
        System.out.println("Match the words to the given definitions\n");
        int score = 0;
        for(int i = 1; i < 11; i++) {
            String def = gameDictionary.getRandomDefinition();
            String ans = gameDictionary.getWord(def);
            System.out.println(i + ") " + def);
            String guess = "";
            int j = 0;
            while(j==0) {
                guess = input.next();
                if(guess.length()>0) j = 1;
            }

            if(guess.equals(ans)) {
                score++;
                System.out.println("Correct! Score: " + score + "\n");
            } else {
                System.out.println("Incorrect :( Score: " + score + "\nthe correct answer was: " + ans + "\n");
            }

           
         
            gameDictionary.remove(ans);
        }

    }
}
