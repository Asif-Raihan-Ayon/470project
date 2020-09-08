public class Emailapp {

    public static void main(String[] args) 
    {
        Email em1 = new Email();

         em1.setAlternateEmail("asif.ayon@gmail.com");
         System.out.println(em1.getAlternateEmail());


        System.out.print(em1.showInfo());
    }

}
