package ElasticsearchErrorHandling.errorHandling;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  int num1, num2;
          try {
             num1 = 0;
             num2 = 62 / num1;
          }
          catch (Exception e) { 
             ErrorHandling error=new ErrorHandling();
             error.writeOperations("You should not divide a number by zero");
          }
    
    }
}
