package section6;

import br.com.learning.br.com.learning.section5.classes.generics.MaxKt;
import br.com.learning.br.com.learning.section6.Person;

public class HelloKotlinFromJava {

    public static void main(String[] args){
        Person person = new Person("Raphael", "Lima");

        System.out.println("His name is "+person.getFirstName()+" "+ person.getLastName());

        person.setFirstName("Sara");
        person.setLastName("Macedo");

        System.out.println("His new name is "+person.getFirstName()+" "+ person.getLastName());


        Integer maxInt = MaxKt.max(20015,2025); // quando acessar uma classe Kotlin que contenha apenas funções, ela é acessada como uma classe estática
        System.out.println("the max values is "+maxInt);
    }

}
